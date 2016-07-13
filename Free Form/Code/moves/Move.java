package moves;

import main.Inventory;

public class Move {
	private int damage;
	private String name;
	private String description;
	private int rangeOfDamage;
	private int healAmt;
	private int rangeOfHeal;
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRangeOfDamage() {
		return rangeOfDamage;
	}
	public void setRangeOfDamage(int rangeOfDamage) {
		this.rangeOfDamage = rangeOfDamage;
	}
	public int getHealAmt() {
		return healAmt;
	}
	public void setHealAmt(int healAmt) {
		this.healAmt = healAmt;
	}
	public int getRangeOfHeal() {
		return rangeOfHeal;
	}
	public void setRangeOfHeal(int rangeOfHeal) {
		this.rangeOfHeal = rangeOfHeal;
	}
	
	
	@Override
	public String toString() {
		return name;	
	}

}
