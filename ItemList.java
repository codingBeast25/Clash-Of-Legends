//This class is used for managing goups of various items
import java.util.*;
public class ItemList
{
    
    // instance variables 
    private ArrayList itemArr;
    private int counter; //used to count the number of objects in array

    /**
     * Constructor for creating array object
     */
    public ItemList()
    {
        // initialise instance variables
        itemArr = new ArrayList();
        counter = 0;
    }

    //adds new item object to the array
    /*Lots of condition checked:-
     * 1.is the item already there.
     *      if it is then append it to that item and increment the currCount accordingly
     * 2.If not there then just normal append to list
     */
    public void add_Item(Item newItem){

        if(newItem instanceof StackableItem){
            //just to check if the list already has that item
            if(containsItem(newItem)){
                StackableItem newSItem = (StackableItem) newItem;   //the new Stackable Item
                StackableItem currSItem = (StackableItem)findItem(newItem); //the existing stackable item
                if(containsItem(currSItem)){    //check if the there is the item named as as newItem name already in the list
                    
                    if(currSItem.addItems(newSItem.getCurrCount())){
                        currSItem.addItems(newSItem.getCurrCount());
                    }
                    
                    else{
                        int remainingSpaces = currSItem.remainingSpace();
                        currSItem.setCurrCount(currSItem.getMaxCount());
                        newSItem.setCurrCount(newSItem.getCurrCount() - remainingSpaces);
                        itemArr.add(newSItem);
                        counter++;
                    }
                }
            }
            
            else{           //if item not there in the list
                itemArr.add(newItem);
                counter++;
            }
        
        }
        
        else{
            itemArr.add(newItem);
            counter++;
        }
        
    }

    //Returns no. of item object in the array
    public int size(){
        return counter;
    }

    //Output the list of objects in array
    public String toString(){
        String str = "[";

        for(int i = 0;i <= counter;i++){
            if ( i == counter - 1 ){
                str = str + itemArr.get(itemArr.size()-1) + "]";
            } else if(counter == 0){
                str= str + "Empty]";
            }
            else if (i>=0 && i<counter){
                str = str + itemArr.get(i) + ",";
            }
        }
        return str;
    }

    //return the boolean value if the item is their in the list or not
    public boolean containsItem(Item doesContain){
        return itemArr.contains(doesContain);
    }

    //returns the reference of the item found in the arrayList
    public Item findItem(Item toFind){

        if(containsItem(toFind)){
            int indexVal = itemArr.lastIndexOf(toFind);

            Object itemFound = itemArr.get(indexVal);

            return (Item)itemFound;
        }

        else{
            return null;
        }
    }

    //remove the item from the list
    public Item removeItem(Item toRemove){
        if(containsItem(toRemove)){
            itemArr.remove(toRemove);
            return toRemove;
        }
        else{
            return null;
        }
    }

    //Method to return the arrayList containing only equipableItem type
    public ArrayList<EquipableItem> getEquipableItems(){

        ArrayList<EquipableItem> listOfEquipItem = new ArrayList<EquipableItem>();
        
        for(Object currItem : itemArr){
            
            if(currItem instanceof EquipableItem){
                
                currItem = (Item) currItem;     //cast it to Item Type
                listOfEquipItem.add((EquipableItem) currItem);  //append the item which is casted to EquipableItem type to array list
            }

        }
    

        return listOfEquipItem;
    }
}

