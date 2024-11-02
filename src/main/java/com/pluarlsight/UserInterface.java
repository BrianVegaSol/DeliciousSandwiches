package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    static Scanner scan = new Scanner(System.in);
    static boolean onHomeMenu = true;
    /*
    Home Screen
o The home screen should give the user the following options. The
application should continue to run until the user chooses to exit.
§ 1) New Order
§ 0) Exit - exit the application
• Order Screen - All entries should show the newest entries first
o 1) Add Sandwich
o 2) Add Drink
o 3) Add Chips
o 4) Checkout
o 0) Cancel Order - delete the order and go back to the home page
• Add Sandwich - the add sandwich screen will walk the user through
several options to create the sandwich
o Select your bread:
o Sandwich size:
o Toppings: - the user should be able to add extras of each topping
§ Meat:
§ Cheese:
§ Other toppings:
§ Select sauces:
o Would you like the sandwich toasted?
• Add Drink - select drink size and flavor
• Add Chips - select chip type
• Checkout - display the order details and the price
o Confirm - create the receipt file and go back to the home screen
o Cancel - delete order and go back to the home screen
    */
    static StringBuilder homeSB = new StringBuilder();


    public static void homeMenu() {
        byte homeInput = -1;
        System.out.println("Welcome to Delicious Sandwiches!");
        while (true) {
            System.out.println("""
                    What would you like to do?
                     1) New Order
                     0) Exit - exit the application""");
            try{
                homeInput = scan.nextByte();
            switch (homeInput) {
                case 0:
                    System.out.println("Thank you for visiting Delicious Sandwiches! Have a great day! :D");
                    scan.close();
                    return;
                case 1:
                    orderMenu();
                    break;
                default:
                    System.out.println("Sorry! I didn't quite catch that");
                    continue;
            }
            if (homeInput == 1) {
                continue;
            }
            break;
            } catch (InputMismatchException e) {
                System.err.println("What did you say???");
                scan.nextLine();
            }
        }

        //scan.close();
    }
    //TODO need to add an if (!= 0) then continue OR another try catch
    public static void orderMenu() {
        System.out.println("""
                Welcome to the Order Menu!
                Select one of the following to get started!
                o 1) Add Sandwich
                o 2) Add Drink
                o 3) Add Chips
                o 4) Checkout
                o 0) Cancel Order
                """);
        byte orderInput = scan.nextByte();
        while (true) {
            //might be a bad idea doing this xO
            byte quantity;
            switch (orderInput) {
                case 0:
                    return;
                case 1:
                    System.out.println("How many sandwiches would you like?");
                    quantity = scan.nextByte();;
                    sandwichMenu(quantity);
                    break;
                default:
                    System.out.println("Sorry! That's not on the menu!\nIs there anything else you would like?");
                    continue;
            }
        }
    }

    public static void sandwichMenu(byte numOfSandwiches) {

    }

    public static void addDrink (byte numOfDrinks) {

    }

    public static void addChips (byte numOfChips) {

    }

}
