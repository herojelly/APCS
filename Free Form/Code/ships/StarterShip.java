package ships;

import moves.*;

public class StarterShip extends Ship {
	
	public StarterShip() {
		setMaxHP(20);
		setSpeed(16);
		setMaxCrew(5);
		setMaxHeroes(1);
		setName("Starter Ship");
		setDescription("Well, at least it floats.");
		setPrice(0);
		setSellPrice(10);
		setHP(20);
		getMoves().add(new FireGuns());
	}
	
}
