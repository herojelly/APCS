package moves;

public class Repair extends Move {
	public Repair() {
		setName("Repair");
		setDescription("You attempt to repair your ship on the go.");
		setRangeOfHeal(2);
		setHealAmt(5);
	}
}
