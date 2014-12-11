package com.tower.monsters;

import com.tower.map.Map;

/**
 * @author Tower Defense
 * This is used to move monster by one step.
 *
 */
public class OneStepMovable extends Movable {

	public OneStepMovable() {
		step = 1;
	}

	public void move(Map map, Monster monster) {
		moveToFillMap(map, monster);
	}
}
