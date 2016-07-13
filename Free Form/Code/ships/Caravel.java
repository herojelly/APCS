package ships;

import moves.*;

public class Caravel extends Ship {

	public Caravel() {
		setMaxHP(30);
		setSpeed(20);
		setMaxCrew(8);
		setMaxHeroes(1);
		setName("Caravel");
		setDescription("Built for speed.");
		setPrice(60);
		setSellPrice(20);
		setHP(30);
		getMoves().add(new FireGuns());
		getMoves().add(new FireCannons());

	}
}
