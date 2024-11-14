package com.pluarlsight;

import java.util.*;

public class SignatureSandwich extends Sandwich implements Ingredient {
    //Ingredient.ingredients();
    private static StringBuilder sb = new StringBuilder();
    private static Scanner scan = new Scanner(System.in);
    private double signatureSandwichCombinedPrice;


    public static SignatureSandwich signatureSandwichMenu() {
        Sandwich sig = new SignatureSandwich();
        byte input;
        while (true) {
            sb.append("\033[31m").append("Signature Sandwich Menu!").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);


            System.out.println("""
                    Here are our Signature Sandwich Options!
                    1) BLT
                    2) Philly Cheese Steak
                    3) Deli Delight
                    4) Jill Sandwich (Coming Soon!)
                    """);

            //Preload the currentList

            System.out.println("""
                    What do you want to do?
                    1) Change Bread
                    2) Change Meat
                    3) Change Cheese
                    4) Confirm Order
                    0) Exit
                    """);

            //Send to menus
            //EXPLAIN Input Validation
            try {
                input = scan.nextByte();
            } catch (InputMismatchException e) {
                System.err.println("I'm sorry,");
                scan.nextLine();
                continue;
            }
            //END
            //FIXME Either need the Constructor to accept itself (?)
            // OR Make a RegularTopping class too UGH
            switch (input) {
                case 0:
                    return null;
                case 1:
                    if ((prem = PremiumTopping.premiumToppingsMenu()) == null) {
                        //if null then order was cancelled, so should return to this toppingsMenu
                        continue;
                    } else {
                        top = new Topping(prem);

                        if ((top = Topping.regularToppingsMenu(top)) == null) {
                            //if cancels order in regToppingsMenu() then come back here
                            continue;
                        } else {
                            //FIXME Might be ok but should find a way to have both Reg and Prem Toppings
                            // combined into 1 Topping Object
                            return top;
                        }
                    }
                    //break;
                case 2:
                    System.out.print("No Extra Toppings? Alright!\nOnto the ");
                    //System.out.println(prem);
                    //System.out.println(top);
                    if ((top = regularToppingsMenu(top)) == null) {
                        return null;
                    } else {
                        prem = null;
                        return top;
                    }
            }
        }
    }

    public static ArrayList <String> preloadedList (String sigName) {
        ArrayList<String> list = new ArrayList<>();

        if (sigName.equalsIgnoreCase("BLT")) {
            Collections.addAll(list, "8\" White Bread" , "Bacon" , "Cheddar" , "Lettuce" , "Tomato" ,
                    "Ranch" , "Toasted");
        }

        if (sigName.equalsIgnoreCase("Philly")) {
            Collections.addAll(list, "8\" White Bread" , "Steak" , "American" , "Peppers" ,
                    "Mayo" , "Toasted");
        }

        if (sigName.equalsIgnoreCase("Deli")) {
            Collections.addAll(list, "12\" Rye Bread" , "Chicken" , "Provolone" , "Onions" ,
                    "Mushrooms" , "Toasted");
        }

        return list;
    }
}

