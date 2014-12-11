package com.tower.main;

import java.util.*;

import com.tower.abstractfactory.AbstractFactory;
import com.tower.abstractfactory.NormalFactory;
import com.tower.abstractfactory.PowerfulFactory;
import com.tower.abstractfactory.WeakFactory;
import com.tower.decorator.DecoratorForMode;
import com.tower.map.Map;
import com.tower.monsters.*;
import com.tower.tower.*;


public final class Main {

	private Map map;
	private ArrayList<Tower> towers;
	private ArrayList<Monster> monsters;
	private int size;
	private boolean winTheGame = true;
	private String mode;
	private int numTower;
	private int price;
	
	private AbstractFactory p;
	private AbstractFactory n;
	private AbstractFactory w;
	private DecoratorForMode dfm;
	
	private static Main mainInstance;
	
	private Main() {
		
	}
	
	public static Main getInstance() {
		if (mainInstance == null) {
			mainInstance = new Main(20);
		}
		return mainInstance;
	}
	
	private Main(int size) {
		this.size = size;
		this.price = 500;
		map = new Map(size);
		towers = new ArrayList<Tower>();
		monsters = new ArrayList<Monster>();
		p = new PowerfulFactory();
		n = new NormalFactory();
		w = new WeakFactory();
		dfm = new DecoratorForMode();
	}
	
	private void addMonster(String monster) {
		if (monster.equals("Boss")) {
			monsters.add(p.getMonsterFactory());
		}
		else if (monster.equals("Jump")) {
			monsters.add(w.getMonsterFactory());
		}
		else if (monster.equals("Normal")) {
			monsters.add(n.getMonsterFactory());
		}
		else {
			System.out.println("Not valid monster!");
			return;
		}
	}
	
	private void addTower(String tower) {
		Tower t;
		if (tower.equals("Powerful")) {
			t = p.getTowerFactory();
			towers.add(t);
			price -= t.getPrice();
		}
		else if (tower.equals("Normal")) {
			t = n.getTowerFactory();
			towers.add(t);
			price -= t.getPrice();
		}
		else if (tower.equals("Weak")) {
			t = w.getTowerFactory();
			towers.add(t);
			price -= t.getPrice();
		}
		else {
			System.out.println("Not valid tower!");
			return;
		}
		System.out.println("The total remaining money you have is: " + price);
	}
	
	private void initializeMap() {
		Scanner scan = new Scanner(System.in);
		String[][] grid = map.getGrid();
		int countPowerful = 0;
		int k = 0;
		System.out.println("The total amount of money you have is: " + price);
		while (price >= 50) {
			k++;
			while (true) {
				System.out.print("Please input the tower " + k + " you want to place (Powerful, Normal, or Weak): ");
				String tower = scan.next();
				if (mode.equals("Hard") && tower.equals("Powerful") && countPowerful >= 1) {
					System.out.println("Hard mode doesn't allow more than 1 Powerful tower");
					continue;
				}
				else if (mode.equals("Normal") && tower.equals("Powerful") && countPowerful >= 2) {
					System.out.println("Normal mode doesn't allow more than 2 Powerful tower");
					continue;
				}
				else if (mode.equals("Easy") && tower.equals("Powerful") && countPowerful >= 3) {
					System.out.println("Easy mode doesn't allow more than 3 Powerful tower");
					continue;
				}
				
				if (tower.equals("Powerful")) {
					if (price < 150) {
						System.out.println("Not enough money for powerful tower!");
						continue;
					}
					addTower(tower);
					numTower++;
					countPowerful++;
					break;
				}
				else if (tower.equals("Normal")) {
					if (price < 100) {
						System.out.println("Not enough money for normal tower!");
						continue;
					}
					addTower(tower);
					numTower++;
					break;
				}
				else if (tower.equals("Weak")) {
					if (price < 50) {
						System.out.println("Not enough money for weak tower!");
						continue;
					}
					addTower(tower);
					numTower++;
					break;
				}
				else {
					System.out.println("Not valid tower, please try to place it again!");
					continue;
				}
			}
		}
		
		while (true) {
			System.out
					.print("In which way do you want to place the towers (Randomly or Manually): ");
			String placeWay = scan.next();
			if (placeWay.equals("Randomly")) {
				RandomFormAMapWithTower();
				break;
			}
			else if (placeWay.equals("Manually")) {
				for (int i = 0; i < towers.size(); i++) {
					Tower t = towers.get(i);
					int row;
					int column;
					while (true) {
						while (true) {
							System.out
									.println("Please input row number for Tower "
											+ i + " (" + t.toString() + "):");
							row = scan.nextInt();
							if (row >= size || row < 0) {
								System.out.println("Row is out of bound!");
								continue;
							} else {
								break;
							}
						}

						while (true) {
							System.out
									.println("Please input column number for Tower "
											+ i + " (" + t.toString() + "):");
							column = scan.nextInt();
							if (column >= size || column < 0) {
								System.out.println("Column is out of bound!");
								continue;
							} else {
								break;
							}
						}

						if (!grid[row][column].equals("")
								&& !grid[row][column].equals("*")) {
							System.out
									.println("There's already a tower at this place! Please place it again!");
							continue;
						} else if (grid[row][column].equals("*")) {
							System.out
									.println("Don't put the tower at the entry point! Please place it again!");
							continue;
						} else {
							break;
						}
					}
					fillTowerInMap(t, row, column);
				}
				break;
			}
			else {
				System.out.println("Not valid way!");
				continue;
			}
		}
		
		int count = 0;
		
		while (count < 3) {
			int i = (int) (Math.random() * 20);
			int j = (int) (Math.random() * 20);
			if (!grid[i][j].equals("")) {
				continue;
			}
			else {
				grid[i][j] = "O";
				count++;
			}
		}
	}
	
	private void initializeMonsters() {
		addMonster("Normal");
		addMonster("Normal");
		addMonster("Jump");
		addMonster("Jump");
		addMonster("Boss");
		while(true) {
			System.out.print("Please input the mode you want to play (Hard, Normal, or Easy): ");
			Scanner scan = new Scanner(System.in);
			mode = scan.next();
			if (mode.equals("Hard") || mode.equals("Normal") || mode.equals("Easy")) {
				dfm.decideMode(mode, monsters);
				break;
			}
			else {
				System.out.println("Not valid mode! Please try it again!");
			}
		}
	}
	
	public void startGame() {
		while (true) {
			System.out.println("Tower Defense Game!");
			System.out
					.println("Please choose from the below options (1, 2, 3): ");
			System.out.println("1. Play the game!");
			System.out.println("2. Help!");
			System.out.println("3. Exit!");
			Scanner scan = new Scanner(System.in);
			int option = scan.nextInt();
			if (option == 1) {
				initializeMonsters();
				initializeMap();
				boolean thisWave;
				for (Monster monster : monsters) {
					thisWave = monster.getStarted(map);
					winTheGame &= thisWave;
					map.print();
					System.out
							.println("Win or Not in this wave: " + thisWave);
					map.clear();
				}
				System.out.println();
				System.out.println("The result of the game is win?   "
						+ winTheGame);
				break;
			} else if (option == 2) {
				Help.showHelp();
				while (true) {
					System.out.println();
					System.out.println("Return to the previous page(Yes?): ");
					String choice = scan.next();
					if (choice.equals("Yes")) {
						break;
					}
					else {
						continue;
					}
				}
				continue;
			} else if (option == 3) {
				System.out.println("The game exits!");
				return;
			}
		}
	}
	
	public void fillTowerInMap(Tower tower, int i, int j) {
		if (i >= size || j >= size) {
			return;
		}
		String[][] grid = map.getGrid();
		if (tower.toString().equals("Powerful") && grid[i][j] == "") {
			grid[i][j] = "Powerful";
		}
		if (tower.toString().equals("Normal") && grid[i][j] == "") {
			grid[i][j] = "Normal";
		}
		if (tower.toString().equals("Weak") && grid[i][j] == "") {
			grid[i][j] = "Weak";
		}
		map.setGrid(grid);
	}
	
	public void RandomFormAMapWithTower() {
		int count = 0;
		int i = 0;
		int j = 0;
		while (count < numTower) {
			i = (int) (Math.random() * 20);
			j = (int) (Math.random() * 20);
			if (i >= size || j >= size) {
				continue;
			}
			if (map.getGrid()[i][j] != "") {
				continue;
			}
			else {
				fillTowerInMap(towers.get(count), i, j);
				count++;
			}
		}
		for (Tower tower : towers) {
			fillTowerInMap(tower, i, j);
		}
		
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
	}

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isWinTheGame() {
		return winTheGame;
	}

	public void setWinTheGame(boolean winTheGame) {
		this.winTheGame = winTheGame;
	}

	public AbstractFactory getP() {
		return p;
	}

	public void setP(AbstractFactory p) {
		this.p = p;
	}

	public AbstractFactory getN() {
		return n;
	}

	public void setN(AbstractFactory n) {
		this.n = n;
	}

	public AbstractFactory getW() {
		return w;
	}

	public void setW(AbstractFactory w) {
		this.w = w;
	}

	public DecoratorForMode getDfm() {
		return dfm;
	}

	public void setDfm(DecoratorForMode dfm) {
		this.dfm = dfm;
	}

	public static Main getMainInstance() {
		return mainInstance;
	}

	public static void setMainInstance(Main mainInstance) {
		Main.mainInstance = mainInstance;
	}
}

final class Help {
	
	public static void showHelp() {
		System.out.println("Game Functionality");
		System.out.println();
		System.out.println("The game has some key features implemented . The game is played on a 20x20 map. The user can chose five towers with different strengths to be placed either manually or randomly on the map. The player");
		System.out.println("has to pay different amount of points for the towers levels they chose to be placed on the map. The towers are shown as text on the map. Additionally, the monsters show up on the game in sequence of");
		System.out.println("different waves depending on the game difficulty level, with one monster attacking on each wave. The monsters path on the map is shown with an asterisk. Moreover, the player receives points depending on");
		System.out.println("the killed monster level and the final score points printed at the end of the game. Furthermore, randomly placed obstacles are also created on the map. To recap, the game functions/steps are:");
		System.out.println();
		System.out.println("    1. Player inputs five towers based on the three different types of towers and points available");
		System.out.println("    2. Map is initialized with the randomly placed obstacles  and towers represented as texts");
		System.out.println("    3. Each monster starts at top far left corner of the map");
		System.out.println("    4. The game then outputs the paths of the five monsters waves in sequence");
		System.out.println("    5. At the end of each wave a ¡°false¡± or ¡°true¡± output reads if the user killed the monster during that specific wave or not");
		System.out.println("    6. At the end of each wave the remaining tower blood level is also shown");
		System.out.println("    7. The towers must destroy all five waves of monsters in order to win the game");
		System.out.println("    8. A final output of ¡°false¡± or ¡°true¡±  with total points accumulated to show if the player won or lost the game");
		System.out.println();
		System.out.println("Although the game appears simple in perspective, the written programming and the strategic use of the design patterns makes the operation of running the program seem simple to the user.");
	}
}
