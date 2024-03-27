/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        //Part 1: Menu
        
        //Welcome Screen
        System.out.println("Welcome to Petopia");
        System.out.println("^-^");
        
        //Part 3: username and Password 
        System.out.println("\nPlease enter your Username and Password");
        System.out.print("Username: ");
        String username = s.next();
        System.out.print("Password: ");
        String password = s.next();
        
        //Initializes Variables
        String pet = "";
        int health = 0;
        int food = 0;
        int energy = 0;
        String petName = "";
        
        //Letters
        String vowels = "aeiou";
        String consonant = "bcdfghjklmnpqrstvwxyz";
        String consonantUpper = "BCDFGHJKLMNPQRSTVWXYZ";
       
        if(!(username.equals("snoopy") && password.equals("toto"))){
            System.out.println("Wrong username or password");
            System.exit(0);
        }
        
        while(true){
            //Splash Screen
            System.out.println("MENU\n1. Start\n2. Instructions\n3. Exit");
            String option = s.next();
            option = option.toLowerCase();
            
            //Part 2: Decision Structures
            
            //Switch statement for option
            switch (option) {
                //Start menu
                case "1":
                case "start":
                    //Asks user what pet they want
                    System.out.println("What pet do you want:\n1:Dog\n2:Cat\n3:Child");
                    int petChoice = s.nextInt();
                    
                    switch(petChoice){
                        //Dog choice
                        case 1: 
                            pet = """
                                     __      _
                                   o'')}____//
                                    `_/      )
                                    (_(_/-(_/""";
                            break;
                            
                        //Cat choice
                        case 2:
                            pet = """
                                    /\\_/\\  (
                                   ( ^.^ ) _)
                                     \\"/  (
                                   ( | | )
                                  (__d b__)""";
                            break;
                            
                        //Child choice
                        case 3:
                            pet = """
                                    ,---------.
                                    ||\"\"\"\"\"""||
                                    ||       ||
                                    |/-->&<--\\|
                                    |  (._.)  |
                                    |  ( @ )  |
                                    | /|`"'|\\ |
                                   //(_\\___/_)\\\\
                                   \\\\_()___()_//
                                    `+---I---+'
                                    |\\(_)|(_)/|
                                   _|j\"\"\"\"\"""|j_
                                   | |_______| |
                                   |_|       |_| """;
                            break;
                    }
                    
                    //Prints out ascii art choice of pet
                    System.out.println(pet);
                    
                    //Part 4: Pet name
                    System.out.println("Naming: \n1.Choose\n2.Generate");
                    int choice = s.nextInt();
                    
                    //If choice is 1, user inputs the pet name
                    if(choice == 1){
                        System.out.println("Input your desired pet name:");
                        petName = s.next();
                        
                    //If choice is 2, pet name is randomly generated
                    }else if(choice == 2){
                        //Length of name (not including double letter possibility)
                        int petNL = r.nextInt(5) + 4;
                        
                        //Loop to generate random characters
                        for(int i = 0; i < petNL; i++){
                            //Double letter possibility = 1 in 5
                            int doubleLetter = r.nextInt(5);
                            int letter;
                            
                            //Checks to see if letter will be consonant
                            if(i % 2 == 0){
                                //Checks to see if it's not the first letter
                                if(!(petName.length() == 0)){
                                    letter = r.nextInt(21);
                                    petName += consonant.charAt(letter);
                                    
                                    //Double letter if the random numberis 0
                                    if(doubleLetter == 0){
                                        petName += consonant.charAt(letter);
                                    }
                                    
                                //Since it's first letter = capitilized
                                }else{
                                    letter = r.nextInt(21);
                                    petName += consonantUpper.charAt(letter);
                                }
                            //Generates a vowel
                            }else{
                                letter = r.nextInt(5);
                                petName += vowels.charAt(letter);
                                
                                if(doubleLetter == 0){
                                    petName += vowels.charAt(letter);
                                }
                            }
                        }
                    //If something else if inputted, exits system
                    }else{
                        System.out.println("Invalid Input");
                        System.exit(0);
                    }   
                    //Prints out pet name
                    System.out.println("Your pet, named " + petName + ", has been born!");
                    
                    //Part 5: Pet Stats
                    int order = r.nextInt(3);
                    
                    //Order is based on randomly from variable order
                    switch (order) {
                        case 0:
                            health = r.nextInt(20);
                            food = r.nextInt(20 - health);
                            energy = 20 - health - food;
                            break;
                        case 1:
                            food = r.nextInt(20);
                            energy = r.nextInt(20 - food);
                            health = 20 - energy - food;
                            break;
                        case 2:
                            energy = r.nextInt(20);
                            health = r.nextInt(20 - energy);
                            food = 20 - health - energy;
                            break;
                    }
                    //Prints out stats
                    System.out.println("Stats:\nMax Health = " + health + "\nMax Food = " + food + "\nMax energy = " + energy);
                    break;

                    
                //Instructions menu
                case "2":
                case "instructions":
                    System.out.println("Instructions");
                    break;
                    
                //Exits program
                case "3":
                case "exit":
                    System.exit(0);
                    break;
        
                //Invalid input
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }
    
}
