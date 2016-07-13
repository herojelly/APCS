package ships;

import moves.*;

public class Schooner extends Ship {
	
	public Schooner() {
		setMaxHP(40);
		setSpeed(20);
		setMaxCrew(15);
		setMaxHeroes(2);
		setName("Schooner");
		setDescription("A modern ship for a modern age.");
		setPrice(120);
		setSellPrice(40);
		setHP(40);
		getMoves().add(new FireGuns());
		getMoves().add(new FireCannons());

	}
}
