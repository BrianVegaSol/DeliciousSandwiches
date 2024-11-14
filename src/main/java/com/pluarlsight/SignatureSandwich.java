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

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public static SignatureSandwich signatureSandwichMenu() throws InterruptedException {
        Sandwich sig = new SignatureSandwich();
        PremiumTopping premiumTopping = new PremiumTopping();
        Topping topping = new Topping();
        Bread bread = new Bread();
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
            input = scan.nextByte();
            switch (input) {
                case 1:
                    preloadedList("BLT");
                    BreadSize breadSize = BreadSize.EIGHT_INCH;
                    bread.setBreadSize(breadSize);
                    bread.setBreadType(BreadType.WHITE);

                    Meat
                    sig(, topping);
                    break;
                    case 2:
                        preloadedList("Philly");
                        break;
                case 3:
                    preloadedList("Deli");
                    break;
                default:
                    //error
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

            Bread.sandwichMenu("Signature");
            //EXPLAIN Input Validation
            try {
                input = scan.nextByte();
            } catch (InputMismatchException e) {
                System.err.println("I'm sorry,");
                scan.nextLine();
                continue;
            }
            //EXPLAIN Changes Menu
            switch (input) {
                case 0:
                    return null;
                case 1:

                    //EXPLAIN General Premium Toppings Menu
                    if ((prem = PremiumTopping.premiumToppingsMenu()) == null) {
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
                    }
                    //break;
                case 2:
                    premiumTopping = PremiumTopping.sizeAndTypeMenu("Meat" , premiumTopping);
                   break;
                case 3:
                    premiumTopping = PremiumTopping.sizeAndTypeMenu("Cheese" , premiumTopping);
                    break;
                case 4:
                    break;
                default:
                    //error
                    scan.nextLine();
                    continue;
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

