package com.pluarlsight;

import java.util.*;

public class Topping implements Ingredient{
    private int numOfToppings;
    /*private static final String[] allIngredients = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños",
            "Cucumbers", "Pickles", "Guacamole", "Mushrooms", "Mayo",
            "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette",
            "au jus", "Sauce"};*/
    //private static final String [] removedToppings = new String[17]; // TODO Use StringBuilder
    private static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    private PremiumTopping premiumTopping;
    double premToppingsTotalPrice;
    static ArrayList<String> removedToppingsList = new ArrayList<>();
    static ArrayList<String> currentToppingsList;
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

    Topping top;

    /*public Topping(PremiumTopping premiumTopping, ArrayList<String> removedToppingsList,
                   ArrayList<String> currentToppingsList, double premToppingsTotalPrice) {
        *//*if (this instanceof Topping) {
        }*//*
        this.premiumTopping = premiumTopping;
    }*/
    //FIXME Should use this one when I make the totalPrice
    public Topping(PremiumTopping premiumTopping, double premToppingsTotalPrice) {
        this.premiumTopping = premiumTopping;
        this.premToppingsTotalPrice = premToppingsTotalPrice;
    }

    //FIXME DELETE THIS IS A PLACEHOLDER
    public Topping(PremiumTopping premiumTopping) {
        this.premiumTopping = premiumTopping;
    }

    public Topping(PremiumTopping premiumTopping, Topping top) {
        this.premiumTopping = premiumTopping;
        this.top = top;
    }

    public Topping() {
    }


    public double getPremToppingsTotalPrice() {
        if (premiumTopping == null) {
            return 0.0;
        } else {
            return premiumTopping.getPremiumToppingsMenuPrice();
        }
    }

    public void setPremiumTopping(PremiumTopping premiumTopping) {
        this.premiumTopping = premiumTopping;
    }
    /*
    Toppings: - the user should be able to add extras of each topping
    § Meat:
    § Cheese:
    § Other toppings:
    § Select sauces:
    o Would you like the sandwich toasted?
    */

    public static Topping toppingsMenu() throws InterruptedException {
        //vars
        Topping top = new Topping();
        PremiumTopping prem = new PremiumTopping();
        byte input;
        while (true) {
            sb.append("\033[31m").append("Toppings Menu!").append("\033[0m");
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
                    Did you want to add any Extra Toppings?
                    1) Yes
                    2) No
                    0) Exit
                    """);
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
                    //FIXME Causing issues since the orders can potentially be semi-null EITHER
                    // Make premTop Object null before exiting & before returning from confirmOrder()
                    if ((prem = PremiumTopping.premiumToppingsMenu()) == null) {
                        //if null then order was cancelled, so should return to this toppingsMenu
                        continue;
                    } else {
                        top = new Topping(prem);

                        if ((top = Topping.regularToppingsMenu(top, "Normal")) == null) {
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
                    if ((top = regularToppingsMenu(top, "Normal")) == null) {
                        return null;
                    } else {
                        prem = null;
                        return top;
                    }
            }
        }
    }
    // END Remove Toppings

    //FIXME 0) return, once back at Topping menu skip adding to Sandwich
    // Should probably add to Sandwich here to avoid ifs in Toppings and makes sense to be here OR extraToppingsMenu()
    public static Topping regularToppingsMenu(Topping topping , String function) throws InterruptedException {
        currentToppingsList = Ingredient.ingredients();
        //System.out.println("TEST PREM TOP:\n" + topping);
        byte lastChangeIndex = -1;
        //byte viableInputs = (byte) (currentToppingsList.size() - 17);
        //boolean runRemainingRegularToppingsMenu = true;
        byte input = -1;
        while (true) {
            staticList(currentToppingsList);
            printDynamicList(currentToppingsList);
            //TODO BONUS Add a search for topping to add back from the removedToppingsList
            //currentToppingsList.stream().findAny().equals(inputTopping);
            sb.append("\033[35m")
                    .append("======================================================")
                    .append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);

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
            //EXPLAIN Removal Options ->
            if (input >= 4 && input <= 20) {
                lastChangeIndex = (byte) (input - 4);
                removeToppingsOptions(currentToppingsList, lastChangeIndex);
                //END <-
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
                        sb.append("\033[31m").append("Change your mind? No worries\nSandwich Order Cancelled\n")
                                .append("\033[0m");
                        System.out.println(sb.toString());
                        sb.setLength(0);
                        removedToppingsList.clear();
                        //FIXME Play around with this value, maybe -1 or 18?
                        return null;
                    case 1:
                        //FIXME Check if null/empty?
                        if (removedToppingsList.isEmpty()) {
                            System.out.println("Nothing to undo!");
                        } else {
                            undo(currentToppingsList);
                        }
                        break;
                    case 2:
                        System.out.println("Alright, lets start over!");
                        currentToppingsList = Ingredient.ingredients();
                        removedToppingsList.clear();
                        //System.out.println("Removed List: \n" + removedToppingsList.toString());
                        //EXPLAIN String [] Legacy code
                        //System.out.println(Arrays.toString(removedToppings));
                        //Arrays.fill(removedToppings,null);
                        //System.out.println(Arrays.toString(removedToppings));
                        //ArrList.clear()
                        //Clear removedToppings []
                        //END
                        break;
                    case 3:
                        System.out.print("Let's go over your order\n");
                        System.out.println(topping.print("Print"));
                        sb.setLength(0);
                        sb.setLength(0);
                        //EXPLAIN Legacy
                        /*sb.append("\033[32m").append("Included\n========").append("\033[0m");
                        System.out.println(sb.toString());
                        sb.setLength(0);
                        for (int i = 0; i < currentToppingsList.size(); i++) {
                            System.out.print(currentToppingsList.get(i));
                            if (i < currentToppingsList.size() - 1) {
                                System.out.print(", ");
                                if (i == 8 && removedToppingsList.isEmpty()) {
                                    System.out.println();
                                }
                            }
                        }
                        //Playing around with stream()
                        *//*ArrayList<String> finalCurrentToppingsList = currentToppingsList;
                        List<String> printList = currentToppingsList.forEach((i) -> {
                                System.out.print(finalCurrentToppingsList.get(Integer.parseInt(i)));
                        if (i < (String.valueOf(finalCurrentToppingsList.size()) - 1)) {
                            System.out.print(", ");
                        }}
                        ).collect(Collectors.toList());*//*
                        //FIXME Add Bread details here
                        //EXPLAIN Printing Full Sandwich order ->
                        if (removedToppingsList.isEmpty()) {
                            System.out.println();
                        } else {
                            sb.append("\033[31m").append("\n\nRemoved\n=======").append("\033[0m");
                            System.out.println(sb.toString());
                            sb.setLength(0);
                            for (int i = 0; i < removedToppingsList.size(); i++) {
                                System.out.print(removedToppingsList.get(i));
                                if (i < removedToppingsList.size() - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println("\n\n");
                        }*/
                        //END of Legacy Code
                        //sout what's included on top and removed on the bottom Hold the pickles, etc
                        //END of Sandwich Order <-
                        //EXPLAIN Confirm Sandwich order ->
                        //Topping topping = new Topping();
                        if (confirmOrder("Toppings") == -1) {
                            continue;
                        } else {
                            sb.setLength(0);
                            Bread.wantsToasted();

                            //FIXME May need to add topping to orderMap??? then return
                            return topping;
                        }
                        //END <-
                        //runRemainingRegularToppingsMenu = false;
                        //break;
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

        //return 1;
    }

    public static int confirmOrder(String menuType) throws InterruptedException {
        while (true) {
            sb.setLength(0);
            sb.append("\033[36m").append("Would you like to Confirm your ").append(menuType).append(" Order?\n\n")
                    .append("\033[0m");
            sb.append("\033[32m").append("1) Yes\n").append("\033[0m");
            sb.append("\033[31m").append("0) No, let me change some things\n").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
            byte input;
            try {
                input = scan.nextByte();
            } catch (InputMismatchException e) {
                System.err.println("Im sorry,");
                scan.nextLine();
                continue;
            }
            //switch if no break;
            switch (input) {
                case 0:
                    System.out.println("Alright, lets go back");
                    return -1;
                //return null;
                case 1:
                    sb.append("\033[32m").append("Processing order").append("\033[0m");
                    System.out.print(sb.toString());
                    sb.setLength(0);
                    Thread.sleep(600);
                    sb.append("\033[32m").append(" .").append("\033[0m");
                    System.out.print(sb.toString());
                    sb.setLength(0);
                    Thread.sleep(600);
                    sb.append("\033[32m").append(" .").append("\033[0m");
                    System.out.print(sb.toString());
                    sb.setLength(0);
                    Thread.sleep(600);
                    sb.append("\033[32m").append(" . \n").append("\033[0m");
                    System.out.print(sb.toString());
                    sb.setLength(0);
                    Thread.sleep(600);
                    //Topping top = new Topping();
                    return 1;
                //return new Topping();
                default:
                    System.err.println("Im sorry,");
                    scan.nextLine();
                    continue;
            }
        }
    }

    public static void staticList(ArrayList<String> currentToppingsList) {
        sb.append("\033[35m")
                .append("Regular Toppings Menu\n======================================================")
                .append("\033[0m");
        System.out.println(sb.toString());
        sb.setLength(0);
        //TODO Color coat these 4 options so they p o p :D AND make the remove options red
        if (!currentToppingsList.isEmpty()) {
            sb.append("All these toppings are included in your Sandwich Order, ")
                    .append("\033[32m").append("\nfree of charge!\n").append("\033[0m")
                    .append("Any toppings you'd like to ")
                    .append("\033[31m").append("remove ").append("\033[0m")
                    .append("from your order?");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        sb.append("\033[31m").append("0) Return to Order Menu\n").append("\033[0m")
                .append("\033[33m").append("1) Undo last change\n").append("\033[0m")
                .append("\033[33m").append("2) Restart\n").append("\033[0m")
                .append("\033[32m").append("3) Confirm Order").append("\033[0m");
        System.out.println(sb.toString());
        sb.setLength(0);
        if (currentToppingsList.isEmpty()) {
            sb.append("\033[31m").append("(Who eats a sandwich without any toppings...)").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    /*public static ArrayList<String> dynamicToppingsList() {
        ArrayList<String> allRegularToppingsList = new ArrayList<>();
        allRegularToppingsList.addAll(Arrays.asList(allIngredients));
        return allRegularToppingsList;
    }*/

    public static void printDynamicList(ArrayList<String> lists) {
        //System.out.println("List Size: " + lists.size());
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(sb.append("\033[31m").append(i + 4).append(") Remove ").append(lists.get(i))
                    .append("\033[0m")
                    .toString());
            sb.setLength(0);
        }
    }

    public static void undo(ArrayList<String> list) {
        //System.out.println("Full []: " + Arrays.toString(allIngredients));
        //System.out.println("Pre add: " + list);
        list.add(removedToppingsList.getLast());
        removedToppingsList.remove(removedToppingsList.getLast());
        sb.append("\033[32m").append("Added ").append("\033[0m")
                .append("\033[34m").append(list.getLast()).append("\033[0m")
                .append(" back into your sandwich!");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public static void removeToppingsOptions(ArrayList<String> currentToppingsList, byte lastChangeIndex) {
        //FIXME Was it not working because I didn't (input - 4) for list here? >.>
        // yes but wrong tool for the job :(
        //removedToppings[input - 4] = currentToppingsList.get(input - 4);
        try {
            removedToppingsList.add(currentToppingsList.get(lastChangeIndex));
            currentToppingsList.remove(lastChangeIndex);
        } catch (IndexOutOfBoundsException e) {
            if (currentToppingsList.isEmpty()) {
                System.err.println("There's nothing left to take off! (Except maybe the buns but...)\n\n");
                return;
            } else {
                System.err.println("Great! That's not a topping we offer, so you're good!\nHave another look at the ");
            }
        }
        //DONE make this .get so it doesnt print the whole list for final product
        if (!currentToppingsList.isEmpty()) {
            sb.append("\033[31m").append("Removed ").append("\033[0m");
            sb.append("\033[34m").append(removedToppingsList.getLast()).append("\033[0m")
                    .append(" from your sandwich!");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
    //FIXME N A I V E implementation, would've needed an Arraylist instead of a basic []
    // then use the lastIndexOf(or whatever gives the newest entry) AND compare it to the original somehow???
    // perhaps similar to how undo() is currently done
    // OR search dynamicList() and compare it to current

    //FIXME Would've needed a 2nd ArrList, have it keep order that things were removed in
    // Next lookup the index that its in from the List/[], save that to an int var
    // ... would've needed Categories for all the types of regToppings
    // maybe if 2nd ArrList compared the String value to [], NOPE, since the currentList does NOT preserve order
    // like a HashMap, would've needed a mix of a HashMap and an ArrayList cx

    //FIXME FINAL just use a 2nd ArrList and insert it back into the currentList, the order compared to the original
    // will be lost but at least A L L  of the items will be present! (feel like a HashMap could've helped somehow)
    // OR Use HashMap, then in display() forEach{ if (value != null) then print
    // Must use an ArrList also, compare String to [], grab index, save to int var, and use int + String! ! !
   /* public static void undo (byte lastChangeIndex, ArrayList<String> list) {
        System.out.println("Full []: " + Arrays.toString(allIngredients));
        System.out.println("Pre add from Removed []: " + Arrays.toString(removedToppings));
        //FIXME compare/contains with all [], grab index, add to ArrList to maintain order
        // nope, just use the 2nd ArrList and do this
        list.add((lastChangeIndex - 4), removedToppings[lastChangeIndex - 4]);
        System.out.println("Added " + list.get(lastChangeIndex) + " back into your sandwich!"); //WRONG

        System.out.println("After added from Removed []: " + Arrays.toString(removedToppings));
    }*/
    //@Override
    public String print(String function) {
        sb.setLength(0);
        if (premiumTopping != null) {
            if (function.equalsIgnoreCase("Receipt")) {
                sb.append(premiumTopping.print(function));
            } else {
                sb.append(premiumTopping.print("Print"));
            }
        }/*else {
            //sb.append("\033[31m").append("No Premium Toppings Added\n=========================").append("\033[0m");
        }*/

        if (removedToppingsList.isEmpty()) {
            //assert premiumTopping != null;//Auto generated by compiler ???
            //premiumTopping.print();
            if (function.equalsIgnoreCase("Receipt")) {
                sb.append("Regular Topping Details")
                        .append("\n=======================")
                        .append("\nIncluded\n");
            } else {
                sb.append("\033[31m").append("Regular Topping Details")
                        .append("\n=======================").append("\033[0m\n\n")
                        .append("\033[32m").append("Included\n").append("\033[0m");
            }
            for (int i = 0; i < Topping.currentToppingsList.size(); i++) {
                sb.append(currentToppingsList.get(i));
                //FIXME Should toString then setLength
                if (i < currentToppingsList.size() - 1) {
                    sb.append(", ");
                    if (i == 8) {
                        sb.append("\n");
                    }
                }
            }
            if (function.equalsIgnoreCase("Receipt")) {
                sb.append("\n\nRemoved\n");
            } else {
                sb.append("\033[31m").append("\n\nRemoved\n").append("\033[0m");
            }
            return sb.toString() + "Nothing removed\n";
        }

        //EXPLAIN Under normal circumstances
        if (function.equalsIgnoreCase("Receipt")) {
            sb.append("Regular Topping Details")
                    .append("\n=======================")
                    .append("\nIncluded\n");
        } else {
            sb.append("\033[31m").append("Regular Topping Details")
                    .append("\n=======================").append("\033[0m\n")
                    .append("\033[32m").append("Included\n").append("\033[0m");
        }
        //System.out.println(sb.toString());
        //sb.setLength(0);
        for (int i = 0; i < Topping.currentToppingsList.size(); i++) {
            sb.append(currentToppingsList.get(i));
            //FIXME Should toString then setLength
            if (i < currentToppingsList.size() - 1) {
                sb.append(", ");
                if (i == 8) {
                    sb.append("\n");
                }
            }
        }

        if (function.equalsIgnoreCase("Receipt")) {
            sb.append("\n\nRemoved\n");
        } else {
            sb.append("\033[31m").append("\n\nRemoved\n").append("\033[0m");
        }
        //System.out.println(sb.toString());
        //sb.setLength(0);
        for (int i = 0; i < removedToppingsList.size(); i++) {
            sb.append(removedToppingsList.get(i));
            //System.out.print(removedToppingsList.get(i));
            if (i < removedToppingsList.size() - 1) {
                //System.out.print(", ");
                sb.append(", ");
            }
        }
        sb.append("\n");
        //System.out.println("\n\n");
        //System.out.print(sb.toString());
        //sb.setLength(0);
        return sb.toString();
    }

    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        return "";
        //END





        /*//TODO have removed and the updated currentList in here and see if they update after confirming the order
        // May need to make a method/ make currentList static at the top of the class to use
        // as just a reference, not instantiating it
        if (removedToppingsList.isEmpty()) {
            return sb.toString() + "\nNothing removed";
        }
        //TODO Reuse the Included and Removed sb, make it a method and replace this filler test text
        return sb.toString() + //TODO Make all of this part of the sb //FIXME TRACK DOWN WHERE THIS PRINTS AND
                // FIXME SB.SETLENGTH(0)
                "Removed: " + removedToppingsList.getFirst();
        if (this instanceof PremiumTopping) {

        }*/

    }

}

