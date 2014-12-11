package com.tower.abstractfactory;

import com.tower.monsters.*;
import com.tower.tower.*;

public class PowerfulFactory extends AbstractFactory {

	public PowerfulFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monster getMonsterFactory() {
		return new BossMonster();
	}

	public Tower getTowerFactory() {
		return new PowerfulTower();
	}
}
