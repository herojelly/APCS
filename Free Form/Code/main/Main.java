package main;
import ships.*;

import java.util.*;

import moves.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		tutorial();
		while (true) {
			if (Inventory.getShip().getHP() <= 0) {
				System.out.println("You died! Fear not, for you have been healed back to full health.");
				heal();
				System.out.println("----------------------------------");			}
			System.out.print("\nWhat do you want to do? [FIGHT, MOVES, INVENTORY, SHIP, HEAL] ");
			String s = input.nextLine();
			if (s.toUpperCase().equals("INVENTORY")) {
				System.out.println("----------------------------------");
				System.out.println(Inventory.getShip());
				System.out.println("----------------------------------");
			}
			else if (s.toUpperCase().equals("FIGHT")) {
				fight();
			}
			else if (s.toUpperCase().equals("MOVES")) {
				moves();
			}
			else if (s.toUpperCase().equals("SHIP")) {
				ship();
			}
			else if (s.toUpperCase().equals("HEAL")) {
				heal();
			}
		}
	}

	private static void tutorial() {
		System.out.println("This is where Matt Damon will talk.");
		System.out.println("Hey man! You want a ship?");
		Inventory.setShip(new StarterShip());
		System.out.println("Cool!");
	}
	
	private static void heal() {
		Inventory.getShip().setHP(Inventory.getShip().getMaxHP());
	}

	private static void fight() {
		System.out.println("----------------------------------");
		Scanner input = new Scanner(System.in);
		StarterShip c = new StarterShip();
		while (true) {
			System.out.println("Your HP: " + Inventory.getShip().getHP() + ". Enemy HP: " + c.getHP() + ".");
			
			// PLAYER'S MOVE
			System.out.print("Choose a move " + Inventory.getShip().getMoves() + ": ");
			Move m = moveScanner(input.nextLine());
			if (m == null) {
				System.out.println("You did nothing!");
			}
			else {
				int rangeOfDamage = (int)(Math.random() * 2 * (m.getRangeOfDamage())) - m.getRangeOfDamage();
				int damage = m.getDamage() + rangeOfDamage;
				System.out.println("You did " + damage + " damage!");
				c.setHP(c.getHP() - damage);
			}
			if (c.getHP() <= 0) {
				System.out.println("You win!");
				break;
			}
			
			// ENEMY'S MOVE
			Move enemyMove = c.getMoves().get((int)(Math.random() * c.getMoves().size()));
			int rangeOfDamage = (int)(Math.random() * 2 * (enemyMove.getRangeOfDamage())) - enemyMove.getRangeOfDamage();
			int damage = enemyMove.getDamage() + rangeOfDamage;
			System.out.println("Enemy used " + enemyMove + " for " + damage + " damage.");
			Inventory.getShip().setHP(Inventory.getShip().getHP() - damage);
			
			if (Inventory.getShip().getHP() <= 0) {
				System.out.println("Enemy " + c.getName() + " wins!");
				break;
			}
			System.out.println();
			
		}
		System.out.println("----------------------------------");
	}

	private static void moves() {
		System.out.println("----------------------------------");
		for (int i = 0; i < Inventory.getShip().getMoves().size(); i++) {
			System.out.println("Name: " + Inventory.getShip().getMoves().get(i).getName());
			System.out.println("Description: "  + Inventory.getShip().getMoves().get(i).getDescription());
			System.out.println("Current Damage: " + Inventory.getShip().getMoves().get(i).getDamage() + " +/- " +
					Inventory.getShip().getMoves().get(i).getRangeOfDamage());
			System.out.println();
		}
		System.out.println("----------------------------------");		
	}

	private static void ship() {
		System.out.println("----------------------------------");
		System.out.println("Name: " + Inventory.getShip().getName());
		System.out.println("Description: "  + Inventory.getShip().getDescription());
		System.out.println("HP: " + Inventory.getShip().getHP() + "/" + Inventory.getShip().getMaxHP());
		System.out.println("Speed: " + Inventory.getShip().getSpeed());
		System.out.println("Heroes: unimplemented");
		System.out.println("Sell Price: $" + Inventory.getShip().getSellPrice());
		System.out.println("----------------------------------");
	}

	private static Move moveScanner(String s) {
		if (s.toUpperCase().equals("FIRE GUNS")) {
			return new FireGuns();
		}
		else if (s.toUpperCase().equals("REPAIR")) {
			return new Repair();
		}
		else {
			return null;
		}
	}

}
