import java.util.Scanner;

public class BrokenToaster {
	// Current streak of correct answers and high score
	private static int streak = 0;
	private static int highScore = 0;
	
	// Attributes of the toaster
	private String orientation = "right-side-up";
	private int slotsForToast = 1;
	private boolean isPluggedIn = true;
	private String temperature = "toasty";
	private String size = "regular sized";
	private boolean isAToaster = true;
	private boolean isLazy = false;
	
	// What is broken about the toaster
	// 0 is orientation, 1 is number of slots, 2 is if it's plugged in, 3 is the baking temp,
	// 4 is the size, 5 is if it's a toaster at all, 6 is its laziness
	private int wrongThing = -1;

	public BrokenToaster() {
		// Generates a random thing to be wrong with the toaster
		int randomNum = (int)(Math.random() * 11);
		switch (randomNum) {
			case 0:
				orientation = "upside-down"; 
				wrongThing = 0;
				break;
			case 1: 
				orientation = "sideways"; 
				wrongThing = 0;
				break;
			case 2: 
				slotsForToast = 0; 
				wrongThing = 1; 
				break;
			case 3: 
				slotsForToast = -1; 
				wrongThing = 1; 
				break;
			case 4: 
				isPluggedIn = false; 
				wrongThing = 2; 
				break;
			case 5: 
				isAToaster = false; 
				wrongThing = 5;
				break;
			case 6: 
				temperature = "frigid";
				wrongThing = 3;
				break;
			case 7: 
				temperature = "burning"; 
				wrongThing = 3;
				break;
			case 8: 
				size = "so small toast cannot fit in it"; 
				wrongThing = 4;
				break;
			case 9: 
				size = "microscopic"; 
				wrongThing = 4;
				break;
			case 10: 
				isLazy = true; 
				wrongThing = 6;
				break;
		}
	}

	public void play() {
		// Initialize scanner
		Scanner input = new Scanner(System.in);

		// Dialogue for the player
		System.out.println("Something is wrong with this toaster!");
		
		// The player chooses things to check about the toaster.
		// If they push 7, they get to guess what is wrong about the toaster.
		System.out.println("Choose something to check: ");
		System.out.println("(0) Orientation | (1) Number of slots | (2) Is it plugged in");
		System.out.println("(3) The baking temperature | (4) The size | (5) Is it a toaster");
		System.out.println("(6) How lazy is it | (7) I've found what's wrong");
		int something = input.nextInt();
		while (something != 7) {
			switch (something) {
				case 0: 
					System.out.println("Right now, the toaster is " + orientation); 
					break;
				case 1: 
					System.out.println("The toaster has " + slotsForToast + " slot(s) for toast"); 
					break;
				case 2: 
					if (isPluggedIn)
						System.out.println("The toaster is plugged in.");
					else
						System.out.println("The toaster is not plugged in.");
					break;
				case 3:
					System.out.println("The baking temperature is " + temperature);
					break;
				case 4:
					System.out.println("The toaster is " + size);
					break;
				case 5:
					if (isAToaster)
						System.out.println("It is a toaster.");
					else
						System.out.println("It is not a toaster.");
					break;
				case 6:
					if (isLazy)
						System.out.println("It is pretty lazy.");
					else
						System.out.println("The toaster is a hard worker.");
					break;
			}
			System.out.println("\nChoose something to check: ");
			System.out.println("(0) Orientation | (1) Number of slots | (2) Is it plugged in");
			System.out.println("(3) The baking temperature | (4) The size | (5) Is it a toaster");
			System.out.println("(6) How lazy is it | (7) Done");
			something = input.nextInt();
		}
		
		// When the player chooses 7, they get to guess what is wrong with the toaster.
		System.out.println("\nWhat is wrong with the toaster?");
		System.out.println("(0) Not right-side-up | (1) Not enough slots | (2) Not plugged in");
		System.out.println("(3) Temp too high/low | (4) Too small/big | (5) Isn't a toaster");
		System.out.println("(6) Too lazy to make toast |");
		int answer = input.nextInt();
		
		// Checks if the player is right and updates their winstreak.
		if (answer == wrongThing) {
			System.out.println("Congrats! You fix the toaster and go on your merry way.");
			streak++;
		}
		else {
			System.out.println("Sorry! Try again next time.");
			streak = 0;
		}
		if (streak > highScore) {
			highScore = streak;
		}
		System.out.println("Your current streak is: " + streak);
		System.out.println("Your high score is: " + highScore + "\n\n");
	}

	public static void main(String[] args) {
		// Creates scanner object
		Scanner input = new Scanner(System.in);
		while (true) {
			// User pushes enter every time he wishes to generate a new toaster to fix.
			System.out.println("Press <Enter> to generate a new toaster.");
			input.nextLine();
			BrokenToaster b = new BrokenToaster();
			b.play();
		}

	}

}
