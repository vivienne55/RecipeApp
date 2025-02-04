/* RecipeNotebook.java
 * --------------------------------------
 *           Recipe Notebook
 * Writen by: Vivienne Jarrett
 * Updated: 11-07-2024
 * --------------------------------------
 * Database for storing recipes. You can
 * search for recipe names or for ingredients
 * or multiple ingredients.
 * --------------------------------------
 * */

// TODO photos for recipes
// TODO file for all the recipes to be stored in
// TODO sorting through all the recipes in different ways - Collections.sort(recipes)
// TODO searching for multiple stacked ingredients
// TODO
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class RecipeNotebook
{
    public static void main(String[] args)
    {
        /*try{
            File myFile = new File("Recipes.txt");
            if (myFile.createNewFile()){
                System.out.println("New file created.");
            } else{
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error has occured.");
            e.printStackTrace();
        }*/
        Scanner scan = new Scanner(System.in);
        int option;
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        do {
            //print menu - numbered options to choose from
            System.out.println("\n\nYOUR RECIPE BOOK\n----------------");
            System.out.println("(1) Add new recipe");
            System.out.println("(2) Search for recipe");
            System.out.println("(3) Search for ingredient");
            System.out.println("(4) Edit recipe");
            System.out.println("(5) Remove Recipe");
            System.out.println("(6) List all recipes");
            System.out.println("\n(0) Exit");
            System.out.println("-----------------------");
            option = scan.nextInt();
            
            switch(option){
                case 1:
                    //create new recipe screen
                    System.out.println("~ New Recipe ~");
                    String spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    System.out.print("Ingredients (separated by a semi colan ';'): ");
                    String ingredients = scan.nextLine();
                    System.out.print("Utensils (separated by a semi colan ';'): ");
                    String utensils = scan.nextLine();
                    System.out.print("Instructions (separated by a semi colan ';'): ");
                    String instructions = scan.nextLine(); 
                    //System.out.print(instructions);
                    Recipe recipe = new Recipe(name, ingredients, utensils, instructions);
                    recipes.add(recipe);
                    System.out.print("new recipe added!\n");
                    System.out.println(recipe.printRecipe());
                    break;
                case 2:
                    //search for recipe name screen
                    System.out.println("~ Recipe Search ~");
                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                    System.out.print("What recipe are you looking for: ");
                    name = scan.nextLine();
                    for(Recipe i: recipes){
                        if(i.getName().equals(name)){
                            System.out.println(i.printRecipe());
                            break;
                        } else{
                            // no match - conntinue
                        }
                    }
                    System.out.print("No match");
                    break;
                case 3:
                    //search for ingredient name screen
                    System.out.print("found recipes with this ingredient!");
                    break;
                case 4:
                    //edit recipe - search recipe by name to edit - edit menu screen options
                    System.out.println("~ Recipe Search ~");
                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                    System.out.print("What recipe do you want to edit: ");
                    name = scan.nextLine();
                    for(Recipe i: recipes){
                        if(i.getName().equals(name)){
                            System.out.println("(1) Name\n(2) Ingredients\n(3) Utensils\n(4) Instructions");
                            System.out.print("What do you wish to change? ");
                            int choice = scan.nextInt();
                            switch (choice){
                                case 1: //name change
                                    System.out.print("What is the new name? ");
                                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                                    String newName = scan.nextLine();
                                    for(Recipe j :recipes){
                                        if(j.getName().equals(newName)){
                                            System.out.println("Sorry, that name is already taken.");
                                            break;
                                        } else{
                                            // no match - continue
                                        }
                                    }
                                    i.setName(newName);
                                    System.out.println("Name updated!");
                                    break;
                                case 2: //ingredient change
                                    System.out.println(i.getIngredients());
                                    System.out.print("Please renter your ingredients list correctly (separated by ';'): ");
                                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                                    ingredients = scan.nextLine();
                                    i.setIngredients(ingredients);
                                    System.out.println("Ingredients updated!");
                                    break;
                                case 3: //utensil change
                                    System.out.println(i.getUtensils());
                                    System.out.print("Please renter your utensils list correctly (separated by ';'): ");
                                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                                    utensils = scan.nextLine();
                                    i.setUtensils(utensils);
                                    System.out.println("Utensils updated!");
                                    break;
                                case 4: //instructions change
                                    System.out.println(i.getInstructions());
                                    System.out.print("Please renter your instructions list correctly (separated by ';'): ");
                                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                                    instructions = scan.nextLine();
                                    i.setInstructions(instructions);
                                    System.out.println("Instructions updated!");
                                    break;
                                default:
                                    System.out.println("Sorry, invalid selection.");
                                    break;
                            }
                            break;
                        } else{
                            // no match - conntinue
                        }
                    }
                    System.out.println("No recipe found.");
                    break;
                case 5:
                    // search recipe by name - ensure they wish to remove it
                    System.out.println("~ Remove recipe ~");
                    System.out.println("(If you want to go back to the main menu enter 'back')");
                    String back = "back"; //USed to navigate back to the main menu if remove recipe was accidently clicked
                    spare = scan.nextLine(); //Consumes any new line characters for input to work correctly
                    System.out.print("What recipe do you wish to remove: ");
                    name = scan.nextLine();
                    for(Recipe i: recipes){
                        if(i.getName().equals(name)){
                            //TODO recipe.remove(i);
                            System.out.println("Recipe removed!");
                            break;
                        } else if(back.equals(name)){
                            // go back to main menu
                            System.out.println("Back to the main menu.");
                            break;
                        } else{
                            // no match - conntinue
                        }
                    }
                    System.out.print("No match");
                    break;
                case 6:
                    //list all the recipes in alphabetical order
                    //TODO recipes.sort() the list into alphabetical order
                    for(Recipe i: recipes){
                        System.out.println(i.getName());
                    }
                    break;
                case 0:
                    System.out.print("you reached case 0");
                    break;
                default:
                    System.out.println("Sorry, " + option + " isn't a valid option, please try again.");
            }
        } while (option != 0);

        System.out.print("Goodbye!");
        System.exit(0);
    }
}