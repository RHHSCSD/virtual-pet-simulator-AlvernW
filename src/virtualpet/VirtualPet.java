/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;

import java.util.*;
import java.io.*;

/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {
    //static variables to use in other functions
    public static Scanner s = new Scanner(System.in);
    public static Random r = new Random();
    public static boolean newGame = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //Part 1: Menu

        //Welcome Screen
        System.out.println("Welcome to Petopia");
        System.out.println("""
                            _._     _,-'""`-._
                           (,-.`._,'(       |\\`-/|
                               `-.-' \\ )-`( , o o)
                                     `-    \\`_`"'-""");

        //Part 3: username and Password 
        System.out.println("\nEnter your username");
        String user = s.next();
        File player = player(user);
        
        //Initializes Variables
        BufferedReader reader = new BufferedReader(new FileReader(player));
        
        //Ascii of pet
        String pet = "";
        //Array to count the stats: 0 is health, 1 is current health, 2 is food, 3 is current food, 4 is energy, 5 is current energy
        double[] stats = new double[6];
        //Array to count the amount of times the pet has been interacted with
        double[] iTracker = new double[3];
        //amount of tokens
        int token = 0;
        //species number
        int species = 0;
        //name of pet
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
                    
                    if(newGame){
                        System.out.println("What pet do you want:\n1:Dog\n2:Cat\n3:Child");
                        int petChoice = s.nextInt();

                        species = petChoice;
                        pet = assignPet(petChoice);

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
                                    //Health
                                    stats[0]++;
                                    break;
                                case 1:
                                    //Food
                                    stats[2]++;
                                    break;
                                case 2:
                                    //Energy
                                    stats[4]++;
                                    break;
                            }
                        }
                        //Health
                        stats[1] = stats[0];
                        //Food
                        stats[3] = stats[2];
                        //Energy
                        stats[5] = stats[4];
                        //Prints out stats
                        System.out.println("Stats:\nMax Health = " + stats[0] + "\nMax Food = " + stats[2] + "\nMax energy = " + stats[4]);
                    }else{
                        //if new game is false reads all data from file player and stores it in the variables 
                        System.out.println("Welcome Back " + user);
                        String placeholder = reader.readLine();
                        petName = reader.readLine();
                        species = Integer.parseInt(reader.readLine());
                        stats = stringToDoubleArray(reader.readLine());
                        iTracker = stringToDoubleArray(reader.readLine());
                        token = Integer.parseInt(reader.readLine());
                        
                        pet = assignPet(species);
                        
                        //prints the name and the ascii art of the pet
                        System.out.println(petName + "\n" + pet);
                        
                        //Prints out stats
                        System.out.println("Stats:\nMax Health = " + stats[0] + "\nMax Food = " + stats[2] + "\nMax energy = " + stats[4]);
                        System.out.println();
                        //Current pet stats
                        System.out.println("Current Stats:\nCurrent Health = " + stats[1] + "\nCurrent Food = " + stats[3] + "\nCurrent energy = " + stats[5]);
                                
                        System.out.println("Tokens:" + token);
                        
                    }
                    
                    
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
                                                //calls guessing game
                                                int nAttempts = playGuessingGame();

                                                //gives tokens depending on the attempts used
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
                                        break;
                                    case "2":
                                        System.out.println("INTERACT MENU\n1. Play\n2. Feed\n3. Groom");
                                        String optionI = s.next();
                                        switch(optionI){
                                            case "1":
                                                //Health
                                                if(stats[0] == stats[1]){
                                                    System.out.println("Your pet's current health is full");
                                                }else{
                                                    stats[1] += petGroom(iTracker);
                                                    if(stats[1] > stats[0]){
                                                       stats[1] = stats[0];
                                                    }
                                                }
                                                break;
                                            case "2":
                                                //Food
                                                if(stats[2] == stats[3]){
                                                    System.out.println("Your pet's current food is full");
                                                }else{
                                                    stats[3] += petPlay(iTracker);
                                                    if(stats[3] > stats[2]){
                                                       stats[3] = stats[2];
                                                    }
                                                }
                                                break;
                                            case "3":
                                                //Energy
                                                if(stats[4] == stats[5]){
                                                    System.out.println("Your pet's current energy is full");
                                                }else{
                                                    stats[5] += petGroom(iTracker);
                                                    if(stats[5] > stats[4]){
                                                       stats[5] = stats[4];
                                                    }
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
                                //overwrites the files data and stores the current data
                                overwrite(player, petName, species, stats, iTracker, token);
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
                    //overwrites the files data and stores the current data
                    overwrite(player, petName, species, stats, iTracker, token);
                    System.exit(0);
                    break;

                //Invalid input
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }
    public static File player(String user) throws IOException {
        String p;
        int attempts = 0;
        File player = new File(user + ".txt");
        if (player.exists()) {
            while (true) {
                Scanner r = new Scanner(player);
                System.out.println("Enter your password");
                p = s.next();
                if (r.next().equals(p)) {
                    //Prints out information
                    break;
                } else {
                    System.out.println("Incorrect password. Try again. ");
                    attempts++;
                    if (attempts == 3) {
                        System.out.println("Too many attempts. Try again later.");
                        System.exit(0);
                    }
                }
            }
            System.out.println("welcome back " + user);
            newGame = false;
        } else {
            FileWriter w = new FileWriter(player);
            System.out.println("Enter your desired password. ");
            p = s.next();
            w.write(p);
            w.close();
            System.out.println("Welcome " + user);
            newGame = true;
        }
        return player;
    }

    public static void overwrite(File player, String pName, int s, double[] stats, double[] iTracker, int tokens) {
        try {
            //Creates a buffer reader to read the file
            BufferedReader r = new BufferedReader(new FileReader(player));
            //gets first line for the password
            String pass = r.readLine();
            FileWriter w = new FileWriter(player);
            //stores all data into the file
            w.write(pass + "\n" + pName + "\n" + s + "\n" + Arrays.toString(stats) + "\n" + Arrays.toString(iTracker) + "\n" + tokens);
            w.close();
        } catch (IOException e) {
            System.out.println("Error");
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

    public static double petPlay(double[] a){
        double energyG = (r.nextInt(10) + 1.0)/10.0;
        System.out.println("You played with your pet, you gained: " + energyG + " energy.");
        a[2]++;
        return energyG;
    }
    
    public static double petFeed(double[] a){
        double foodG = (r.nextInt(10) + 1.0)/10.0;
        System.out.println("You fed your pet, you gained: " + foodG + " food.");
        a[1]++;
        return foodG;
    }
    
    public static double petGroom(double[] a){
        double healthG = (r.nextInt(10) + 1.0)/10.0;
        System.out.println("You groomed your pet, you gained: " + healthG + " health.");
        a[0]++;
        return healthG;
    }
    
    public static int playGuessingGame() {

        System.out.println("Welcome to number guessing game.");
        //random number 
        int randNum = r.nextInt(100) + 1;
        int nAttempts = 10;
        //game on variable to see if game is running
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
            boolean match = abc.charAt(index1) == abc.charAt(index2) && index1 != index2;
            if (index1 == -1 || index2 == -1) {
                return 0;
            }
            for (int i = 0; i < abc.length(); i++) {
                char letter = abc.charAt(i);
                if (i == index1 || i == index2) {
                    //prints out the letter if the indexes is given out
                    System.out.print(letter);
                    //checks to see if there is a match, if there is the corresponding boolean variable is turned to true;
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
                    //checks to see if the boolean variable is true to know if a match has already happened
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
            }else{
                System.out.println(" Try again");
            }
            System.out.println();
        }
        //returns the amount of attempts
        return attemptsM;
    }

    public static String assignPet(int petChoice) {
        String pet = "";
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
        return pet;
    }
    
    public static double[] stringToDoubleArray(String str) {
        // Remove brackets
        str = str.replace("[", "").replace("]", "");
        // Split the string by commas and spaces
        String[] stringArray = str.split(", ");
        // Convert each element to double
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }
}
