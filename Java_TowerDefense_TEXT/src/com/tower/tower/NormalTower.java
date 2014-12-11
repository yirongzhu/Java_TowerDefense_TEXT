package com.tower.tower;

/**
 * @author Tower Defense
 * It is the normal tower class
 */
public class NormalTower extends Tower {

	/**
	 * @param attackBehavior
	 * It is the constructor 
	 */
	public NormalTower(AttackBehavior attackBehavior) {
		super(attackBehavior);
		// TODO Auto-generated constructor stub
	}

	/**
	 * It calls the attack functionality of the normal tower 
	 */
	public NormalTower() {
		super(new NormalAttack());
		pointsCost = 100;
	}
	
	public String toString() {
		return "Normal";
	}
}
