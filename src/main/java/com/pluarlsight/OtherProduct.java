package com.pluarlsight;

import java.security.PublicKey;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OtherProduct {
    private DeliCola deliCola;
    private DelishChips delishChips;
    private String type;
    //TASK Need to add FLAVORSSSS AND CHIP TYPEEESSS

    OtherProduct(DeliCola deliCola) {
        this.deliCola = deliCola;
        OtherProduct.this.type = "Drink";
    }

    OtherProduct(DelishChips delishChips) {
        this.delishChips = delishChips;
        OtherProduct.this.type = "Chips";
    }

    public void setType(String type) {
        this.type = type;
    }

    //EXPLAIN Drink enum ->
    private enum DeliCola {
        SMALL(1, "Small", 2.00),
        MEDIUM(2, "Medium", 2.50),
        LARGE(3, "Large", 3.00);

        private int menuNum;
        private String menuName;
        private double menuPrice;

        DeliCola(int menuNum, String menuName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }

    }
    //END
    //EXPLAIN Chips enum
    private enum DelishChips {
        DELISH_CHIPS(1, "Delish Chips", 1.50);

        private int menuNum;
        private String menuName;
        private double menuPrice;

        DelishChips(int menuNum, String menuName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuName = menuName;
            this.menuPrice = menuPrice;
        }
    }
    //END

    public static void addDrink(byte numOfDrinks) {
        //TODO Make Val a meThod that takes 2 prompts
        DeliCola size;
        Scanner scan = new Scanner(System.in);
        byte drinksMade = 0;
        int drinkInput = -1;
        while (drinksMade < (numOfDrinks)) {
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
                    size = OtherProduct.DeliCola.values()[drinkInput - 1];
                    break;
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Sorry, we don't offer that size here!");
                    scan.nextLine();
                }
            }
            //TODO Add DateTime and Object to HashMap
            OtherProduct drink = new OtherProduct(size);
            Order.ordersMap.put(++Order.itemOrderNumber, drink);
            System.out.println(drink.toString());
            System.out.println("\033[32m" + "Order Placed Successfully" + "\033[0m\n");
            drinksMade++;
        }
        //TODO Move success sout here when Checkout is functional and does BONUS???
    }

    public static void addChips () {

    }

   /* public static validation () {
        return;
    }*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (OtherProduct.this.type.equalsIgnoreCase("Drink")) {
            return sb.append("\033[33m").append("Order# ").append((Order.itemOrderNumber + 1)).append("\033[0m")
                    .append("\n\nDrink Details")
                    .append("\n===========================================")
                    .append("\nSize: ").append(deliCola.menuName)
                    .append(String.format("\nPrice: $%.2f%n", deliCola.menuPrice))
                    .toString();
        }
        if (OtherProduct.this.type.equalsIgnoreCase("Chips")) {
        }
        return "";
    }

}
