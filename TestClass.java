import java.io.*;
import java.util.*;

public class TestClass
{
    public static void main(String[] args){
        testEquipableItem();
        
        testStackableItem();
        
        testItemList();
        
        testFileLoading();
        
        testHeroSkillCheck();
        
        
    }
    
    public static void testEquipableItem(){
        //create an object
        try{
            EquipableItem eqItem = new EquipableItem("Gold Medal","mental",5);  //creates an object
            String skill = eqItem.getSkillType();   //returns mental
            System.out.println("Object's skill used is: "+skill+" :Should be mental");
            System.out.println("Our Equipable Item is: "+eqItem.toString());  //prints the object
            System.out.println("End of EquipableItem test");
        }
        catch(Exception e){
            System.out.print(e.getMessage()+" :this is the error found");
        }
    }
    
    public static void testStackableItem(){
        try{
            StackableItem stItem = new StackableItem("Orange Juice",1,5);
            System.out.println(stItem.toString()+" :Should be Orange Juice[1/5]");
            
            stItem.addItems(3);
            System.out.println(stItem.toString()+ " :Should be Orange Juice[4/5]");
            
            if(!stItem.addItems(2)){
                System.out.println("Item is full: "+stItem.toString());
            }
            
            if(!stItem.removeItems(-2)){
                System.out.println("not a valid entry to remove");
            }
            
            stItem.removeItems(2);
            System.out.println(stItem.toString()+" :Should be Orange Juice[2/5]");
            
            System.out.println("End of StackableItem test");
        }
        catch(Exception e){
            System.out.println(e.getMessage()+" :This is the error");
        }
    }
    
    public static void testItemList(){
        //create different types of items
        StackableItem stItem = new StackableItem("Orange Juice",1,5);
        StackableItem stItem1 = new StackableItem("Orange Juice",3,5);
        StackableItem stItem2 = new StackableItem("Apple Juice",4,8);
        
        EquipableItem eqItem = new EquipableItem("Silver Medal","Social",2); 
        EquipableItem eqItem1 = new EquipableItem("Gold Medal","mental",1); 
        EquipableItem eqItem2 = new EquipableItem("Bronze Medal","physical",3); 
        EquipableItem eqItem3 = new EquipableItem("Platinum Medal","physical",1); 
        EquipableItem eqItem4 = new EquipableItem("XYZ medal","mental",0);
        
        //ItemList object 
        ItemList myList = new ItemList();
        myList.add_Item(stItem);
        myList.add_Item(stItem1);
        myList.add_Item(stItem2);
        myList.add_Item(eqItem);
        myList.add_Item(eqItem1);
        myList.add_Item(eqItem2);
        myList.add_Item(eqItem3);
        
        //Printing Out the Entire List
        System.out.println(myList.toString());
        
        Item itemFind = (Item) eqItem;
        System.out.println("Is [XYZ Medal] item there in the list? "+ myList.containsItem(eqItem4));
        
        Item itemToRemove = (Item) stItem2;
        myList.removeItem(itemToRemove);
        System.out.println("After Removing the an item from the list, our list looks like this: "+ myList.toString());
        
        System.out.println("Elements in our list which were of type EquipableItem: "+myList.getEquipableItems());
        
        System.out.println("End of ItemList test");
    }
    
    public static void testFileLoading(){
        noFileFound("abc.txt");
        
        wrongFormatMap("Map.txt");//fileName you can give any fileName that has some error in format i made another txt file with this name
        
        
    }
    
    private static void noFileFound(String fileName){
         try{
            FileReader file = new FileReader(fileName);
            file.close();
        }
        catch(IOException e){
            System.out.println("No Such File Found");
            System.out.println(e.toString());
        }
        System.out.println("noFileFound Method Run Successful");
    }
    
    private static void wrongFormatMap(String mapFileName){
        try{
            FileLoader.loadMap(mapFileName);

        }
        catch(Exception e){
            System.out.println("File Format Wrong for map File");
            System.out.println(e.toString());
        }

        System.out.println("WrongFormat method run successful");
    }
    
    public static void testHeroSkillCheck(){
        Hero testHero = new Hero("Donald Trump","President of United States",80,100);
        testHero.setSkills(3,7,2);
        
        System.out.println("Our Hero oBJECT is created: \n"+testHero.fullToString());
        EquipableItem rewardItem = new EquipableItem("Highest Economy","mental",2);
        
        Encounter testEvent = new Encounter("mental",5,rewardItem,25);
        
        EquipableItem eqItem1 = new EquipableItem("Gold Medal","mental",1); 
        EquipableItem eqItem2 = new EquipableItem("Bronze Medal","physical",3); 
        EquipableItem eqItem3 = new EquipableItem("Platinum Medal","physical",1); 
        EquipableItem eqItem4 = new EquipableItem("XYZ medal","mental",0);
        
        StackableItem stItem = new StackableItem("Orange Juice",1,5);
        StackableItem stItem1 = new StackableItem("Orange Juice",3,5);
        StackableItem stItem2 = new StackableItem("Apple Juice",4,8);
        
        testHero.addItem(eqItem1);
        testHero.addItem(eqItem2);
        testHero.addItem(eqItem3);
        testHero.addItem(stItem);
        testHero.addItem(stItem1);
        testHero.addItem(stItem2);
        
        
        System.out.println("Our Skill check comes out to be: "+testHero.skillCheck("physical",1));
        System.out.println("Our Skill check comes out to be: "+testHero.skillCheck("mental",2));
    }
}
