package com.tower.monsters;

import com.tower.map.Map;

public class TwoStepMovable extends Movable {

	/**
	 * Moves the monster by 2 steps 
	 */
	public TwoStepMovable() {
		step = 2;
	}

	/* (non-Javadoc)
	 * @see com.tower.monsters.Movable#move(com.tower.map.Map, com.tower.monsters.Monster)
	 */
	public void move(Map map, Monster monster) {
		moveToFillMap(map, monster);
	}
}
