
/**
 * Blue print for the player character.
 *This Will create our Hero with all the parameters.(Name , description, current stress level, maximum stress level, current state, skill sets) 
 */
import java.util.*;

public class Hero{
    // instance variables 

    private String name;    //player Name
    private String description; //description of the player

    //Stress level:- current and maximum capacity.
    private int maxStress;      
    private int currentStress;

    private boolean isAwake = true;     //CURRENT STATUS OF PLAYER

    //Skill sets of a player
    private int physical;           
    private int mental;
    private int social;

    //Inventory array which will store all the items appended to hero.
    private ItemList inventory = new ItemList();

    /**
     * Constructor for objects of class Hero
     */
    public Hero(String NewName, String NewDescription,int newCurrentStress,int NewmaxStress){

        name =NewName;
        description = NewDescription;

        currentStress = newCurrentStress; 
        maxStress = NewmaxStress; 

    }
    //Accessor for Name of the player
    public String getName(){
        return name;
    }

    //Accessor for description 
    public String getDescription(){
        return description;
    }

    //Accessor for Physical Skill
    public int getPhysicalSkill(){
        return physical;
    }

    //Accessor for Mental Skill
    public int getMentalSkill(){
        return mental;
    }

    //Accessor for Social Skill
    public int getSocialSkill(){
        return social;
    }

    //Adding Stress Method
    public void addStress(int amount){

        currentStress += amount;
    }

    //sets the description
    public void setDescription(String newDescription){
        description = newDescription;
    }

    //Sets the value for all the skills
    public void setSkills(int newPhysical, int newMental, int newSocial){
        physical = newPhysical;
        mental = newMental;
        social = newSocial;
    }

    //Adding items to inventory
    public void addItem(Item itemAdd){
        inventory.add_Item(itemAdd);
    }

    //Outputs All the Skills value
    public String skillsToString(){
        return "- Physical: "+physical+"\n- Mental:"+mental+"\n- Social:"+social;
    }

    //Returning name,description,current and max stress
    public String profileToString(){
        return "Name: "+name+"\nDescription:"+description+"\n"+"Stress= "+currentStress+"/"+maxStress;
    }

    //Print all the items from the itemlist
    public String allItems(){
        return ""+inventory.toString();
    }

    //Print all info all in together
    public String fullToString(){
        return name+"\n"+description+"\nStress: "+currentStress+"/"+maxStress+"\n"+skillsToString()+"\n"+allItems();
    }

    //Status Check method to check the current status of our Hero.
    public boolean checkStatus(){
        if (currentStress >= maxStress){
            isAwake = false;
            return false;
        }
        else{
            return true;
        }
    }

    //Logic for comparing skill with skill type specified by Encounter object.
    //Also it adds bonus skill boost if equipable item is detected
    public boolean skillCheck(String skillType, int value){

        int physicalSkill = getPhysicalSkill();
        int mentalSkill = getMentalSkill();
        int socialSkill = getSocialSkill();

        ArrayList<EquipableItem> equipableList = inventory.getEquipableItems();
        
        //For checking and giving the extra boost
        for(EquipableItem currItem : equipableList){

            String currSkillType = currItem.getSkillType();
            int currBoostAmt = currItem.getBoostAmt();

            if(currSkillType.equals("physical")){
                physicalSkill = physicalSkill + currBoostAmt;
                //System.out.println("our new physical stats for hero are: "+ physicalSkill); (Just to test it)
            }
            else if(currSkillType.equals("mental")){
                mentalSkill = mentalSkill + currBoostAmt;
                //System.out.println("our new mental stats for hero are: "+ mentalSkill);(Just to test it)
            }
            else if(currSkillType.equals("social")){
                socialSkill = socialSkill + currBoostAmt;
                //System.out.println("our new social stats for hero are: "+ socialSkill);(Just to test it)
            }

        }

        if ("social".equals(skillType)){
            if (social >= value){
                return true;
            }
        }
        else if ("mental".equals(skillType)){
            if (mental >= value){
                return true;
            }
        }
        else if ("physical".equals(skillType)){
            if (physical >= value){
                return true;
            }
        }

        return false;
    }
}
