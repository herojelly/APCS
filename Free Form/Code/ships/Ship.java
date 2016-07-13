package ships;

import java.util.ArrayList;

import items.*;
import moves.*;

public class Ship extends Item {
	private int maxHP;
	private int speed;
	private int maxCrew;
	private int maxHeroes;
	private int HP;
	private ArrayList<Move> moves = new ArrayList<Move>();
	
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMaxCrew() {
		return maxCrew;
	}
	public void setMaxCrew(int maxCrew) {
		this.maxCrew = maxCrew;
	}
	public int getMaxHeroes() {
		return maxHeroes;
	}
	public void setMaxHeroes(int maxHeroes) {
		this.maxHeroes = maxHeroes;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int HP) {
		this.HP = HP;
	}
	public ArrayList<Move> getMoves() {
		return moves;
	}
	public void setMoves(ArrayList<Move> moves) {
		this.moves = moves;
	}

	
}
