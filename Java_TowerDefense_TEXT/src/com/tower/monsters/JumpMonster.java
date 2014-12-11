package com.tower.monsters;

import com.tower.map.Map;

public class JumpMonster extends Monster {
	
	/**
	 * It is constructor for Jump Monster. It inintializes the blood to 70.
	 */
	public JumpMonster() {
		blood = 70;
		movable = new RandomStepMovable();
	}
	
	/* (non-Javadoc)
	 * @see com.tower.monsters.Monster#getStarted(com.tower.map.Map)
	 * Helps jump monster move
	 */
	public boolean getStarted(Map map) {
		movable.move(map, this);
		return movable.winOrNot();
	}

	@Override
	public String toString() {
		return "Weak";
	}
}
