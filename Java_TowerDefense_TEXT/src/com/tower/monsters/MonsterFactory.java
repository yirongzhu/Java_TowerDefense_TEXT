package com.tower.monsters;

/**
 * @author Tower Defense
 * This is the factory class for creating monsters
 *
 */

public class MonsterFactory {

	public MonsterFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param monster
	 * @return
	 * Factory desing pattern for creating monsters
	 */
	public Monster creatMonster(String monster) {
		if (monster.equals("Powerful")) {
			return new BossMonster();
		}
		else if (monster.equals("Normal")) {
			return new NormalMonster();
		}
		else if (monster.equals("Weak")) {
			return new JumpMonster();
		}
		else {
			return null;
		}
	}
}
