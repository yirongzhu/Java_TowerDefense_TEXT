package com.tower.map;

/**
 * @author Tower Defense
 * This class is used to initilaize map nad perform map specific funcitons 
 */

public class Map {

	public Map() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String[][] grid;
	private int entryPoint;
	private int outPoint;
	
	public Map(int size) {
		grid = new String[size][size];
		outPoint = size - 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = "";
			}
		}
		grid[entryPoint][entryPoint] = "*";
	}
	
	public String getOutPoint() {
		return grid[outPoint][outPoint];
	}
	
	public int getEntry() {
		return entryPoint;
	}
	
	public String[][] getGrid() {
		return grid;
	}
	
	public void setGrid(String[][] grid) {
		this.grid = grid;
	}
	
	public void print() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void clear() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (grid[i][j].equals("*")) {
					grid[i][j] = "";
				}
			}
		}
	}

	public int getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(int entryPoint) {
		this.entryPoint = entryPoint;
	}

	public void setOutPoint(int outPoint) {
		this.outPoint = outPoint;
	}
}
