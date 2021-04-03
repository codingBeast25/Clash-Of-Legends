/* This class is the sub-class for our item
 * it is a kind of item that our hero can get
 * this class has various different functionality which includes:
 * 1.Intialize the item type
 * 2.group item of same name together(quite complicated invloves calling of other methods too)
 * 3.remove items
 * 4.toString to print the item
 */

public class StackableItem extends Item
{
    private int currCount;  //current number of item
    private int maxCount;   //max that it can hold of a same item
    private String stackItemName;   //for item name 
    
    //Constructor 1 just to intialise
    public StackableItem(){
        currCount = 0;
        maxCount = 10;
    }
    
    //Constructor 2 
    public StackableItem(String newName){
        super(newName);
        stackItemName = newName;    //just so that we can use it for later stages
        currCount = 0;
        maxCount = 10;
    }
    
    //Constructor 3 which passes everything
    public StackableItem(String newName, int newcurrCount, int newmaxCount){
        super(newName);
        stackItemName = newName;
        currCount = newcurrCount;
        maxCount = newmaxCount;
    }
    
    //Return item name from the stackable item object
    public String getStackItem(){
        return stackItemName;
    }

    //toString method to print out all the data.
    public String toString(){
        return super.toString() +" ["+ currCount + "/" + maxCount + "]";
    }

    //get the current number of items
    public int getCurrCount(){
        return currCount;
    }

    //Sets the current number
    public void setCurrCount(int num){
        currCount = num;
    }

    //get maximum number of items
    public int getMaxCount(){
        return maxCount;
    }

    //get remaining spaces
    public int remainingSpace(){
        return getMaxCount() - getCurrCount();
    }
    
    //adds item and increments the currCount by the number passed
    public boolean addItems(int numToAdd){
        if(numToAdd >= 0 && currCount + numToAdd <= maxCount){
            currCount += numToAdd;
            return true;
        }
        else{
            return false;
        }
    }
    
    //Method to remove specified number of items
    public boolean removeItems(int numToRemove){
        if(numToRemove >= 0 && currCount - numToRemove >= 0){
            currCount -= numToRemove;
            return true;
        }
        else{
            return false;
        }
    }
}
