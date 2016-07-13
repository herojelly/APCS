package main;
import ships.Ship;

public class Inventory {
	private static Ship ship = new Ship();

	public static Ship getShip() {
		return ship;
	}
	public static void setShip(Ship ship) {
		Inventory.ship = ship;
	}


}
