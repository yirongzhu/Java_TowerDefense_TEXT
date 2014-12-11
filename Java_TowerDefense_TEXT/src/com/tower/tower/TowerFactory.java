package com.tower.tower;

/**
 * @author Tower Defense
 * This is the factory design patter for the tower class
 */
public class TowerFactory {

	public TowerFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tower
	 * @return
	 * Method to implement factory design patter for tower class
	 */
	public Tower creatTower(String tower) {
		if (tower.equals("Powerful")) {
			return new PowerfulTower();
		}
		else if (tower.equals("Normal")) {
			return new NormalTower();
		}
		else if (tower.equals("Weak")) {
			return new WeakTower();
		}
		else {
			return null;
		}
	}
}
