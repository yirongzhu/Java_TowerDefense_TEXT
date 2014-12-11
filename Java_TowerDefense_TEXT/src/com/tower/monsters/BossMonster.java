package com.tower.monsters;

import com.tower.map.Map;

/**
 * @author Tower Defense
 *	It is a subclass of Monster class. This is used for Boss Monster.
 */

public class BossMonster extends Monster {

	public BossMonster() {
		blood = 300;
		movable = new OneStepMovable();
	}
	
	public boolean getStarted(Map map) {
		movable.move(map, this);
		return movable.winOrNot();
	}

	@Override
	public String toString() {
		return "Powerful";
	}

}
