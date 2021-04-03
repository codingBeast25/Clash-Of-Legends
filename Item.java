//This class is used to define a item in our program
public abstract class Item
{
    // instance variables 
    private String itemName;

    /**
     * Constructor for calling Random Generator class to generate random items
     */
    public Item(){
        //Calling Random Generator class to generate random item
        itemName = RandomGenerator.getRandomItemName();

    }

    //Another Constructor that accepts name of an item and intialize it.
    public  Item(String newName){
        //Initilaize Item Name
        itemName = newName;

    }

    //Returns the Item Name.
    public String toString(){
        return itemName;
    }
    
    //Customized equals method to suit our purpose will check the item name and return the boolean value
    public boolean equals(Object obj){
        //Checks for the type of object
        if (this instanceof StackableItem && obj instanceof StackableItem){
            StackableItem currObj = (StackableItem) this;
            StackableItem newObj = (StackableItem) obj;
            
            //Checks and compares only the item name not any other variables in object
            if(newObj.getStackItem().equals(currObj.getStackItem())){
                return true;
            }
            else{
                return false;
            }
        }
        //else return the general equals method 
        else{
            return (this == obj);

        }
    }
}
