package com.tower.monsters;

import com.tower.map.Map;
import com.tower.tower.TowerFactory;

/**
 * @author Tower Defense
 * This is class for normal monsters 
 */
public class NormalMonster extends Monster {

	public NormalMonster(int blood, Movable movable, TowerFactory tf) {
		super(blood, movable, tf);
		// TODO Auto-generated constructor stub
	}

	public NormalMonster() {
		blood = 150;
		movable = new TwoStepMovable();
	}
	
	public boolean getStarted(Map map) {
		movable.move(map, this);
		return movable.winOrNot();
	}

	@Override
	public String toString() {
		return "Normal";
	}

}
