package com.tower.monsters;

import com.tower.map.Map;
import com.tower.tower.*;

public abstract class Movable {
	public Movable() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected int step;
	private boolean isWin = false;
	
	public abstract void move(Map map, Monster monster);
	
	public void moveToFillMap(Map map, Monster monster) {
		String[][] grid = map.getGrid();
		int i = map.getEntry();
		int j = map.getEntry();
		while (i < grid.length && j < grid.length) {
			if (i + step >= grid.length) {
				j += step;
				if (j >= grid.length) {
					isWin = true;
					map.setGrid(grid);
					return;
				}
			}
			else if (j + step >= grid.length) {
				i += step;
				if (i >= grid.length) {
					isWin = true;
					map.setGrid(grid);
					return;
				}
			}
			else {
				boolean direction = determineDirection();
				if (direction) {
					i += step;
				}
				else {
					j += step;
				}
				if (i < grid.length && j < grid.length && grid[i][j].equals("Powerful")) {
					monster.meetTower("Powerful");
					if (monster.isDead()) {
						map.setGrid(grid);
						isWin = false;
						return;
					}
				}
				else if (i < grid.length && j < grid.length && grid[i][j].equals("Normal")) {
					monster.meetTower("Normal");
					if (monster.isDead()) {
						map.setGrid(grid);
						isWin = false;
						return;
					}
				}
				else if (i < grid.length && j < grid.length && grid[i][j].equals("Weak")) {
					monster.meetTower("Weak");
					if (monster.isDead()) {
						map.setGrid(grid);
						isWin = false;
						return;
					}
				}
				else if (i < grid.length && j < grid.length && grid[i][j].equals("O")) {
					if (direction) {
						i -= step;
					}
					else {
						j -= step;
					}
					continue;
				}
				else if (i < grid.length && j < grid.length) {
					grid[i][j] = "*";
				}
			}
		}
	}
	
	private boolean determineDirection() {
		int probability = (int) (Math.random() * 100);
		return probability < 50 ? true : false;
	}
	
	public boolean winOrNot() {
		return isWin;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
}
