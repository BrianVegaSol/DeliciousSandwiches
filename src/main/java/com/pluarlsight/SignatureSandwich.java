package com.pluarlsight;

import java.util.*;

public class SignatureSandwich extends Sandwich implements Ingredient {
    private static StringBuilder sb = new StringBuilder();
    private static Scanner scan = new Scanner(System.in);
    private double signatureSandwichCombinedPrice;
    private Bread bread;
    private Topping topping;

    public SignatureSandwich(Bread bread, Topping topping, boolean isToasted, double signatureSandwichCombinedPrice) {
        super(bread, topping, isToasted);
        this.signatureSandwichCombinedPrice = signatureSandwichCombinedPrice;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public static Sandwich signatureSandwichMenu() throws InterruptedException {
        Sandwich sig = null;
        PremiumTopping premiumTopping = new PremiumTopping();
        Topping topping = new Topping();
        Bread bread = new Bread();
        BreadSize breadSize = BreadSize.EIGHT_INCH;
        bread.setBreadSize(breadSize);
        bread.setBreadType(BreadType.WHITE);

        MeatSize meatSize = MeatSize.FOUR_INCH;
        MeatType meatType = MeatType.BACON;

        CheeseSize cheeseSize = CheeseSize.FOUR_INCH;
        CheeseType cheeseType = CheeseType.CHEDDAR;

        double combinedPrice = 0;

        byte input;
        while (true) {
            sb.append("\033[33m").append("Signature Sandwich Menu!")
                    .append("\n========================\n").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
            System.out.println("""
                    Here are our Signature Sandwich Options!
                    1) BLT
                    2) Philly Cheese Steak
                    3) Deli Delight
                    4) Jill Sandwich (Coming Soon!)
                    """);
            while (true) {
                try {
                    input = scan.nextByte();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("I'm sorry,");
                    scan.nextLine();
                    continue;
                }
            }

            switch (input) {
                case 1:
                    //EXPLAIN Setting up Premium Toppings
                    breadSize = BreadSize.EIGHT_INCH;
                    bread.setBreadSize(breadSize);
                    bread.setBreadType(BreadType.WHITE);

                    meatSize = MeatSize.FOUR_INCH;
                    meatType = MeatType.BACON;
                    premiumTopping.setMeatSize(meatSize);
                    premiumTopping.setMeatType(meatType);

                    cheeseSize = CheeseSize.FOUR_INCH;
                    cheeseType = CheeseType.CHEDDAR;

                    premiumTopping.setCheeseSize(cheeseSize);
                    premiumTopping.setCheeseType(cheeseType);

                    //EXPLAIN Setting up Regular Toppings
                    if (Topping.currentToppingsList != null) {
                        if (!Topping.currentToppingsList.isEmpty()) {
                            Topping.currentToppingsList.clear();
                        }
                    }
                    Topping.currentToppingsList = preloadedList("BLT");
                    if (!Topping.removedToppingsList.isEmpty()) {
                        Topping.removedToppingsList.clear();
                    }
                    Topping.removedToppingsList = preloadedRemovedList("BLT");
                    topping.setPremiumTopping(premiumTopping);

                    premiumTopping.setPremiumToppingsMenuPrice(meatSize.getMenuPrice() + cheeseSize.getMenuPrice());
                    combinedPrice = bread.getBreadMenuPrice() + premiumTopping.getPremiumToppingsMenuPrice();
                    sig = new SignatureSandwich(bread, topping, true, combinedPrice);
                    sig.setSignatureName("BLT");
                    break;
                case 2:
                    //EXPLAIN Setting up Premium Toppings
                    breadSize = BreadSize.EIGHT_INCH;
                    bread.setBreadSize(breadSize);
                    bread.setBreadType(BreadType.RYE);

                    meatSize = MeatSize.EIGHT_INCH;
                    meatType = MeatType.STEAK;
                    premiumTopping.setMeatSize(meatSize);
                    premiumTopping.setMeatType(meatType);

                    cheeseSize = CheeseSize.EIGHT_INCH;
                    cheeseType = CheeseType.AMERICAN;

                    premiumTopping.setCheeseSize(cheeseSize);
                    premiumTopping.setCheeseType(cheeseType);

                    //EXPLAIN Setting up Regular Toppings
                    if (Topping.currentToppingsList != null) {
                        if (!Topping.currentToppingsList.isEmpty()) {
                            Topping.currentToppingsList.clear();
                        }
                    }
                    Topping.currentToppingsList = preloadedList("Philly");
                    Topping.removedToppingsList.clear();
                    Topping.removedToppingsList = preloadedRemovedList("Philly");
                    topping.setPremiumTopping(premiumTopping);

                    premiumTopping.setPremiumToppingsMenuPrice(meatSize.getMenuPrice() + cheeseSize.getMenuPrice());
                    combinedPrice = bread.getBreadMenuPrice() + premiumTopping.getPremiumToppingsMenuPrice();
                    sig = new SignatureSandwich(bread, topping, true, combinedPrice);
                    sig.setSignatureName("Philly Cheese Steak");
                    break;
                case 3:
                    //EXPLAIN Setting up Premium Toppings
                    breadSize = BreadSize.FOUR_INCH;
                    bread.setBreadSize(breadSize);
                    bread.setBreadType(BreadType.WRAP);

                    meatSize = MeatSize.EIGHT_INCH;
                    meatType = MeatType.CHICKEN;
                    premiumTopping.setMeatSize(meatSize);
                    premiumTopping.setMeatType(meatType);

                    cheeseSize = CheeseSize.TWELVE_INCH;
                    cheeseType = CheeseType.PROVOLONE;

                    premiumTopping.setCheeseSize(cheeseSize);
                    premiumTopping.setCheeseType(cheeseType);

                    //EXPLAIN Setting up Regular Toppings
                    if (Topping.currentToppingsList != null) {
                        if (!Topping.currentToppingsList.isEmpty()) {
                            Topping.currentToppingsList.clear();
                        }
                    }
                    Topping.currentToppingsList = preloadedList("Deli");
                    Topping.removedToppingsList.clear();
                    Topping.removedToppingsList = preloadedRemovedList("Deli");
                    topping.setPremiumTopping(premiumTopping);

                    premiumTopping.setPremiumToppingsMenuPrice(meatSize.getMenuPrice() + cheeseSize.getMenuPrice());
                    combinedPrice = bread.getBreadMenuPrice() + premiumTopping.getPremiumToppingsMenuPrice();
                    sig = new SignatureSandwich(bread, topping, true, combinedPrice);
                    sig.setSignatureName("Deli Delight");
                    break;
                default:
                    System.out.println("Error, try again");
                    scan.nextLine();
                    continue;
            }
            break;
        }
        while (true) {
            System.out.println("\n");
            sb.append("\033[33m").append("Signature Sandwich Menu!")
                    .append("\n========================\n").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
            System.out.println("""
                    What do you want to do?
                    1) Change Bread
                    2) Change Premium Toppings
                    3) Change Regular Toppings
                    4) Confirm Order
                    0) Exit
                    """);
            //EXPLAIN Input Validation
            try {
                input = scan.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("I'm sorry,");
                scan.nextLine();
                continue;
            }
            switch (input) {
                case 0:
                    return null;
                case 1:
                    if ((bread = Bread.sizeAndTypeMenu()) != null) {
                        boolean isToasted = Bread.wantsToasted();
                        sig = new Sandwich(bread, topping, isToasted);
                    }
                    break;
                case 2:
                    PremiumTopping premTop = new PremiumTopping();
                    premTop = PremiumTopping.premiumToppingsMenu();
                    Topping top = new Topping(premTop);
                    boolean isToasted = Bread.wantsToasted();
                    if (premTop != null) {
                        combinedPrice = bread.getBreadMenuPrice() + premTop.getPremiumToppingsMenuPrice();
                    }
                    sig.setSignatureName(sig.getSignatureName());
                    sig = new SignatureSandwich(bread, top, isToasted, combinedPrice);
                    break;
                case 3:
                    String sigName = sig.getSignatureName();
                    if ((topping = Topping.regularToppingsMenu(topping, "Signature", sigName)) == null) {
                        break;
                    } else {
                        sb.setLength(0);
                        break;
                    }
                case 4:
                    System.out.println("Let's go over your order");
                    System.out.println(sig.print("Checkout", 1));
                    if (Topping.confirmOrder("Signature Sandwich") == -1) {
                        continue;
                    } else {
                        sb.setLength(0);
                        ordersMap.put(++Order.itemOrderNumber, sig);
                        return sig;
                    }
                default:
                    System.out.println("Error, try again");
                    scan.nextLine();
                    continue;
            }
        }
    }

    public static ArrayList<String> preloadedList(String sigName) {
        ArrayList<String> list = new ArrayList<>();

        if (sigName.equalsIgnoreCase("BLT")) {
            Collections.addAll(list, "Lettuce", "Tomatoes", "Ranch");
        }

        if (sigName.equalsIgnoreCase("Philly")) {
            Collections.addAll(list, "Peppers", "Mayo");
        }

        if (sigName.equalsIgnoreCase("Deli")) {
            Collections.addAll(list, "Onions", "Mushrooms");
        }
        return list;
    }


    public static ArrayList<String> preloadedRemovedList(String sigName) {
        ArrayList<String> removedList = new ArrayList<>();

        if (sigName.equalsIgnoreCase("BLT")) {
            Collections.addAll(removedList, "Peppers", "Onions", "Jalapeños",
                    "Cucumbers", "Pickles", "Guacamole", "Mushrooms", "Mayo",
                    "Mustard", "Ketchup", "Thousand Islands", "Vinaigrette",
                    "au jus", "Sauce");
        }

        if (sigName.equalsIgnoreCase("Philly")) {
            Collections.addAll(removedList, "Lettuce", "Onions", "Tomatoes", "Jalapeños",
                    "Cucumbers", "Pickles", "Guacamole", "Mushrooms",
                    "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette",
                    "au jus", "Sauce");
        }

        if (sigName.equalsIgnoreCase("Deli")) {
            Collections.addAll(removedList, "Lettuce", "Peppers", "Tomatoes", "Jalapeños",
                    "Cucumbers", "Pickles", "Guacamole", "Mayo",
                    "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette",
                    "au jus", "Sauce");
        }
        return removedList;
    }
}

