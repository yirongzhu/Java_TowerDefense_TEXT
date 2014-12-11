1.The rar files contains the JAVA application that has the following packages:

[com.tower.abstractfactory]
It thas the abstractfactory class and it's 3 subclass for tower and monster implementation

[com.tower.decorator]
Contains the decorator pattern class for generating different game mode setting.

[com.tower.main]
Contains the Main method for controlling the application and Game class to run the code.

[com.tower.map]
Contains the map class to generate the map (2D array)

[com.tower.monsters]
Contains the stratgy and factory methods patterm that implement 
2 super classes: the monster and it's movment type, as well as the sub class.

[com.tower.tower]
Similar to monster package, contains the tower type and it's attack behavior.


2.How to run the code:
Simply go to the [com.tower.main] package and run the Game.java file, then choose from the menu:

	1-Play the game
	2-Help
	3-Exit the game

	For game play:
		1.just choose from which mode/difficulty you want
		2.then start to put towers based on your current budget
		3.after finish purchasing the towers choose how you want to place the tower
		4.either choose to place the randomly or maually. If you choose to place tower manually you 
			have to enter row and column in the range of 0 - 19.
		5.Have fun :)