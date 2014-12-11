package com.tower.abstractfactory;

import com.tower.monsters.*;
import com.tower.tower.*;

public class WeakFactory extends AbstractFactory {

	public WeakFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monster getMonsterFactory() {
		return new JumpMonster();
	}

	public Tower getTowerFactory() {
		return new WeakTower();
	}
}
