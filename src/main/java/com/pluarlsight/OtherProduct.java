package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OtherProduct {
    private DeliColaSize deliColaSize;
    private DeliColaType deliColaType;
    private DelishChipsType delishChipsType;
    private double drinkPriceTotal;
    private double chipsPriceTotal;
    static StringBuilder sb = new StringBuilder();

    private String type;
    //TASK Need to add FLAVORSSSS AND CHIP TYPEEESSS

    OtherProduct(DeliColaSize deliColaSize, DeliColaType deliColaType) {
        this.deliColaSize = deliColaSize;
        this.deliColaType = deliColaType;
        OtherProduct.this.type = "Drink";
    }

    public String getType() {
        return type;
    }

    public double getDrinkPriceTotal() {
        return drinkPriceTotal;
    }

    OtherProduct(DelishChipsType delishChipsType) {
        this.delishChipsType = delishChipsType;
        OtherProduct.this.type = "Chips";
    }

    public double getChipsPriceTotal() {
        return chipsPriceTotal;
    }

    public void setType(String type) {
        this.type = type;
    }

    //EXPLAIN Drink enums ->
    private enum DeliColaSize {
        SMALL(1, "Small", 2.00),
        MEDIUM(2, "Medium", 2.50),
        LARGE(3, "Large", 3.00);

        private int menuNum;
        private String menuName;
        private double menuPrice;

        DeliColaSize(int menuNum, String menuName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }

        public String getMenuName() {
            return menuName;
        }

        public int getMenuNum() {
            return menuNum;
        }

        public double getMenuPrice() {
            return menuPrice;
        }
    }

    private enum DeliColaType {
        ROOT_BEER(1, "Root Beer"),
        RASPBERRY_FUSION(2, "Raspberry Fusion"),
        LEMONADE_SUPREME(3, "Lemonade Supreme");

        private final int menuNum;
        private final String menuName;

        DeliColaType(int menuNum, String menuName) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

        public int getMenuNum() {
            return menuNum;
        }

        public String getMenuName() {
            return menuName;
        }
    }
    //END

    //EXPLAIN Chips enum
    private enum DelishChipsType {
        DELISH_CHIPS_CLASSIC(1, "Classic", 1.50),
        DELISH_CHIPS_FLAMIN_HOT(2, "Flamin Hot", 1.50),
        DELISH_CHIPS_SOUR_CREAM(3, "Sour Cream", 1.50);

        private int menuNum;
        private String menuName;
        private double menuPrice;

        DelishChipsType(int menuNum, String menuName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }

        public String getMenuName() {
            return menuName;
        }

        public int getMenuNum() {
            return menuNum;
        }

        public double getMenuPrice() {
            return menuPrice;
        }
    }
    //END

    public static void addDrink() throws InterruptedException {
        //TODO Make Val a meThod that takes 2 prompts
        DeliColaSize size = null;
        DeliColaType type;
        Scanner scan = new Scanner(System.in);
        int drinkInput = -1;
        while (true) {
            System.out.println("""
                    What size do you want?
                    1) Small
                    2) Medium
                    3) Large
                    """);
            //TODO Make this try catch a method
            try {
                drinkInput = scan.nextInt();
                size = DeliColaSize.values()[drinkInput - 1];
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Sorry, we don't offer that size here!");
                scan.nextLine();
            }
            System.out.println("""
                    What flavor do you want?
                    1) Root Beer
                    2) Raspberry Fusion
                    3) Lemonade Supreme
                    """);
            //TODO Make this try catch a method
            try {
                drinkInput = scan.nextInt();
                type = DeliColaType.values()[drinkInput - 1];
                break;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Sorry, we don't offer that flavor here!");
                scan.nextLine();
            }

            //TASK DELETE ALL numOrders and add a Confirmation menu, with display, here
        }
        //TODO Add DateTime and Object to HashMap
        OtherProduct drink = new OtherProduct(size, type);
        System.out.print("Let's go over your order\n");
        System.out.println(drink.print("Drink"));
        sb.setLength(0);
        if (Topping.confirmOrder("Drink") == -1) {
            drink = null;
            return;
        }
        drink.drinkPriceTotal += size.menuPrice;
        Order.ordersMap.put(++Order.itemOrderNumber, drink);
        //System.out.println(drink.print("Drink"));
        //TODO Move success sout here when Checkout is functional and does BONUS???
        System.out.println("\033[32m" + "Drink Order Placed Successfully" + "\033[0m\n");
    }


    public static void addChips() {

    }

    /* public static validation () {
         return;
     }*/
    //TODO Make Object the parameter to make this a Generic Display?
    public static void confirmationScreen() {

    }

    public String print(String type) {
        //sb.append("\033[33m").append("Order# ").append((Order.itemOrderNumber + 1)).append("\033[0m")
        if (type.equalsIgnoreCase("Drink")) {
            sb.append("\033[35m").append("Drink Details")
                    .append("\n=============").append("\033[0m")
                    .append("\nFlavor: ").append(deliColaType.menuName)
                    .append("\nSize: ").append(deliColaSize.menuName)
                    .append("\033[32m").append(String.format("\nPrice: $%.2f%n", deliColaSize.menuPrice))
                    .append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
            //return "";
        }

        if (type.equalsIgnoreCase("Chips")) {
            sb.append("\033[97m").append("Chip Details")
                    .append("\n============").append("\033[0m")
                    .append("\nDelish Chips Flavor: ").append(delishChipsType.menuName)
                    .append("\033[32m").append(String.format("\nPrice: $%.2f%n", delishChipsType.menuPrice))
                    .append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
        }

        return "";
    }

    /*@Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        if (OtherProduct.this.type.equalsIgnoreCase("Drink")) {
            return sb.append("\033[33m").append("Order# ").append((Order.itemOrderNumber + 1)).append("\033[0m")
                    .append("\n\nDrink Details")
                    .append("\n===========================================")
                    .append("\nFlavor: ").append(deliColaType.menuName)
                    .append("\nSize: ").append(deliColaSize.menuName)
                    .append(String.format("\nPrice: $%.2f%n", deliColaSize.menuPrice))
                    .toString();
        }
        if (OtherProduct.this.type.equalsIgnoreCase("Chips")) {
            return sb.append("\033[33m").append("Order# ").append((Order.itemOrderNumber + 1)).append("\033[0m")
                    .append("\n\nChip Details")
                    .append("\n===========================================")
                    .append("\nSize: ").append(delishChipsType.menuName)
                    .append(String.format("\nPrice: $%.2f%n", delishChipsType.menuPrice))
                    .toString();
        }
        return "Both toString if instanceof failed in OtherProduct :')";
    }*/

}
