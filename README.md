***************************************************************************************************
*										                     BattleShip Game			                   								  *
***************************************************************************************************

--------------------------------------------Overview-----------------------------------------------

Battleship game is a war game played on ocean by two players. Each player own his battle area and 
each player will get same number of ships where each ship may have different size placed at some 
position in non-overlapping fashion. Note, players cannot see each others ship's location.

The player who destroys all the ships of other player is winner of the game. If at the end none of 
the player wins then both player declares peace

--------------------------------------------How to Run-----------------------------------------------

First Approach : Unzip the archive battle-ship-game.zip and Look for file BattleShipMain.java and run it either using java command.

Second Approach: Import the project in IDE like eclipse 
File -> Import -> Existing project -> Select Archive -> select the archive battle-ship-game.zip and import.
Open file BattleShipMain.java and run it using eclipse.

--------------------------------------------Input-----------------------------------------------

First line of the input contains dimensions of battle area having width and height separated by space. 
Then the next line will have number (B) of battleships each player has. Then in the next line battleship 
type, dimensions (width and height) & positions (Y coordinate and X coordinate) for Player-1 and then 
for Player-2 will be given separated by space. And then in the next line Player-1’s sequence 
(separated by space) of missiles target location coordinates (Y and X) will be given and then for 
sequence for Player-2.
 
Specify the input in file input.txt in below format.

Sample Input:

	5 E
	2
	Q 1 1 A1 B2
	P 2 1 D4 C3
	A1 B2 B2 B3
	A1 B2 B3 A1 D1 E1 D4 D4 D5 D5

--------------------------------------------Ouput-----------------------------------------------

The game will give output on console if any fighter is winner or it was declared as peace. 
