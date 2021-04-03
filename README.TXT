
Description of Game: Clash of Legends demonstrates a game with our player being a Hero. Our hero moves across the map that we provide in .txt file. There are various obstacles in the map, if our hero moves into the obstacle it compares hero's skills with the skills required to win that obstacle. If hero has better skills then he attains additional skills and continues to move around the map. We can control the movement of our hero using arrow keys. And if the hero looses that obstacles then the game is over and our Hero dies.


PROJECT TITLE:	CLash of Legends
PURPOSE OF PROJECT: Building a more realistic game
VERSION or DATE: 25th June 2020
HOW TO START THIS PROJECT: Run main method from GameController class
AUTHORS: Kabir Bhakta

The Program is complete and giving us the desirable output.
NOTE:- NO COMMENTS SHOULD BE THERE IN THE ENTIRE ALL 3 INPUT FILES.
The only problem that the program will encounter is if the file format is changed or file dosent exist. Still it will run the program but the output will be blank.

USER INSTRUCTIONS:

1.File Loader Class: This class loads our hero object, our map and our encounter objects from the file. One drawback of this class is it would throw and exception if the file provided dosent exist or has some different format rather than provided below:

Hero File Format(Make sure it dosent have any comments in it and no blank line after the last line in the file):

Kabir	//Name of the hero
The MasterMind of Universe  //Description of hero
0 14 // stress, max stress limit
2 5 3 //skills: Physical mental social (yours could be different)

MapFile Format(No comments and no blank line after the last line in the file):

6 13	//row and column

XXXXXXXXXXXXX
X.H.....2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

Encounter File Format(No Comments and no blank line after the last line in the file):

4 // total number of encounters
// blank line for space / clarity, this should be ignored. 
0
Brothers Wedding
1 7
social
Diamond Ring
EquipableItem social 2
He is marrying the most beautiful lady!
Bride's sister Kissed you and proposed you! Hurray!!You got 
Your Brother's wife is your ex-Girlfriend.

1
Scary Monster 
2 7
mental
Golden Sword
StackableItem 2 10
Monsters Attacked your kingdom. 
Can't Defeat world's best army Force.You Won 
He destroyed your Kingdom and took all the Treasure. 

2
Secret Tunnel
3 7
physical
Golden Sword
StackableItem 9 10
Tunnel of Darkness
You picked up the lose brick.You got 
The brick is too heavy for you!.

3
Chess Masterminds!
2 7
mental
Golden Sword
EquipableItem mental 1
Capture opponents king
You did it!You won 
No brain in you!





2.Map File: This class helps to set up our map.
		-Intialize the map with all tiles as '.'
		-Can generate map based on 2d character Array
		-method used to set the walls of the map
		-Sets every tile some specific value whenever called that method
		-Locates our Hero location on the Map
		-Main part of the class processInput(), moves our hero around with the use of other methods
		-checks if our move is valid or not
		-Prints out the map to the user.

3.GameController: This is our main running class. Whenever you want to run the program run using this class.
		-This class calls and loads a hero,encounter object and map from the fileLoader Class.
		-Even the encounter objects from the file are sent to encounter Array in this class.
		-This class helps to print specific output if our hero is still active or not after facing encounters.
		-Main gameplay loop is included in this class taht will loop through all the encounter and will in return call another method from the same, GameController class
		-oUR nextEncounter method in this class will:
		1.Call Skill Check method from Hero class
      		2.Check whether it succeed or fail.
      		3.Append the particular Item to hero's Inventory and set null at particular location in Encounter array
      		4.Increase the Current Stress level by the amount of risk passed in Encounter object.
      		5.Print the Win or lose description
		-It will also store the output of the game with time and date to an another file named as "HeroOutput.txt"

4.TestClass: just used to run and ensure the expected output is perfect.

At the End of the execution following output will be shown:-

Kabir
The MasterMind of Universe  
Stress: 0/14
- Physical: 5
- Mental:5
- Social:2
[Empty]
xxxxxx- New Hero Created! -xxxxxx
XXXXXXXXXXXXX
X.H.....2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

---------------------------------------------------------------
XXXXXXXXXXXXX
X..H....2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...H...2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X....H..2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X.....H.2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X......H2...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

---------------------------------------------------------------
Secret Tunnel: Tunnel of Darkness
You picked up the lose brick.You got Golden Sword [9/10]
XXXXXXXXXXXXX
X.......H...X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X........H..X
X..0........X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0.....H..X
X.....1.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0........X
X.....1..H..X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0........X
X.....1.H...X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0........X
X.....1H....X
X..3........X
XXXXXXXXXXXXX

---------------------------------------------------------------
Scary Monster : Monsters Attacked your kingdom. 
Can't Defeat world's best army Force.You Won Golden Sword [2/10]
XXXXXXXXXXXXX
X...........X
X..0........X
X.....H.....X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0..H.....X
X...........X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0.H......X
X...........X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X..0H.......X
X...........X
X..3........X
XXXXXXXXXXXXX

---------------------------------------------------------------
Brothers Wedding: He is marrying the most beautiful lady!
Bride's sister Kissed you and proposed you! Hurray!!You got Diamond Ring [social +2]
XXXXXXXXXXXXX
X...........X
X..H........X
X...........X
X..3........X
XXXXXXXXXXXXX

XXXXXXXXXXXXX
X...........X
X...........X
X..H........X
X..3........X
XXXXXXXXXXXXX

---------------------------------------------------------------
Chess Masterminds!: Capture opponents king
You did it!You won Golden Sword [mental +1]
XXXXXXXXXXXXX
X...........X
X...........X
X...........X
X..H........X
XXXXXXXXXXXXX

Our Hero Kabir was successful and still living! :-)
Encounters left to face: 0
=====FINAL OUTPUT====
Kabir
The MasterMind of Universe  
Stress: 0/14
- Physical: 5
- Mental:5
- Social:2
[Golden Sword [10/10],Golden Sword [1/10],Diamond Ring [social +2],Golden Sword [mental +1]]
It took 18 moves to complete the game.
Thank you For playing the game.


PROGRAM END.


