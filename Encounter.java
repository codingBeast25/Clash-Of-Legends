/* This Class defines the functionality of the Hero player */

public class Encounter{

    private String statToCheck; // which Skill stat is being used. (eg. "mental" or "physical")
    private int difficulty; // difficulty of the stat check (compared to hero skill)
    private Item reward; // what the hero gets if they win the Encounter
    private int risk; // how much stress the hero gains if they lose.

    //Description Varibales
    private String game_name;
    private String game_description;
    private String winningDescription;
    private String losingDescription;

    //CONSTRUCTOR()
    public Encounter(String statType,int newDifficulty,Item newReward,int newRisk){

        statToCheck = statType;
        difficulty = newDifficulty;
        reward = newReward;
        risk = newRisk;
    }

    //Accesor For getting the Skill type
    public String getSkillType(){
        return ""+statToCheck;
    }

    //Accessor For getting difficulty level
    public int getDifficultyLevel(){
        return difficulty;
    }

    //Accessor for retrieving Item
    public Item getReward(){
        return reward;
    }

    //Get the Risk to add to the stress if the player looses
    public int getRisk(){
        return risk;
    }

    //Accessor for winDescription
    public String getWinDescription(){
        return ""+winningDescription;
    }

    //Accessor for loseDescription
    public String getLoseDescription(){
        return ""+losingDescription;
    }

    //Accessor for Game Name
    public String getGameName(){
        return ""+game_name;
    }

    //Returning the Game Description
    public String getGameDescription(){
        return ""+game_description;
    }
    
    public void setNullReward(){
        reward = null;
    }

    //Mutators for description of the player

    public void setDescriptions(String gameName, String gameDescription, String winDescription,String loseDescription){

        game_name = gameName;
        game_description = gameDescription;
        winningDescription = winDescription;
        losingDescription = loseDescription;
    }

}