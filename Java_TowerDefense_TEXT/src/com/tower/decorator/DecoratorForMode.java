package com.tower.decorator;

import java.util.ArrayList;

import com.tower.monsters.*;

/**
 * @author Tower Defense 
 *
 */

public class DecoratorForMode {
	
	private MonsterFactory mf;
	
	public DecoratorForMode() {
		mf = new MonsterFactory();
	}

	public void decideMode(String mode, ArrayList<Monster> monsters) {
		if (mode.equals("Hard")) {
			monsters.add(mf.creatMonster("Weak"));
			monsters.add(mf.creatMonster("Normal"));
			for (Monster monster : monsters) {
				monster.addBlood(50);
			}
		}
		else if (mode.equals("Normal")) {
			return;
		}
		else if (mode.equals("Easy")) {
			monsters.remove(0);
			monsters.remove(1);
			for (Monster monster : monsters) {
				monster.decreaseBlood(50);
			}
		}
		else {
			System.out.println("Not Valid Mode!");
		}
	}

	public MonsterFactory getMf() {
		return mf;
	}

	public void setMf(MonsterFactory mf) {
		this.mf = mf;
	}
}
