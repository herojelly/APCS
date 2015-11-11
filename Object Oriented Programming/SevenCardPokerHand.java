/* Code by Gregory Jerian
 * Think AP Java Problem 15.5
 * Period 4 APCS */

public class SevenCardPokerHand extends Deck {

	/** Main method. Finds the probability of getting all the different poker hands using a set number of simulations. */
	public static void main(String[] args) {
		final int NUM_OF_HANDS = 10000000; // Modify this value based on the number of simulations you wish to run

		// Generates hands and increments the amount of each type of poker hand received.
		for (int i = 0; i < NUM_OF_HANDS; i++) {
			SevenCardPokerHand hand = new SevenCardPokerHand();
			hand.deal();
			hand.increment();
		}
		printSummary(NUM_OF_HANDS); 		// prints a summary at the end
	}

	// Data fields
	Card[] hand = new Card[7];
	int[] amountsOfEachSuit = new int[4];
	int[] amountsOfEachRank = new int[14];
	static int straightFlushes, fourOfAKinds, fullHouses, flushes,  straights,
	threeOfAKinds, twoPairs, onePairs, highCards;
	/*
	 * Returns index of the first location where card appears in deck.
	 * Or -1 if it does not appear.  Uses a linear search.
	 */
	public int findCardinHand (Card card) {
		for (int i = 0; i< hand.length; i++) {
			if (card.equals(hand[i])) {
				return i;
			}
		}
		return -1;
	}

	/** Deals a new poker hand. Also finds the number of each rank and number of each suit in the hand. */
	public SevenCardPokerHand deal() {
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < 7; i++) {
			hand[i] = deck.cards[i];
		}
		amountsOfEachRank = findAmountsOfEachRank();
		amountsOfEachSuit = findAmountsOfEachSuit();
		return this;
	}

	/** A method that prints the cards in a hand. */
	@Override
	public void print() {
		for (int i = 0; i < 7; i++) {
			System.out.println(hand[i]);
		}
	}

	/** Finds the number of cards in the hand from each rank. Used in later methods to determine poker hands. */
	public int[] findAmountsOfEachRank() {
		int[] amountsOfEachRank = new int[14];
		for (int i = 0; i < 7; i++)
			amountsOfEachRank[hand[i].rank]++;
		return amountsOfEachRank;
	}

	/** Finds the number of cards in the hand from each suit. Used in later methods to determine poker hands. */
	public int[] findAmountsOfEachSuit() {
		int[] amountsOfEachSuit = new int[4];
		for (int i = 0; i < 7; i++)
			amountsOfEachSuit[hand[i].suit]++;
		return amountsOfEachSuit;
	}

	/** Checks if the hand contains a straight. Used to find straights and straight flushes. */
	public boolean handContainsAStraight() {
		for (int i = 0; i < 10; i++) {
			if (amountsOfEachRank[i] >= 1 && amountsOfEachRank[i+1] >= 1 && amountsOfEachRank[i+2] >= 1 &&
					amountsOfEachRank[i+3] >= 1 && amountsOfEachRank[i+4] >= 1) {
				return true;
			}
		}
		return false;
	}

	public boolean handContainsAStraightFlush() {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count = 0;
			if (amountsOfEachSuit[i] >= 5) {
				for (int k = 1; k < 14; k++) {
					int pos =  findCardinHand(new Card(i,k));
					if (pos >= 0) {
						count++;
						//hand[pos].print();
						//System.out.println("count="+count+ " i="+ i + " k="+k);
					}
					else {
						count = 0;
					}
					if (count == 5) {
						//print();
						//System.out.println("----");
						return true;
					}
				}
			}
		}
		return false;
	}

	/** Checks if the hand contains a flush. Used to find flushes and straight flushes. */
	public boolean handContainsAFlush() {
		for (int i = 0; i < 4; i++) {
			if (amountsOfEachSuit[i] >= 5)
				return true;
		}
		return false;
	}

	/** Checks if the hand contains a three of a kind. Used to find three of a kinds and full houses. */
	public boolean handContainsThreeOfAKind() {
		for (int i = 1; i < 14; i++) {
			if (amountsOfEachRank[i] == 3)
				return true;
		}
		return false;
	}

	/** Checks if the hand contains a pair of the same rank. Use to find one pairs, two pairs, and full houses. */
	public boolean handContainsOnePair() {
		for (int i = 1; i < 14; i++) {
			if (amountsOfEachRank[i] == 2)
				return true;
		}
		return false;
	}

	/** Checks to see if the hand contains two pair. */
	public boolean handContainsTwoPair() {
		int amountOfPairs = 0;
		for (int i = 1; i < 14; i++) {
			if (amountsOfEachRank[i] == 2)
				amountOfPairs++;
		}
		if (amountOfPairs >= 2)
			return true;
		else
			return false;
	}

	/** Checks to see if the hand contains four of a kind. */
	public boolean handContainsFourOfAKind() {
		for (int i = 1; i < 14; i++) {
			if (amountsOfEachRank[i] == 4)
				return true;
		}
		return false;
	}

	/** Returns true or false based on if the hand is or is not a straight flush. */
	public boolean hasStraightFlush() {
		return handContainsAStraightFlush();
	}

	/** Returns true or false based on if the hand is or is not a straight. */
	public boolean hasStraight() {
		return handContainsAStraight() && !handContainsAFlush();
	}

	/** Returns true or false based on if the hand is or is not a flush. */
	public boolean hasFlush() {
		return handContainsAFlush() && !handContainsAStraightFlush() && !handContainsFourOfAKind();
	}

	/** Returns true or false based on if the hand is or is not a three of a kind. */
	public boolean hasThreeOfAKind() {
		return handContainsThreeOfAKind() && !handContainsOnePair() && !handContainsAFlush() &&
				!handContainsAStraight();
	}

	/** Returns true or false based on if the hand is or is not a one pair. */
	public boolean hasOnePair() {
		return handContainsOnePair() && !handContainsThreeOfAKind() && !handContainsTwoPair() &&
				!handContainsAStraight() && !handContainsAFlush() && !handContainsFourOfAKind();
	}

	/** Returns true or false based on if the hand is or is not a full house. */
	public boolean hasFullHouse() {
		return handContainsOnePair() && handContainsThreeOfAKind() && !handContainsFourOfAKind();
	}

	/** Returns true or false based on if the hand is or is not a four of a kind. */
	public boolean hasFourOfAKind() {
		return handContainsFourOfAKind();
	}

	/** Returns true or false based on if the hand is or is not a two pair. */
	public boolean hasTwoPair() {
		return handContainsTwoPair()&& !handContainsThreeOfAKind() && !handContainsAStraight() &&
				!handContainsAFlush() && !handContainsFourOfAKind();
	}

	/** Returns true or false based on if the hand is or is not a high card. */
	public boolean hasHighCard() {
		return !handContainsOnePair() && !handContainsAFlush() && !handContainsThreeOfAKind() &&
				!handContainsAStraight() && !handContainsFourOfAKind(); // Checks if the hand could be anything else.
	}

	/** Used in all probability print statements. Finds the experimental probability of 
	 * getting a specific poker hand. */
	public static double probability(int amountOfThisHand, final int NUM_OF_HANDS) {
		return 100.0 * amountOfThisHand / NUM_OF_HANDS;
	}

	/** Updates the amount of each poker hand. */
	public void increment() {
		if (hasStraightFlush())
			straightFlushes++;
		if (hasFourOfAKind())
			fourOfAKinds++;
		if (hasFullHouse())
			fullHouses++;
		if (hasFlush())
			flushes++;
		if (hasStraight())
			straights++;
		if (hasThreeOfAKind())
			threeOfAKinds++;
		if (hasTwoPair())
			twoPairs++;
		if (hasOnePair())
			onePairs++;
		if (hasHighCard())
			highCards++;
	}

	/** Prints out the number of each type of hand and the experimental probability of receiving it. */
	public static void printSummary(final int NUM_OF_HANDS) {
		System.out.println("Straight flushes: " + straightFlushes);
		System.out.println("Four of a kinds: " + fourOfAKinds);
		System.out.println("Full Houses: " + fullHouses);
		System.out.println("Flushes: " + flushes);
		System.out.println("Straights: " + straights);
		System.out.println("Three of a kinds: " + threeOfAKinds);
		System.out.println("Two pairs: " + twoPairs);
		System.out.println("One pairs: " + onePairs);
		System.out.println("High Cards: " + highCards);
		System.out.println("TOTAL NUMBER OF HANDS: " + NUM_OF_HANDS);
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("probability of getting a straight flush: " + probability(straightFlushes, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a four of a kind: " + probability(fourOfAKinds, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a full house: " + probability(fullHouses, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a flush: " + probability(flushes, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a straight: " + probability(straights, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a three of a kind: " + probability(threeOfAKinds, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a two pair: " + probability(twoPairs, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a one pair: " + probability(onePairs, NUM_OF_HANDS) + "%");
		System.out.println("probability of getting a high card: " + probability(highCards, NUM_OF_HANDS) + "%");
		double totalProb = (probability(straightFlushes, NUM_OF_HANDS) + probability(fourOfAKinds, NUM_OF_HANDS) +
				probability(fullHouses, NUM_OF_HANDS) + probability(flushes, NUM_OF_HANDS) + probability(straights, NUM_OF_HANDS) +
				probability(threeOfAKinds, NUM_OF_HANDS) + probability(twoPairs, NUM_OF_HANDS) + probability(onePairs, NUM_OF_HANDS)
				+ probability(highCards, NUM_OF_HANDS));
		System.out.println("Total probability: " + totalProb + "%");
	}

}
