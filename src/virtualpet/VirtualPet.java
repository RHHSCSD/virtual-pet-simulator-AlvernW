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
        //Part 1: Menu
        String pet = "";
        System.out.println("Welcome to your virutal pet Simulator");
        System.out.println("^-^");
        while(true){
            //Splash Screen
            System.out.println("1. Start\n2. Instructions\n3. Exit");
            String option = s.next();
            //Part 2: Decision Structures
            //Switch statement for option
            switch (option) {
                case "1":
                case "Start":
                    System.out.println("What pet do you want");
                    
                    break;
                case "2":
                case "Instructions":
                    System.out.println("Instructions");
                    break;
                case "3":
                case "Exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }
    
}
