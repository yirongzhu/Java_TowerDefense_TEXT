package com.tower.monsters;

import com.tower.map.Map;

/**
 * @author Tower Defense
 * It is the random step movable class
 */
public class RandomStepMovable extends Movable{
	
	public RandomStepMovable() {
		step = (int) (Math.random() * 4 + 1);
	}

	public void move(Map map, Monster monster) {
		moveToFillMap(map, monster);
	}
}
