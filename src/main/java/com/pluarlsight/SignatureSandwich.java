package com.pluarlsight;

import java.util.*;

public class SignatureSandwich extends Sandwich implements Ingredient {
    //Ingredient.ingredients();
    private static StringBuilder sb = new StringBuilder();
    private static Scanner scan = new Scanner(System.in);
    private double signatureSandwichCombinedPrice;
    private Bread bread;
    private Topping topping;

    public SignatureSandwich(Bread bread, Topping topping, boolean isToasted, double signatureSandwichCombinedPrice) {
        super(bread, topping, isToasted);
        //this.bread = bread;
        this.signatureSandwichCombinedPrice = signatureSandwichCombinedPrice;
        //this.topping = topping;
    }

    public SignatureSandwich() {
        super();
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public static Sandwich signatureSandwichMenu() throws InterruptedException {
        Sandwich sig = new SignatureSandwich();
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
                    //preloadedList("BLT");
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

                    //Regular toppings
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

                    combinedPrice = bread.getBreadMenuPrice() + topping.getPremToppingsTotalPrice();
                    sig.setSignatureName("BLT");
                    sig = new SignatureSandwich(bread, topping, true, combinedPrice);
                    break;
                case 2:
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

                    //Regular toppings
                    if (Topping.currentToppingsList != null) {
                        if (!Topping.currentToppingsList.isEmpty()) {
                            Topping.currentToppingsList.clear();
                        }
                    }
                    Topping.currentToppingsList = preloadedList("Philly");
                    Topping.removedToppingsList.clear();
                    Topping.removedToppingsList = preloadedRemovedList("Philly");
                    topping.setPremiumTopping(premiumTopping);

                    combinedPrice = bread.getBreadMenuPrice() + topping.getPremToppingsTotalPrice();
                    sig.setSignatureName("Philly Cheese Steak");
                    sig = new SignatureSandwich(bread, topping, true, combinedPrice);
                    break;
                case 3:
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

                    //Regular toppings
                    if (Topping.currentToppingsList != null) {
                        if (!Topping.currentToppingsList.isEmpty()) {
                            Topping.currentToppingsList.clear();
                        }
                    }
                    Topping.currentToppingsList = preloadedList("Deli");
                    Topping.removedToppingsList.clear();
                    Topping.removedToppingsList = preloadedRemovedList("Deli");
                    topping.setPremiumTopping(premiumTopping);

                    combinedPrice = bread.getBreadMenuPrice() + topping.getPremToppingsTotalPrice();
                    sig.setSignatureName("Deli Delight");
                    sig = new SignatureSandwich(bread, topping, true, combinedPrice);
                    break;
                default:
                    System.out.println("Error, try again");
                    scan.nextLine();
                    continue;
            }

            //Preload the currentList
            //Preload Objects

            System.out.println("""
                    What do you want to do?
                    1) Change Bread
                    2) Change Meat
                    3) Change Cheese
                    4) Change Regular Toppings
                    5) Confirm Order
                    0) Exit
                    """);

            //Send to menus

            //Bread.sandwichMenu("Signature");
            //EXPLAIN Input Validation
            try {
                input = scan.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("I'm sorry,");
                scan.nextLine();
                continue;
            }
            //EXPLAIN Changes Menu
            switch (input) {
                case 0:
                    return null;
                case 1:
                    if ((bread = Bread.sizeAndTypeMenu()) == null) {
                        return null;
                    } else {
                        boolean isToasted = Bread.wantsToasted();
                        sig = new Sandwich(bread, topping, isToasted);
                        ordersMap.put(++Order.itemOrderNumber, sig);
                    }
                    //EXPLAIN General Premium Toppings Menu
                   /* if ((prem = PremiumTopping.premiumToppingsMenu()) == null) {
                        //if null then order was cancelled, so should return to this toppingsMenu
                        continue;
                    } else {
                        top = new Topping(prem);
                        //EXPLAIN Regular Toppings Menu
                        if ((top = Topping.regularToppingsMenu(top)) == null) {
                            //if cancels order in regToppingsMenu() then come back here
                            continue;
                        } else {
                            return top;
                        }
                    }*/
                    //break;
                case 2:
                    premiumTopping = PremiumTopping.sizeAndTypeMenu("Meat", premiumTopping);
                    break;
                case 3:
                    premiumTopping = PremiumTopping.sizeAndTypeMenu("Cheese", premiumTopping);
                    break;
                case 4:
                    if ((topping = Topping.regularToppingsMenu(topping, "Signature")) == null) {
                        break;
                    } else {
                        sb.setLength(0);
                        //if boolean unmodified = true; then skip toasted
                        //any modification means that you have to customize the sandwich from scratch?
                        Bread.wantsToasted();

                        //FIXME May need to add topping to orderMap??? then return
                        return sig;
                    }
                case 5:
                    if (Topping.confirmOrder("Signature Sandwich") == -1) {
                        continue;
                    } else {
                        sb.setLength(0);
                        ordersMap.put(++Order.itemOrderNumber, sig);
                        //if boolean unmodified = true; then skip toasted
                        //any modification means that you have to customize the sandwich from scratch?
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

