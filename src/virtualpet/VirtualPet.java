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
    public static Scanner s = new Scanner(System.in);
    public static Random r = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Part 1: Menu

        //Welcome Screen
        System.out.println("Welcome to Petopia");
        System.out.println("^-^");

        //Part 3: username and Password 
        login();

        
        //Initializes Variables
        String pet = "";
        int health = 0;
        int food = 0;
        int energy = 0;
        int cHealth;
        int cFood;
        int cEnergy;
        
        String petName = "";

        while (true) {
            //Splash Screen
            System.out.println("MENU\n1.Start\n2.Instructions\n3.Exit");
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

                    switch (petChoice) {
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

                    petName = makeName(choice);
                    //Prints out pet name
                    System.out.println("Your pet, named " + petName + ", has been born!");

                    //Part 5: Pet Stats
                    for (int i = 0; i < 20; i++) {
                        int order = r.nextInt(3);
                        switch (order) {
                            case 0:
                                health++;
                                break;
                            case 1:
                                energy++;
                                break;
                            case 2:
                                food++;
                                break;
                        }
                    }
                    cHealth = health;
                    cEnergy = energy;
                    cFood = food;
                    //Prints out stats
                    System.out.println("Stats:\nMax Health = " + health + "\nMax Food = " + food + "\nMax energy = " + energy);

                    int token = 0;

                    boolean alive = true;
                    while (alive == true) {
                        System.out.println("MENU\n1. Play\n2. Instructions\n3. Exit");
                        String option2 = s.next();
                        option2 = option2.toLowerCase();

                        switch (option2) {
                            case "1":
                            case "play":
                                System.out.println("PLAY MENU\n1. Game\n2. Interact\n3. Exit");
                                String optionP = s.next();
                                switch(optionP){
                                    case "1":
                                        System.out.println("GAME MENU:\n1. Number Guessing Game\n2. Matching Game");
                                        String optionG = s.next();

                                        switch (optionG) {
                                            case "1":
                                                int nAttempts = playGuessingGame();

                                                if (nAttempts == 10) {
                                                    System.out.println("You obtained 10 tokens");
                                                    token += 10;
                                                } else if (nAttempts > 7) {
                                                    System.out.println("You obtained 7 tokens");
                                                    token += 7;
                                                } else if (nAttempts > 4) {
                                                    System.out.println("You obtained 4 tokens");
                                                    token += 4;
                                                } else if (nAttempts > 0) {
                                                    System.out.println("You obtained 2 tokens");
                                                    token += 2;
                                                } else {
                                                    System.out.println("You obtained 0 tokens");
                                                }
                                                break;

                                            case "2":
                                                int attemptsM = playMatchingGame();
                                                if (attemptsM <= 5 && attemptsM > 0) {
                                                    System.out.println("You obtained 10 tokens");
                                                    token += 10;
                                                } else if (attemptsM <= 7 && attemptsM > 0) {
                                                    System.out.println("You obtained 7 tokens");
                                                    token += 7;
                                                } else if (attemptsM <= 10 && attemptsM > 0) {
                                                    System.out.println("You obtained 4 tokens");
                                                    token += 4;
                                                } else if (attemptsM > 0) {
                                                    System.out.println("You obtained 2 tokens");
                                                    token += 2;
                                                } else {
                                                    System.out.println("You obtained 0 tokens");
                                                }
                                                break;

                                        }
                                    case "2":
                                        System.out.println("INTERACT MENU\n1. Play\n2. Feed\n3. Groom");
                                        String optionI = s.next();
                                        switch(optionI){
                                            case "1":
                                                if(cEnergy == energy){
                                                    System.out.println("Your pet's current energy is full");
                                                }else{}
                                                break;
                                            case "2":
                                                if(cFood == food){
                                                    System.out.println("Your pet's current food is full");
                                                }
                                                break;
                                            case "3":
                                                if(cHealth == health){
                                                    System.out.println("Your pet's current health is full");
                                                }
                                                break;
                                        }
                                    case "3":
                                        break;
                                }
                            case "2":
                            case "instructions":
                                break;

                            case "3":
                            case "exit":
                                System.exit(0);
                                break;
                        }

                    }
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
    public static void login() { 
        System.out.println("\nPlease enter your Username and Password");
        int attempts = 0;
        while (!(attempts >= 3)) {
            System.out.print("Username: ");
            String username = s.next();
            System.out.print("Password: ");
            String password = s.next();
            if (!(username.equals("snoopy") && password.equals("toto"))) {
                System.out.println("Wrong username or password");
                attempts++;
            } else {
                attempts = 4;
            }
        }
        if (attempts == 3) {
            System.out.println("Entered incorrectly too many times.");
            System.exit(0);
        }

    }

    public static String makeName(int choice) {
        String petName = "";
        
        //Letters
        String vowels = "aeiou";
        String consonant = "bcdfghjklmnpqrstvwxyz";
        String consonantUpper = "BCDFGHJKLMNPQRSTVWXYZ";
        
        //If choice is 1, user inputs the pet name
        switch (choice) {
            case 1:
                System.out.println("Input your desired pet name:");
                petName = s.next();
                
                //If choice is 2, pet name is randomly generated
                break;
            case 2:
                //Length of name (not including double letter possibility)
                int petNL = r.nextInt(5) + 4;
                //Loop to generate random characters
                for (int i = 0; i < petNL; i++) {
                    //Double letter possibility = 1 in 5
                    int doubleLetter = r.nextInt(5);
                    int letter;
                    
                    //Checks to see if letter will be consonant
                    if (i % 2 == 0) {
                        //Checks to see if it's not the first letter
                        if (!(petName.length() == 0)) {
                            letter = r.nextInt(21);
                            petName += consonant.charAt(letter);
                            
                            //Double letter if the random numberis 0
                            if (doubleLetter == 0) {
                                petName += consonant.charAt(letter);
                            }
                            
                            //Since it's first letter = capitilized
                        } else {
                            letter = r.nextInt(21);
                            petName += consonantUpper.charAt(letter);
                        }
                        //Generates a vowel
                    } else {
                        letter = r.nextInt(5);
                        petName += vowels.charAt(letter);
                        
                        if (doubleLetter == 0) {
                            petName += vowels.charAt(letter);
                        }
                    }
                }
                //If something else if inputted, exits system
                break;
            default:
                System.out.println("Invalid Input");
                System.exit(0);
        }
        return petName;
    }

    public static int playGuessingGame() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("Welcome to number guessing game.");
        int randNum = r.nextInt(100) + 1;
        int nAttempts = 10;
        boolean gOn = true;
        System.out.println("Guess the number between 1 to 100");
        System.out.println("You have 10 attempts.");

        while (gOn) {
            System.out.println("Guess the random number: ");
            int guess = s.nextInt();

            nAttempts--;

            System.out.println("You have " + nAttempts + " attempts remaining.");

            if (guess == randNum) {
                System.out.println("You guessed correctly!!!");
                gOn = false;
            } else if (guess > randNum) {
                System.out.println("Guessed number is larger");
            } else {
                System.out.println("Guessed number is smaller");
            }

            if (nAttempts == 0) {
                System.out.println("You've used up all your attempts :(");
                gOn = false;
            }
        }
        return nAttempts;
    }

    public static int playMatchingGame() {
        System.out.println("Welcome to matching game.");
        int attemptsM = 0;
        String abc = "AABBCCDDEE";
        int abcL = abc.length();
        for (int i = abcL - 1; i > 0; i--) {
            int index = r.nextInt(abcL);
            int index2 = r.nextInt(abcL);
            char temp = abc.charAt(index);
            char temp2 = abc.charAt(index2);
            abc = abc.substring(0, index2) + temp + abc.substring(index2 + 1);
            abc = abc.substring(0, index) + temp2 + abc.substring(index + 1);
        }
        
        boolean con = true;
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean e = false;
        
        while (con) {
            int index1 = s.nextInt();
            int index2 = s.nextInt();
            if (index1 == -1 || index2 == -1) {
                return 0;
            }
            for (int i = 0; i < abc.length(); i++) {
                char letter = abc.charAt(i);
                boolean match = abc.charAt(index1) == abc.charAt(index2) && index1 != index2;
                if (i == index1 || i == index2) {
                    System.out.print(letter);
                    if (match && abc.charAt(index1) == 'A') {
                        a = true;
                    } else if (match && abc.charAt(index1) == 'B') {
                        b = true;
                    } else if (match && abc.charAt(index1) == 'C') {
                        c = true;
                    } else if (match && abc.charAt(index1) == 'D') {
                        d = true;
                    } else if (match && abc.charAt(index1) == 'E') {
                        e = true;
                    }
                } else {
                    if (letter == 'A' && a) {
                        System.out.print(letter);
                    } else if (letter == 'B' && b) {
                        System.out.print(letter);
                    } else if (letter == 'C' && c) {
                        System.out.print(letter);
                    } else if (letter == 'D' && d) {
                        System.out.print(letter);
                    } else if (letter == 'E' && e) {
                        System.out.print(letter);
                    } else {
                        System.out.print("*");
                    }
                }
            }
            attemptsM++;
            if (a && b && c && d && e) {
                System.out.println("\nYou win!");
                System.out.println("Attempts:" + attemptsM);
                con = false;
            }
            System.out.println();
        }
        return attemptsM;
    }
    public static int petPlay(){
    
    }
    
    public static int petFeed(){
    
    }
    
    public static int petGroom(){
    
    }

}
