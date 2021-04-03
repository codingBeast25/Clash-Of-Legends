/* This class is the sub-class for our item
 * it is a kind of item that our hero can get and equip
 * this class has various different functionality which includes:
 * 1.Intialize the item type
 * 2.Acessor for different variables stored
 * 3.toString for Printing
 * 
 */
public class EquipableItem extends Item
{
    
    //which skill will be boosted
    private String skillType;   
    
    //how much will it boost
    private int amtBoost;
    
    //Constructor 1
    public EquipableItem(){
       //random name for our item
       super();
       skillType = "physical";
       //random interger for skill boost
       amtBoost = RandomGenerator.randomRoll(1,10);
    }
    
    //Constructor 2
    public EquipableItem(String newName, String newSkillType , int boost){
        super(newName);
        skillType = newSkillType;
        amtBoost = boost;
    }
    
    //Accessor for skillType
    public String getSkillType(){
        return skillType.toLowerCase();
    }
    
    //Accessor for boost amount
    public int getBoostAmt(){
        return amtBoost;
    }
    
    //toString method
    public String toString(){
        return super.toString() + " [" + skillType + " +" + amtBoost + "]" ;
    }
}
