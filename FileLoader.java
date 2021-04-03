//class that will contain some methods to help read data in from various files.
//Contains Following methods:
//1.public static Map loadMap(String fileName)
//2.main method for testing(temporary)
//3.public static Hero loadHero(String Filename)
//4.public static Encounter[] loadEncounter(string fileNAME)

//Importing necessary libraries for Files and exception handling
import java.io.*;
import java.util.*;

public class FileLoader
{

    //method that loads the map from a file name passed 
    //Hardcoded method that will give desirable output if and only if it has the given format in mapFile.txt

    public static Map loadMap(String fileName) throws Exception{ 
        //opens the file for reading
        FileReader currFile = new FileReader(fileName);

        //instance for using currFile
        BufferedReader inFile = new BufferedReader(currFile);

        //reads the first line of the file
        String currLine = inFile.readLine();

        Scanner s = new Scanner(currLine);

        int colTotal = 0;   //total number of columns in file
        int rowTotal = 0;   //total number of rows in file

        //Retrieveing Row and column from the file

        rowTotal = s.nextInt(); //get total rows
        colTotal = s.nextInt(); //get total columns

        //Move to next Line
        currLine = inFile.readLine();

        //Create a 2d Array for storing map 
        char[][] currentTemplate = new char[rowTotal][colTotal];

        //Loop for storing the map in the map template array

        while(currLine != null){
            //Checks for empty lines in the File
            if(currLine.equals("")){    
                currLine = inFile.readLine();   //skip empty lines

            }
            else{
                //else store the values of map from file to our variable

                for (int row = 0; row < rowTotal ; row++){
                    Scanner s1 = new Scanner(currLine);
                    String val = s1.next();         // read char by char
                    char[] colVal = val.toCharArray();

                    for(int col = 0; col < colTotal ; col++){

                        currentTemplate[row][col] = colVal[col];    //store the value in the array
                    }

                    currLine = inFile.readLine();   //move to next line

                } 

            }

        }
        //close File after use
        inFile.close();

        //convert char array of our map to Map object
        Map mapTemplate = new Map(currentTemplate);

        //reuturn map
        return mapTemplate;
    }

    //Method used to load hero objects from the File(without comments)
    //reads and assigns all the details of the hero present in the file
    //No spaces at all and no comments

    public static Hero loadHero(String fileName) throws Exception{
        //Hero details intialisation

        int[] arrayOfInt = new int[5];  //array created to store all the integer values that are related to hero like stress and skills

        String name = "";   //Hero Name
        String description = "";    //hero Description
        int currentStress;  //Current Stress level
        int maxStress;      //Maximum Stress Capacity

        //Skills of Hero
        int physical;       
        int mental;
        int social;

        int intCounter = 0; //count number of elements in interger array

        //Opens our hero file
        FileReader heroFile = new FileReader(fileName);

        BufferedReader inHFile = new BufferedReader(heroFile);

        //Reads the First Line of the Hero file
        String heroLine = inHFile.readLine();

        name = heroLine;    //read the first line and store it as hero's name
        description = inHFile.readLine();   //read the next line and get description
        heroLine = inHFile.readLine();              //move to next line
        Scanner scan1 = new Scanner(heroLine);

        //Loop for storing all the integer values in our array from the file
        //Just to be double sure of the format. Can be done without loop too.
        while(heroLine != null){
            scan1 = new Scanner(heroLine);
            if(scan1.hasNextInt()){
                while(scan1.hasNextInt()){  //loops until all the integer in a line are passed

                    arrayOfInt[intCounter] = scan1.nextInt();
                    intCounter += 1;

                }
                heroLine = inHFile.readLine();

            }
            else{
                heroLine = inHFile.readLine();
            }

        }

        inHFile.close();    //close file

        //Asssignes the value to respective int variable
        currentStress = arrayOfInt[0];  
        maxStress = arrayOfInt[1];
        physical = arrayOfInt[2];
        mental = arrayOfInt[3];
        social = arrayOfInt[4];

        //Item List which is empty for now in the file
        ItemList itemList = new ItemList();

        //create and assign a new hero object
        Hero heroObject = new Hero(name,description,currentStress,maxStress);
        heroObject.setSkills(physical,mental,social);   //Sets the skills of our hero

        return heroObject;
    }

    //This method will return encounters from the file.
    //And will call another method named encounterData for multiple times
    //No spaces and comments

    public static Encounter[] loadEncounter(String fileName) throws Exception{
        //Opens our encounter file
        FileReader encounterFile= new FileReader(fileName);;

        BufferedReader inEFile = new BufferedReader(encounterFile);

        //Reads the First Line of the encounter file
        String encounterLine = inEFile.readLine();

        Scanner eScan = new Scanner(encounterLine);

        //total number of encounters in file
        int totalEncounters = 0;

        totalEncounters = eScan.nextInt();

        encounterLine = inEFile.readLine();

        //skip the empty line
        encounterLine = inEFile.readLine();
        eScan = new Scanner(encounterLine);

        //keep track of total encounters
        int currEncounterNumber = 0;

        //Array for storing Encounters
        Encounter arrEncounter[] = new Encounter[totalEncounters];

        //Loop for storing encounters in encounter array
        //it calls encounterData as many times it detects an encounter in the file

        while(currEncounterNumber < totalEncounters){
            if(eScan.hasNextInt() && encounterLine.length() <= 1){
                arrEncounter[currEncounterNumber] = encounterData(inEFile);
                currEncounterNumber ++ ;
            }
            encounterLine = inEFile.readLine();
            eScan = new Scanner(encounterLine);
        }

        inEFile.close();    //close file

        return arrEncounter;
    }

    //method used to return the encounter data from the file to the our encounter method
    //we can call this as many times as we want and as many encounters there are in the file
    //no spaces and comments
    private static Encounter encounterData(BufferedReader inFile) throws Exception{

        Encounter currEvent ;

        //Which encounter it is
        int encounterNum = 0;

        //Name and Description of the Event
        String eventName;
        String eventDescription;
        String skillType;

        //Difficulty and Risk Level
        int difficulty = 0;
        int risk = 0 ;

        //Item Name
        String itemNameStr;
        
        //Passing the item type
        Item item;

        //Item Type variables
        String itemType;
        String itemTypeLine;
        String skill;
        int currCount,maxCount,boost;

        //Win and lose Description
        String winDesc;
        String losDesc;

        //Process of retrieveing Data starts here

        eventName = inFile.readLine();  //event name

        String encounterLine = inFile.readLine();
        Scanner eScan = new Scanner(encounterLine);

        while(eScan.hasNextInt()){
            difficulty = eScan.nextInt();   //difficulty
            risk = eScan.nextInt();         //risk
        }

        skillType = inFile.readLine().toLowerCase();  //skill type
        
        itemNameStr = inFile.readLine();   //Item Name String version
        
        //Reading and processing the item type and passing the value accordingly
        itemTypeLine = inFile.readLine();
        
        eScan = new Scanner(itemTypeLine);
        
        itemType = eScan.next();
        if(itemType.equals("EquipableItem")){
            skill = eScan.next();
            boost = eScan.nextInt();
            item = new EquipableItem(itemNameStr,skill,boost);
        }
        else{
            currCount = eScan.nextInt();
            maxCount = eScan.nextInt();
            item = new StackableItem(itemNameStr,currCount,maxCount);
        }

        //Process of item Type ends Here
        

        eventDescription = inFile.readLine();   //description

        winDesc = inFile.readLine();        //win message

        losDesc = inFile.readLine();        //lose message

        //Retrieving Process Ends Here

        currEvent = new Encounter(skillType,difficulty,item,risk);
        currEvent.setDescriptions(eventName,eventDescription,winDesc,losDesc);

        return currEvent;

    }

}

