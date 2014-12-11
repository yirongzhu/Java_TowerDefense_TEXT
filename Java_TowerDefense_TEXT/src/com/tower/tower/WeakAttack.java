package com.tower.tower;

public class WeakAttack implements AttackBehavior {

	/**
	 * Weak Attack for Weak tower 
	 */
	public WeakAttack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.tower.tower.AttackBehavior#attack()
	 * Attack method of the weak tower class
	 */
	public int attack() {
		return 70;
	}
}
