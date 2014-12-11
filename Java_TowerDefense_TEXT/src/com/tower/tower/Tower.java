package com.tower.tower;

/**
 * @author Tower Defense
 * This is the tower class
 */
public abstract class Tower {

	/**
	 * creates an object of attackBehaviour class
	 */
	protected AttackBehavior attackBehavior;
	protected int pointsCost;
	
	/**
	 * @param attackBehavior
	 * constructor 
	 */
	public Tower() {
		
	}
	
	/**
	 * @param attackBehavior
	 * setter for tower class
	 */
	public void setPrice(int pointsCost) {
		this.pointsCost = pointsCost;
	}
	
	public int getPrice() {
		return pointsCost;
	}
	
	public Tower(AttackBehavior attackBehavior) {
		this.attackBehavior = attackBehavior;
	}
	
	public void setAttackBehavior(AttackBehavior attackBehavior) {
		this.attackBehavior = attackBehavior;
	}
	
	public int performAttackBehavior() {
		return attackBehavior.attack();
	}
	
	public abstract String toString();
}
