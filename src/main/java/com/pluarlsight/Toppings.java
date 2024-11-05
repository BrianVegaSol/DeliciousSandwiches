package com.pluarlsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Toppings {
    private int numOfToppings;
    private MeatType meatType;
    private MeatSize meatSize;
    private ExtraMeatSize extraMeatSize;
    private CheeseType cheeseType;
    private CheeseSize cheeseSize;
    private ExtraCheeseSize extraCheeseSize;
    private static final String[] allIngredients = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalepeños",
            "Cucumbers", "Pickles", "Guacamole", "Mushrooms", "Mayo",
            "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette",
            "au jus", "Sauce"};
    private static final String [] removedToppings = new String[17]; // TODO Use StringBuilder
    private static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    //FIXME Not sure how to handle the Regular toppings since they're already included???
    // Should I ask if the user wants to remove certain toppings instead of asking to add???
    // Hashmap prefilled with RegToppings, have user remove those toppings, then add remaining toppings to???
    // Have a method that returns the prefilled HashMap in case user makes a mistake (clear existing list before doing so?)

    //FIXME Use an Arraylist, remove from list, then add what remains to the Topping Object?
    // make it so if (instance of valueOf Object) isEmpty   OR

    //FIXME Use a HashMap, normal for loop over all indices (the max should always be the same)
    // for (int i = 0; i < 10; i++) {
    // if i == null/isEmpty then {print/return No pickles}
    // in StringBuilder/sandwichBuilder have is display all ingredients and \n No pickles etc
    // if (String.contains (maaaybe use split/substring))
    // loop over split[], if i.contains(removedItems) remove & print No removedItem


    //FIXME Should this be in the Sandwich toString()???
    //TODO Leaning towards Arraylist<String> since I'll need it to print the Included Ingredients UNLESS for
    // HashMap have a condition if (entry/index != Empty) then print
    // HashMap seems to be the winner to avoid contains/subString
    // Probably gonna need 2 Collections, the IncludedMap and RemovedMap OR compare resetMap and RemovedMap

    //TODO F I N A L Use 2 Arraylists, one with allToppings, another with removedToppings
    // Add 2 Arraylists to Toppings???
    // Add Bread and Toppings to Sandwich
    // Make toString in Sandwich
    // Add Sandwich to ordersMap

    //TODO Now the plan is to use a String [] and StringBuilder

    /*FIXME F I N A L sout Sandwich Order # 1
       Sandwich Details
       Bread
       Included Ingredients
       Removed Ingredients, use StringBuilder for the No pickles, etc ! ! !
     */


    //FIXME Flow Collection removes toppings -> Add to sandwichBuilder() then Sandwich/Bread Object, add the Obj to map
    // Sandwich class should accept Bread and Toppings as its Constructor, potentially extend???

    //FIXME LATER Omit price in toStrings() and keep a priceTotalForType to display at the bottoms
    // need to keep the individual prices too tho!

    //private RegularToppings regTops;
    //private Sauces sauce;
    //private Sides side;

    Toppings top;

    public Toppings() {
        if (this instanceof Toppings) {


        }
    }

    //EXPLAIN Meat Enums ->
    //FIXME Probably gonna wanna add the type for HashMap here
    private enum MeatType {
        STEAK(1, "Steak", false),
        HAM(2, "Ham", false),
        SALAMI(3, "Salami", false),
        ROAST_BEEF(4, "Roast Beef", false),
        CHICKEN(5, "Chicken", false),
        BACON(6, "Bacon", false);

        private int menuNum;
        private String menuName;
        private boolean wantsExtraMeat;

        MeatType(int menuNum, String menuName, boolean wantsExtraMeat) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

    }

    private enum MeatSize {
        FOUR_INCH(1, "4\"", 1.00),
        EIGHT_INCH(2, "8\"", 2.00),
        TWELVE_INCH(3, "12\"", 3.00);

        private int menuNum;
        private String sizeName;
        private double menuPrice;
        private boolean wantsExtra;

        MeatSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }

    private enum ExtraMeatSize {
        FOUR_INCH(1, "4\"", 0.50),
        EIGHT_INCH(2, "8\"", 1.00),
        TWELVE_INCH(3, "12\"", 1.50);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        ExtraMeatSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }

    //END <-
    //EXPLAIN Cheese enums ->
    private enum CheeseType {
        AMERICAN(1, "American"), PROVOLONE(2, "Provolone"),
        CHEDDAR(3, "Cheddar"), SWISS(4, "Swiss");

        private int menuNum;
        private String menuName;

        CheeseType(int menuNum, String menuName) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

    }

    private enum CheeseSize {
        FOUR_INCH(1, "4\"", 0.75),
        EIGHT_INCH(2, "8\"", 1.50),
        TWELVE_INCH(3, "12\"", 2.25);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        CheeseSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }

    private enum ExtraCheeseSize {
        FOUR_INCH(1, "4\"", 0.30),
        EIGHT_INCH(2, "8\"", 0.60),
        TWELVE_INCH(3, "12\"", 0.90);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        ExtraCheeseSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }
    //END <-


    /*
    Toppings: - the user should be able to add extras of each topping
    § Meat:
    § Cheese:
    § Other toppings:
    § Select sauces:
    o Would you like the sandwich toasted?
    */

    public static void toppingsMenu() {
        //vars
        sb.append("\033[31m").append("Welcome to to Toppings Menu!").append("\033[0m");
        System.out.println(sb.toString());
        sb.setLength(0);
        //FIXME I H A V E to use an Arraylist here, probably even an interactiveToppingsOptions() where
        // have A N O T H E R method with public static ArrayList<String> prefilledToppingsList() returns filled List
        // User selects what they want to remove, while (true), have a switch (input) case # remove that index
        // continue loop of using the ArrList remainingToppings and use toString() to print indices
        // A current ArrayList remainingToppings and a String [] removed Toppings
        // return when done removing

        //FIXME OR
        // Keep it simple, if String [] regToppings isEmpty, {remove from [] and add to String [] removedToppings
        System.out.println("""
                Which toppings do you want to remove?
                1)
                2)
                3)
                4)
                5)
                0) None! Keep all the toppings!""");
        while (true) {
            //sb
            byte input = scan.nextByte();
            switch (input) {
                case 0:

                    break;
                case 1:

            }
        }
    }
    // END Remove Toppings

    //EXPLAIN Separate extraToppingsMenu()???
    public static void extraToppings() {
        //vars
        Scanner scan = new Scanner(System.in);
        sb.append("\033[31m").append("Welcome to to Extra Toppings Menu!").append("\033[0m");
        System.out.println(sb.toString());
        sb.setLength(0);
        System.out.println("""
                Would you like Extra Meat?
                1) Yes
                0) No
                """);

        while (true) {
            //sb
            byte input = scan.nextByte();
            switch (input) {
                case 0:

                    break;
                case 1:

            }
        }
    }
    public static ArrayList<String> dynamicToppingsList() {
        ArrayList <String> allRegularToppingsList = new ArrayList<>();
        allRegularToppingsList.addAll(Arrays.asList(allIngredients));
        return allRegularToppingsList;
    }

    public static void printDynamicList(ArrayList<String> lists) {
        System.out.println("List Size: " + lists.size());
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(sb.append(i + 4).append(") Remove ").append(lists.get(i))
                    .toString());
            sb.setLength(0);
        }
    }


    //FIXME 0) return, once back at Topping menu skip adding to Sandwich
    // Should probably add to Sandwich here to avoid ifs in Toppings and makes sense to be here OR extraToppingsMenu()
    public static int remainingRegularToppingsMenu() {
        ArrayList <String> currentToppingsList = dynamicToppingsList();
        //byte viableInputs = (byte) (currentToppingsList.size() - 17);
        boolean runRemainingRegularToppingsMenu = true;
        byte input = -1;
        while (runRemainingRegularToppingsMenu) {
            sb.append("\033[35m").append("Regular Toppings Menu").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
            //TODO Color coat these 4 options so they p o p :D AND make the remove options red
            System.out.print("""
                    All these toppings are included in your Sandwich Order, free of charge!
                    Are there any toppings you'd like to remove from your order?
                    0) Return to Order Menu
                    1) Undo last change
                    2) Restart Topping Removal
                    3) Confirm Order
                    """);
            printDynamicList(currentToppingsList);
            try {
                input = scan.nextByte();
            } catch (InputMismatchException e) {
                System.err.print("What are the options you ask? Let me show you the ");
                scan.nextLine();
                continue;
            }
            /*for (String allIngredient : allIngredients) {
                if (allIngredient != null) {

                }
            }*/
            if (input >= 4 && input <= 20) {
                removedToppings[input] = currentToppingsList.get(input);
                currentToppingsList.remove(input - 4);
            } else {
                //FIXME AHHHH I JUST REALIIIIZEEDDD
                // Since the list keeps getting smaller, that makes selecting the menu and error handling harder
                // Either, I use numbers still and do something like var dynamicInput =
                // size of dynamicList - current list?
                // will also need to make anooother list (Probably UGH) unless something like this.list - other this???
                //TODO Side Project??? Moreso just for practice to use String()s
                // OR I use Strings as inputs so if input.toUppercase.equals LETTUCE
                // then search ArrayList.contains OR use streams to filter

                //FIXME FINAL will proceed with numbers for now, worst case, have to make another ArrList
                switch (input) {
                    case 0:
                        System.out.println("Change your mind? No worries");
                        //FIXME Play around with this value, maybe -1 or 18?
                        return -1;
                    case 1:
                        //undo
                        break;
                    case 2:
                        System.out.println("Alright, lets start over!");
                        currentToppingsList = dynamicToppingsList();
                        System.out.println(Arrays.toString(removedToppings));
                        Arrays.fill(removedToppings,null);
                        System.out.println(Arrays.toString(removedToppings));
                        //ArrList.clear()
                        //Clear removedToppings []
                        break;
                    case 3:
                        System.out.println("Let's see what I have here\n");
                        //sout what's included on top and removed on the bottom Hold the pickles, etc
                        System.out.println("Is this correct>\n");
                        //switch if no break;
                        runRemainingRegularToppingsMenu = false;
                        break;
                    default:
                        System.err.print("Great! That's not a topping we offer, so you're good!\nNow please have a look at the ");
                        break;

                }
            }
        }


        //TODO Might just add to Sandwich Object here and make method void as well as take Bread and Extra Toppings
        // as parameters to this method? OR return Toppings Object so in ?
        //Sandwich sandwich = new Sandwich

        //TODO SIDE PROJECT ADD RNG TO THE RESPONSES
        //TODO When an item is removed, sout No pickles, got it! (custom messages for each?)
        // check how many items are missing, then create the size of the removedToppings []
        // check if removedToppings [] isEmpty, then sout No Toppings Removed!


        return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "";
    }

}

