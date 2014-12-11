package com.tower.tower;

/**
 * @author Tower Defense
 * It is the powerful tower attack class.
 */
public class PowerfulAttack implements AttackBehavior {

	public PowerfulAttack() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.tower.tower.AttackBehavior#attack()
	 * Attack functionality of powerful tower
	 */
	public int attack() {
		return 200;
	}
}
