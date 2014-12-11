package com.tower.abstractfactory;

import com.tower.monsters.*;
import com.tower.tower.*;

/**
 * @author TowerDefense
 * Abstract factory design pattern class. 
 */

public abstract class AbstractFactory {

	public AbstractFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public abstract Monster getMonsterFactory();
	public abstract Tower getTowerFactory();
}
