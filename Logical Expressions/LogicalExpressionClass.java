/** Gregory Jerian
 *  Period 4 APCS
 *  12/10/15
 *  Credits to Sean, Shivum, Jerry, Blake. More detailed in readme. */

import java.util.*;
import java.util.concurrent.*;

public class LogicalExpressionClass implements LogicalExpression {
	// A whole lot of data structures. Jesus. All of these do things.
	private String exp;
	private ArrayList<Character> array = new ArrayList<Character>();
	private Stack<Character> stack = new Stack<Character>();
	private ArrayBlockingQueue<Character> queue;
	private ArrayList<Character> vars = new ArrayList<Character>();
	private int[][] truthTable;
	private ArrayList<Integer> answers = new ArrayList<Integer>();
	private ArrayList<Character> RPN = new ArrayList<Character>();

	/** Constructor. Sets the string passed in. Runs all the methods (more or less).
	 *  @param exp: String passed in. */
	public LogicalExpressionClass(String exp) {
		this.exp = exp;
		fillArray();
		findVars();
		queue = new ArrayBlockingQueue<Character>(array.size());
		ShuntingYard();
			System.out.println("\nReverse Polish Notation: " + queue);
		queueToArray();
		truthTable();
		System.out.println("Answers: " + answers);
	}

	/** Turns the string into an array. */
	public void fillArray() {
		for (int i = 0; i < exp.length(); i++)
			array.add(exp.charAt(i));
	}

	/** Finds all the variables in the array and sets the array. */
	public void findVars() {
		for (int i = 0; i < array.size(); i++) {
			if (isVar(array.get(i)) && !vars.contains(array.get(i))) {
				vars.add(array.get(i));
			}
		}
		Collections.sort(vars);
	}

	/** Applies shunting yard algorithm to turn infix into reverse polish. */
	public void ShuntingYard(){
		for (int i = 0; i < array.size(); i++) {
			if (isVar(array.get(i))) {
				Character q = array.get(i);
				queue.add(q);
			}
			else if (isNot(array.get(i)) || isAndOrOr(array.get(i))) {
				while (!stack.empty() && greaterPrecedence(array.get(i), stack.peek())) {
					Character q3 = stack.pop();
					queue.add(q3);
				}
				Character q2 = array.get(i);
				stack.add(q2);
			}
			else if (array.get(i) == '(') {
				stack.add(array.get(i));
			}
			else {
				while (!stack.empty() && stack.peek() != '(') {
					Character x = stack.pop();
					queue.add(x);
				}
				if (!stack.empty()) {
					stack.pop();
				}
			}
		}
		while(!stack.empty()) {
			queue.add(stack.pop());
		}
	}

	/** Checks if C2 has a greater precedence than C1 */
	public static boolean greaterPrecedence(char c1, char c2) {
		if (c2 == '(') {
			return false; /* ( is less than everything*/
		}
		if (c1 == '~') {
			if (c2 == '~')
				return true;
			else
				return false;
		}
		else if (c1 == '&') {
			if (c2 == '&' || c2 == '~')
				return true;
			else
				return false;
		}
		else
			return true;

	}

	/** Generates a truth table based on the number of variables. */
	public void truthTable() {
		int numColumns = vars.size();
		int numRows = (int) Math.pow(2,numColumns);
		truthTable = new int[numColumns][numRows];
		for (int i = 0; i < numRows; i++) {
			for (int j = numColumns - 1; j >= 0; j--) {
				truthTable[j][i] = (i / (int) Math.pow(2, j)) % 2;
			}
		}

		ArrayBlockingQueue<Character> tempQueue;
		for (int row = 0; row < numRows; row++) {
			tempQueue = new ArrayBlockingQueue<Character>(RPN.size());
			int column = 0;
			for (int index = 0; index < RPN.size(); index++) {
				if (isVar(RPN.get(index)) && column < numColumns) {
					column = vars.indexOf(RPN.get(index));
					int num = truthTable[column][row];
					if (num == 0)
						tempQueue.add('0');
					else
						tempQueue.add('1');
				}
				else if (isNot(RPN.get(index)))
					tempQueue.add('~');
				else {
					if (RPN.get(index) == '&')
						tempQueue.add('&');
					else
						tempQueue.add('|');
				}
			}
			System.out.println(tempQueue);
			int retval = evaluate(tempQueue);
			answers.add(retval);
			
		}
		

		//		for (int i = 0; i < numRows; i++) {
		//			for (int j = 0; j < numColumns; j++) {
		//				System.out.print(truthTable[j][i] + " ");
		//			}
		//			System.out.println();
		//		}
	}

	/** Evaluates using a stack. Real cool stuff.*/
	public static int evaluate(Queue<Character> inQueue) {
		Stack<Character> tempStack = new Stack<Character>();
		int size = inQueue.size();
		for (int i = 0; i < size; i++) {
			if (!inQueue.isEmpty() && isVar(inQueue.peek()))
				tempStack.add(inQueue.remove());
			else if (!inQueue.isEmpty() && isNot(inQueue.peek())) {
				inQueue.remove();
				char temp = tempStack.pop();
				if (temp == '0')
					tempStack.add('1');
				else
					tempStack.add('0');
			}
			else if (!inQueue.isEmpty() && isAndOrOr(inQueue.peek())) {
				char operator = inQueue.remove();
				char operand2 = tempStack.pop();
				char operand1 = tempStack.pop();
				if (operator == '|') {
					if (operand1 == '0') {
						if (operand2 == '0')
							tempStack.add('0');
						else
							tempStack.add('1');
					}
					else
						tempStack.add('1');
				}
				else {
					if (operand1 == '0')
						tempStack.add('0');
					else {
						if (operand2 == '0')
							tempStack.add('0');
						else
							tempStack.add('1');
					}
				}
			}

		}
		if (tempStack.peek() == '0')
			return 0;
		else
			return 1;
	}


	/** Turns a queue into an array. */
	public void queueToArray() {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			RPN.add(queue.remove());
		}
		for (int i = 0; i < size; i++) {
			queue.add(RPN.get(i));
		}
	}
	
	/** Sees if the char is an and or an or. */
	public static boolean isAndOrOr(char ch) {
		return ch == '&' || ch == '|';
	}

	/** Sees if the char is not. */
	public static boolean isNot(char ch) {
		return ch == '~';
	}

	/** Sees if the char is a parentheses. */
	public static boolean isParentheses(char ch) {
		return ch == '(' || ch == ')';
	}

	/** Sees if the char is a variable. */
	public static boolean isVar(char ch) {
		return isParentheses(ch) == false && isAndOrOr(ch) == false && isNot(ch) == false;
	}
	
	/** Accesses the answers array. */
	public ArrayList<Integer> getAnswers() {
		return answers;
	}
	
	/** Sees if the expression is valid. */
	public boolean valid() {
		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i) == 0)
				return false;
		}
		return true;
	}
	
	/** Sees if the expression is satisfiable. */
	public boolean satisfiable() {
		return valid() || contingent();
	}
	
	/** Sees if the expression is contingent. */
	public boolean contingent() {
		boolean atLeastOneTrue = false;
		boolean atLeastOneFalse = false;
		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i) == 0)
				atLeastOneFalse = true;
			else
				atLeastOneTrue = true;
			if(atLeastOneFalse && atLeastOneTrue)
				return true;
		}
		return false;
	}
	
	/** Sees if the expression is equivalent to another expression. */
	public int equivalent(LogicalExpressionClass that) {
		for (int i = 0; i < answers.size(); i++) {
			if (this.answers.get(i) != that.getAnswers().get(i))
				return -1;
		}
		return 1;
	}
	
	/** Sees if the expression entails another expression. */
	public int entails(LogicalExpressionClass that) {
		for (int i = 0; i < answers.size(); i++) {
			if (this.answers.get(i) == 1) {
				if (that.answers.get(i) == 0)
					return -1;
			}
		}
		return 1;
	}
	
	/** Main method. Runs several tests. */
	public static void main(String[] args) { 
		LogicalExpressionClass logic = new LogicalExpressionClass("a&b|c");
		System.out.println("Contingent? " + logic.contingent());
		System.out.println("Valid? " + logic.valid());
		System.out.println("Satisfiable? " + logic.satisfiable());
		LogicalExpressionClass logic2 = new LogicalExpressionClass("p");
		System.out.println("Contingent? " + logic2.contingent());
		System.out.println("Valid? " + logic2.valid());
		System.out.println("Satisfiable? " + logic2.satisfiable());
		LogicalExpressionClass logic3 = new LogicalExpressionClass("~p&q");
		System.out.println("Contingent? " + logic3.contingent());
		System.out.println("Valid? " + logic3.valid());
		System.out.println("Satisfiable? " + logic3.satisfiable());
		LogicalExpressionClass logic4 = new LogicalExpressionClass("b|c&a");
		System.out.println("Contingent? " + logic4.contingent());
		System.out.println("Valid? " + logic4.valid());
		System.out.println("Satisfiable? " + logic4.satisfiable());
		System.out.println(logic2.equivalent(logic3));
		System.out.println(logic2.entails(logic3));
	}
}