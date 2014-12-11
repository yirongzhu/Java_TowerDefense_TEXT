package com.tower.abstractfactory;

import com.tower.monsters.*;
import com.tower.tower.*;

/**
 * @author Tower Defense
 * This class extends the abstract factory 
 */

public class NormalFactory extends AbstractFactory {

	public NormalFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monster getMonsterFactory() {
		return new NormalMonster();
	}

	public Tower getTowerFactory() {
		return new NormalTower();
	}
}
