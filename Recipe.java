/* Recipe.java
 * --------------------------------------
 *          Recipe object class
 * Writen by: Vivienne Jarrett
 * Updated: 11-07-2024
 * --------------------------------------
 * Recipe objects hold a list of ingredients,
 * utensils, and instructions to follow.
 * Recipes can be searched for by their name
 * or the name of an ingredient in recipe.
 * Pictures may be added later. 
 * --------------------------------------
 * */

// TODO quantities for ingredients? An ingredient class?

import java.util.ArrayList;
import java.util.Arrays;

public class Recipe
{
    // -Instance Variables-
    private String name;
    private ArrayList<String> ingredients;
    private ArrayList<String> utensils;
    private ArrayList<String> instructions;

    // -Default Constructor-
    public Recipe(){
        // not needed
    }

    // -Constructor-
    public Recipe(String inName, String inIngredients, String inUtensils, String inInstructions){
        setName(inName);
        setIngredients(inIngredients);
        setUtensils(inUtensils);
        setInstructions(inInstructions);
    }

    // -METHODS-
    public String printRecipe(){
        String tempList = "~~~~~~~~~~~~~~~~~~~~~\n";
        tempList += "~" + getName() + "~\n";
        tempList += getIngredients() + "\n";
        tempList += getUtensils() + "\n";
        tempList += getInstructions() + "\n";
        return tempList;
    }

    // -Getters and Setters-
    public void setName(String in){
        name = in;
    }
    
    public void setIngredients(String in){
        //extract each ingredient separated by ; and putt into the list
        String[] words = in.split(";");
        ingredients = new ArrayList<String>(Arrays.asList(words));
    }

    public void setUtensils(String in){
        //extract each utensil needed, separated by ; and put into utensil list
        String[] words = in.split(";");
        utensils = new ArrayList<String>(Arrays.asList(words));
    }

    public void setInstructions(String in){
        //extract each instruction, separated by ; and put into instructions list
        String[] words = in.split(";");
        instructions = new ArrayList<String>(Arrays.asList(words));
    }

    public String getName(){
        return name;
    }

    public String getIngredients(){
        String tempList = "-INGREDIENTS-\n";
        // code for extracting all ingredinetss and putting into templist
        for(String i : ingredients){
            tempList += i + '\n';
        }
        return tempList;
    }

    public String getUtensils(){
        String tempList = "-UTENSILS-\n";
        // code for extracting all utensils and putting into templist
        for(String i: utensils){
            tempList += i + '\n';
        }
        return tempList;
    }

    public String getInstructions(){
        String tempList = "-INSTRUCTIONS-\n";
        //code for retunring all instructuoins and putting into templist
        for(String i: instructions){
            tempList += i + '\n';
        }
        return tempList;
    }

}