package com.tower.tower;

/**
 * @author Tower Defense
 * It is the class for powerful tower.
 *
 */
public class PowerfulTower extends Tower{

	public PowerfulTower(AttackBehavior attackBehavior) {
		super(attackBehavior);
		// TODO Auto-generated constructor stub
	}

	/**
	 * It calls the attck functionality of the powerful tower. 
	 */
	public PowerfulTower() {
		super(new PowerfulAttack());
		pointsCost = 150;
	}

	public String toString() {
		return "Powerful";
	}
}
