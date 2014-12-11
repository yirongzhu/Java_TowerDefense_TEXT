package com.tower.monsters;

import com.tower.tower.Tower;
import com.tower.tower.TowerFactory;
import com.tower.map.Map;


public abstract class Monster {
	
	protected int blood;
	protected Movable movable;
	protected TowerFactory tf;
	
	public Monster() {
		
	}
	
	/**
	 * @param blood
	 * @param movable
	 * @param tf
	 * This is the constructor of monstter class
	 */
	public Monster(int blood, Movable movable, TowerFactory tf) {
		super();
		this.blood = blood;
		this.movable = movable;
		this.tf = tf;
	}
	
	/**
	 * @param blood
	 * Setter for blood
	 */
	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	/**
	 * @return
	 * Getter for Blood
	 */
	public int getBloodRemained() {
		return blood;
	}
	
	/**
	 * @return
	 * Checks if monster is dead or not
	 */
	public boolean isDead() {
		return blood <= 0 ? true : false;
	}
	
	/**
	 * @param b
	 * increases the blood of the monster.
	 */
	public void addBlood(int b) {
		blood += b;
	}
	
	/**
	 * @param b
	 * Decreases the blood of the monster
	 */
	public void decreaseBlood(int b) {
		blood -= b;
	}
	
	/**
	 * @param t
	 * Checks if the monster is dead.
	 * If mosnter is dead then decreases the blood of the monster
	 */
	public void meetTower(String t) {
		tf = new TowerFactory();
		Tower tower = tf.creatTower(t);
		if (isDead()) {
			return;
		}
		blood -= tower.performAttackBehavior();
	}
	
	public abstract boolean getStarted(Map map);

	/**
	 * @return
	 * Getter for movable 
	 */
	public Movable getMovable() {
		return movable;
	}

	/**
	 * @param movable
	 * Setter for movable 
	 */
	public void setMovable(Movable movable) {
		this.movable = movable;
	}

	public TowerFactory getTf() {
		return tf;
	}

	public void setTf(TowerFactory tf) {
		this.tf = tf;
	}

	/**
	 * @return
	 * Getter for blood
	 */
	public int getBlood() {
		return blood;
	}
	
	public abstract String toString();
}
