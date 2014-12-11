package com.tower.tower;

public class WeakTower extends Tower{

	/**
	 * @param attackBehavior
	 * Weak Tower Class
	 * 
	 */
	public WeakTower(AttackBehavior attackBehavior) {
		super(attackBehavior);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calls the attack method for the weak attack tower
	 */
	public WeakTower() {
		super(new WeakAttack());
		pointsCost = 50;
	}

	public String toString() {
		return "Weak";
	}
}
