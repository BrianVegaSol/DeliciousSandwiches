package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    static Scanner scan = new Scanner(System.in);
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
        //System.out.println("Welcome to " + "\033[32m" + "Delicious Sandwiches!" + "\033[0m");
        homeSB.append("\033[32m").append("Welcome to Delicious Sandwiches!").append("\033[0m");
        System.out.println(homeSB.toString());
        homeSB.setLength(0);
        while (true) {
            System.out.println("""
                    What would you like to do?
                     1) New Order
                     0) Exit - exit the application""");
            try {
                homeInput = scan.nextByte();
                switch (homeInput) {
                    case 0:
                        //TODO/FIXME???
                        // If boolean hasConfirmedOrder = true then sout(Excuse me! You forgot your receipt!)
                        // User choice of looking at receipt 1) My mistake! and look at receipt details or
                        // 2) I'm not paying that! And customer dines n' dashes/ leaves / police come
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
    // B O N U S Have a persistent "You have a Pending Confirmed Order" Message at the top of the screen along with
    // New Function in the switch that allows user to see the Checkout Screen Details!
    public static void orderMenu() {
        byte errCounter = 0;
        while (true) {
            //FIXME if hasPendingOrder = true then show italicized message You have a pending order!
            homeSB.append("\033[34m").append("Welcome to the Order Menu!").append("\033[0m");
            System.out.println(homeSB.toString());
            homeSB.setLength(0);
            System.out.println("""
                    ===========================================
                    Select one of the following to get started!
                    o 1) Add Sandwich
                    o 2) Add Drink
                    o 3) Add Chips
                    o 4) Checkout
                    o 0) Cancel Order
                    ===========================================
                    """);
            try {
                byte orderInput = scan.nextByte();
                //FIXME might be a bad idea doing this xO
                byte quantity = 0;
                switch (orderInput) {
                    case 0:
                        System.err.print("Cancelling order");
                        System.err.print(".");
                        Thread.sleep(800);
                        System.err.print(".");
                        Thread.sleep(800);
                        System.err.print(".");
                        Thread.sleep(800);
                        //FIXME Might cause issues, check here
                        Order.ordersMap.clear();
                        System.out.println("\n");
                        return;
                    case 1:
                        //EXPLAIN Validation for Number of Sandwiches
                        while (true) {
                            System.out.println("How many sandwiches did you want?");
                            try {
                                quantity = scan.nextByte();
                                break;
                            } catch (InputMismatchException e) {
                                errCounter++;
                                if (errCounter < 3) {
                                    System.err.println("My sorry,");
                                    scan.nextLine();
                                }
                                if (errCounter == 3) {
                                    System.err.println("PLEASE ENTER A VALID POSITIVE NUMBER\nNow lets try this again");
                                    scan.nextLine();
                                }
                                if (errCounter > 3) {
                                    System.err.println("ENTER A VALID\nP O S I T I V E\nN U M B E R");
                                    scan.nextLine();
                                }
                            }
                        }
                        //EXPLAIN Validation for 0 or Negative # of Sandwiches
                        if (quantity < 1) {
                            System.out.println("No sandwiches? Alright\n");
                        } else {
                            //EXPLAIN Sandwich Menu
                            Bread.sandwichMenu(quantity);
                        }
                        break;
                    //FIXME
                    case 2:
                        byte numDrinks;
                        //EXPLAIN Validation for Number Input
                        while (true) {
                            System.out.println("How many Deli-Colas did you want?");
                            try {
                                numDrinks = scan.nextByte();
                                break;
                            } catch (InputMismatchException e) {
                                System.err.println("I'm sorry,");
                                scan.nextLine();
                            }
                        }
                        //EXPLAIN Validation for 0 or Negative # of Drinks
                        if (numDrinks < 1) {
                            System.out.println("No drinks? Alright\n");
                        } else {
                            //EXPLAIN Drinks Menu
                            OtherProduct.addDrink(numDrinks);
                        }
                        break;
                    //FIXME
                    case 3:
                        break;
                    //FIXME/TODO BONUS??? Make the receipt show 5 sandwiches made, exclude duplicates, and tally price for duplicates
                    // Only show Unique entries and keep tally of quantity of items and total cost, sub-dividing all sections
                    //FIXME Print All Entries in ordersMap
                    case 4:
                        //TODO When backing out, sout Did you want something else?
                        checkout();
                        break;
                    default:
                        System.out.println("Sorry! That's not on the menu!\nIs there anything else you would like?");
                        continue;
                }
                //FIXME Unnecessary?
                if (orderInput >= 1 && orderInput <= 4) {
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("What did you say???");
                scan.nextLine();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void checkout () {
        homeSB.append("\033[36m").append("Welcome to the Checkout Menu!\n")
                .append("\033[0m")
                .append("Are you ready to Checkout?\n1) Sure am!\n0) Hold on! I forgot something!");
        System.out.println(homeSB.toString());
        homeSB.setLength(0);
        byte checkoutInput = scan.nextByte();
        switch (checkoutInput) {
            case 0:
                break;
            case 1:
                if (Order.ordersMap.isEmpty()) {
                    System.out.println("Hmmm, it doesn't look like you've ordered anything yet!\n");
                } else {
                    //FIXME if ordersMap == null then sout It doesn't look like you've ordered anything yet!
                    Order.ordersMap.forEach((key, value) ->
                            homeSB.append("\n").append("toString Order#: ").append(Integer.parseInt(key.intValue())).
                                    append(value));
                    System.out.println(homeSB + "\n");
                    homeSB.setLength(0);
                }
                break;
        }
    }

    /*public static void sandwichMenu(byte numOfSandwiches) {
        byte sandwichesMade = 0;
        while (sandwichesMade < numOfSandwiches) {
            byte sandwichInput;
            System.out.println("""
                    Select your bread
                    =================
                    1) White
                    2) Wheat
                    3) Rye
                    4) Wrap
                    """);
            sandwichInput = scan.nextByte();
            switch (sandwichInput) {
                case 1:
                    Bread.getBreadType();
                    Bread b = new Bread();
                    break;
            }
            sandwichesMade ++;
        }
    }*/
}
