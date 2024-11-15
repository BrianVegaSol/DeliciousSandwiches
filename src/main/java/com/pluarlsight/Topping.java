package com.pluarlsight;

import java.util.*;

public class Topping implements Ingredient {
    private static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    private PremiumTopping premiumTopping;
    double premToppingsTotalPrice;
    static ArrayList<String> removedToppingsList = new ArrayList<>();
    static ArrayList<String> currentToppingsList;

    Topping top;

    public Topping(PremiumTopping premiumTopping, double premToppingsTotalPrice) {
        this.premiumTopping = premiumTopping;
        this.premToppingsTotalPrice = premToppingsTotalPrice;
    }

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

    public static Topping toppingsMenu() throws InterruptedException {
        Topping top = new Topping();
        PremiumTopping prem = new PremiumTopping();
        byte input;
        while (true) {
            sb.append("\033[31m").append("Toppings Menu!").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
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
            switch (input) {
                case 0:
                    return null;
                case 1:
                    if ((prem = PremiumTopping.premiumToppingsMenu()) == null) {
                        continue;
                    } else {
                        top = new Topping(prem);

                        if ((top = Topping.regularToppingsMenu(top, "Normal", "Custom")) == null) {
                            continue;
                        } else {
                            return top;
                        }
                    }
                case 2:
                    System.out.print("No Extra Toppings? Alright!\nOnto the ");
                    if ((top = regularToppingsMenu(top, "Normal", "Custom")) == null) {
                        return null;
                    } else {
                        prem = null;
                        return top;
                    }
            }
        }
    }

    public static Topping regularToppingsMenu(Topping topping, String function, String signatureName) throws InterruptedException {
        if (function.equalsIgnoreCase("Signature")) {
            currentToppingsList = SignatureSandwich.preloadedList(signatureName);
        } else {
            currentToppingsList = Ingredient.ingredients();
        }
        byte lastChangeIndex = -1;
        byte input = -1;
        while (true) {
            staticList(currentToppingsList);
            printDynamicList(currentToppingsList);
            if (function.equalsIgnoreCase("Signature")) {
                printDynamicAddList(removedToppingsList);
            }
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

            if (input >= 4 && input <= 20) {
                if (function.equalsIgnoreCase("Signature")) {
                    if (input >= 4 && input < (currentToppingsList.size() + 4)) {
                        lastChangeIndex = (byte) (input - 4);
                        removeToppingsOptions(currentToppingsList, lastChangeIndex, "Signature");
                    } else if (input >= (currentToppingsList.size() + 4) && input <= 20) {
                        lastChangeIndex = (byte) (input - 4 - currentToppingsList.size());
                        addToppingsOptions(removedToppingsList, lastChangeIndex);
                    }

                } else {
                    //EXPLAIN Removal Options ->
                    if (input >= 4 && input <= 20) {
                        lastChangeIndex = (byte) (input - 4);
                        removeToppingsOptions(currentToppingsList, lastChangeIndex, "Normal");
                        //END <-
                    }
                }

            } else {
                switch (input) {
                    case 0:
                        sb.append("\033[31m").append("Change your mind? No worries\nSandwich Order Cancelled\n")
                                .append("\033[0m");
                        System.out.println(sb.toString());
                        sb.setLength(0);
                        removedToppingsList.clear();
                        if (function.equalsIgnoreCase("Signature")) {
                            removedToppingsList = SignatureSandwich.preloadedRemovedList(signatureName);
                        }
                        return null;
                    case 1:
                        if (removedToppingsList.isEmpty()) {
                            System.out.println("Nothing to undo!");
                        } else {
                            undo(currentToppingsList);
                        }
                        break;
                    case 2:
                        System.out.println("Alright, lets start over!");
                        if (function.equalsIgnoreCase("Signature")) {
                            currentToppingsList = SignatureSandwich.preloadedList(signatureName);
                            removedToppingsList = SignatureSandwich.preloadedRemovedList(signatureName);
                        } else {
                            currentToppingsList = Ingredient.ingredients();
                            removedToppingsList.clear();
                        }
                        break;
                    case 3:
                        System.out.print("Let's go over your order\n");
                        System.out.println(topping.print("Print"));
                        sb.setLength(0);
                        sb.setLength(0);
                        if (confirmOrder("Toppings") == -1) {
                            continue;
                        } else {
                            sb.setLength(0);
                            Bread.wantsToasted();
                            return topping;
                        }
                    default:
                        System.err.print("Great! That's not a topping we offer, so you're good!\nNow please have a look at the ");
                        break;
                }
            }
        }
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
            switch (input) {
                case 0:
                    System.out.println("Alright, lets go back");
                    return -1;
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
                    return 1;
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

    public static void printDynamicAddList(ArrayList<String> lists) {
        //System.out.println("List Size: " + lists.size());
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(sb.append("\033[32m").append(i + 4 + currentToppingsList.size())
                    .append(") Add ").append(lists.get(i))
                    .append("\033[0m")
                    .toString());
            sb.setLength(0);
        }
    }

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
        list.add(removedToppingsList.getLast());
        removedToppingsList.remove(removedToppingsList.getLast());
        sb.append("\033[32m").append("Added ").append("\033[0m")
                .append("\033[34m").append(list.getLast()).append("\033[0m")
                .append(" back into your sandwich!");
        System.out.println(sb.toString());
        sb.setLength(0);
    }

    public static void removeToppingsOptions(ArrayList<String> currentToppingsList, byte lastChangeIndex, String function) {
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
        if (!currentToppingsList.isEmpty()) {
            sb.append("\033[31m").append("Removed ").append("\033[0m");
            sb.append("\033[34m").append(removedToppingsList.getLast()).append("\033[0m")
                    .append(" from your sandwich!");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    //EXPLAIN Only used in Signature Sandwich
    public static void addToppingsOptions(ArrayList<String> removedList, byte lastChangeIndex) {
        try {
            currentToppingsList.add(removedList.get(lastChangeIndex));
            removedList.remove(lastChangeIndex);
        } catch (IndexOutOfBoundsException e) {
            if (removedList.isEmpty()) {
                System.err.println("There's nothing left to add!\n\n");
                return;
            } else {
                System.err.println("Sorry! That's not a topping we offer!\nHave another look at the ");
            }
        }
        if (!removedList.isEmpty()) {
            sb.append("\033[32m").append("Added ").append("\033[0m");
            sb.append("\033[34m").append(currentToppingsList.getLast()).append("\033[0m")
                    .append(" to your sandwich!");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    public String print(String function) {
        sb.setLength(0);
        if (premiumTopping != null) {
            if (function.equalsIgnoreCase("Receipt")) {
                sb.append(premiumTopping.print(function));
            } else {
                sb.append(premiumTopping.print("Print"));
            }
        }

        if (removedToppingsList.isEmpty()) {
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
        for (int i = 0; i < Topping.currentToppingsList.size(); i++) {
            sb.append(currentToppingsList.get(i));
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
        for (int i = 0; i < removedToppingsList.size(); i++) {
            sb.append(removedToppingsList.get(i));
            if (i < removedToppingsList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "";
    }
}

