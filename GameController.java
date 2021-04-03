// Main Class that Controls our Entire Game
/* It includes:
 * 1.Loads all the data from different files
 * 2.Checks all the condition and perform the task.
 * 3.nextEncounter Method that checks the skill level with difficulty
 * 4.Perform operations according to the result of nextEncounter method.
 * 5.NextInput() method returns the integer value for our arrow key pressed
 * 6. Finally output all the necessary Details to user including the map.
 * 7.Adds the result to our heroFile back.(Bonus Feature)
 */
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Calendar;

public class GameController{

    public static void main(String[] args){
        try{

            StdDraw.setCanvasSize(100,100); //set the canvas size to 100 X 100 pixels so that we can focus on our output screen

            //Load our Hero Object from the file
            Hero myHero = FileLoader.loadHero("heroFile.txt");

            //Print out Details about our Hero before facing encounters.
            System.out.println(myHero.fullToString());

            //Success Message to let user know that Hero object is created.
            System.out.println("xxxxxx- New Hero Created! -xxxxxx");

            //Load all the encounters from the file and store it in the encounter array
            Encounter[] arrEncounter = FileLoader.loadEncounter("encountersFile.txt");

            int totalEnc = arrEncounter.length; //total encounters in the array

            int counter = 0;    //counter for the loop

            int moves = 0;  //number of moves took to complete the game

            //Load Map from file
            Map myMap = FileLoader.loadMap("mapFile.txt");

            System.out.println(myMap.toString());

            System.out.println("---------------------------------------------------------------");

            //Main GamePlay loop that checks various condition , calls appropriate method and performs the task
            //Loop until all the encounters are faced and until my hero is still alive
            while(counter != totalEnc && myHero.checkStatus()==true){

                int inputMove = getInput();     //get which arrow key is pressed getInput method called

                if(inputMove != -1){            //checks if the key pressed is valid or not

                    char currChar = myMap.processInput(inputMove);  //Get the character from the next location to move on. Method called from Map Class

                    //Checks if the next character is an Encounter or not
                    if(Character.isDigit(currChar)){ 

                        System.out.println("---------------------------------------------------------------");
                        nextEncounter(myHero,arrEncounter[Character.getNumericValue(currChar)]);    //Perform and print the task output
                        counter ++;
                        System.out.println(myMap.toString());       //print the current map

                    }
                    else if(currChar == '.'){

                        System.out.println(myMap.toString());

                    }
                    else{   //checks if next move is a wall or not
                        System.out.println("Cannot be moved into the walls");
                        System.out.println(myMap.toString());
                    }
                    moves ++ ;  //increment moves
                }
                
                
                StdDraw.show(75);  //Animation
            }
            
            String outPutFile = "HeroOutput.txt";
            BufferedWriter outPut = new BufferedWriter(new FileWriter(outPutFile,true));
            
            Calendar calendar = Calendar.getInstance();
            
            
            //Printing the final Message reagrding the state of our Hero: whether the stress level exceeded max stress or not.
            if (myHero.checkStatus() == true){
                System.out.println("Our Hero "+myHero.getName()+" was successful and still living! :-)"+"\nEncounters left to face: "+(totalEnc-counter));
                outPut.write(""+calendar.getTime()+"\n");
                outPut.write("Our Hero "+myHero.getName()+" was successful and still living! :-)"+"\nEncounters left to face: "+(totalEnc-counter)+"\n");
            }
            else{
                System.out.println("Our Hero "+myHero.getName()+" Died during encounters :-( "+"\nEncounters left to face: "+(totalEnc-counter));
                outPut.write(""+calendar.getTime()+"\n");
                outPut.write("Our Hero "+myHero.getName()+" Died during encounters :-( "+"\nEncounters left to face: "+(totalEnc-counter)+"\n");
            }

            //Printing final Details of our Hero after he faced the Encounters in the outPut File
            
            outPut.write("=====FINAL OUTPUT==== \n");    
            outPut.write(myHero.fullToString()+"\n");
            outPut.write("It took "+moves+" moves to complete the game.\n");
            outPut.write("Thank you For playing the game.\n");
            outPut.write("  "+"\n");
            outPut.close();
            
            //Printing final Details of our Hero after he faced the Encounters
            System.out.println("=====FINAL OUTPUT====");    
            System.out.println(myHero.fullToString());
            System.out.println("It took "+moves+" moves to complete the game.");
            System.out.println("Thank you For playing the game.");
            System.exit(0);
        }

        //Exception Handling
        catch(Exception e){
            System.out.println("ERROR 404: "+"\n"+e.toString());
            e.printStackTrace();
            System.exit(0);
        }
        
        
    }

    /*This Mehtod will:-
     * 1.Call Skill Check method from Hero class
     * 2.Check whether it succeed or fail.
     * 3.Append the particular Item to hero's Inventory and set null at particular location in Encounter array
     * 4.Increase the Current Stress level by the amount of risk passed in Encounter object.
     * 5.Print the Win or lose description
     */ 

    private static void nextEncounter(Hero hero, Encounter event){

        //Retreive skill Type and difficulty of that skill from Encounter object i.e event
        String skillType = event.getSkillType();    
        int difficultLevel = event.getDifficultyLevel();

        //print the game name with description
        System.out.println(event.getGameName()+": "+event.getGameDescription());  

        //store the boolean value for our logic method SkillCheck.
        boolean result = hero.skillCheck(skillType,difficultLevel); 

        //Will print win or lose message along with it, it will add item to hero's inventory
        if (result){
            System.out.println(event.getWinDescription() + event.getReward());  //Print win description if our hero was succesful in the skillcheck

            //remove item from Encounter and Store it in hero's inventory
            hero.addItem(event.getReward()); 
            
            
            event.setNullReward();
            
        }
        
        else{
            System.out.println(event.getLoseDescription()); //Print lose description if our hero failed the skillcheck

            hero.addStress(event.getRisk());    //Add Stress level by the amount of risk invloved

            System.out.println("Our Hero gained "+event.getRisk()+" Stress points from his failure in "+event.getGameName());   //Print Lost message

        }

    }

    
    //Method called and used for getting the input from the user about the arrow key

    private static int getInput(){
        
        int returnInt = 0;
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            returnInt = 0;  //Up arrow
        }
        else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
            returnInt = 1;  //right arrow
        }
        else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            returnInt = 2;  //down arrow
        }
        else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            returnInt = 3;  //left arrow
        }
        else{
            returnInt = -1; //invalid input
        }

        return returnInt;

    }  

}

//xxxxxxxxxxxxxxxxxxxxxxxxx- End of Game Controller Class -xxxxxxxxxxxxxxxxxxxxxxxxxx//