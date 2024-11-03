package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bread {
    //FIXME Separate Bread and make this Sandwich
    // might need to make the enums not private
    private int numOfSandwiches;
    private BreadType breadType;
    private BreadSize breadSize;

    public Bread(BreadType breadType, BreadSize breadSize, int numOfSandwiches) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.numOfSandwiches = numOfSandwiches;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public int getNumOfSandwiches() {
        return numOfSandwiches;
    }

    public void setNumOfSandwiches(int numOfSandwiches) {
        this.numOfSandwiches = numOfSandwiches;
    }

    private enum BreadSize {
        FOUR_INCH(1, 5.50, "4\""), EIGHT_INCH(2, 7.00, "8\""),
        TWELVE_INCH(3, 8.50, "12\"");

        private final int menuNum;
        private final double itemPrice;
        private String inches;

        BreadSize(int menuNum, double itemPrice, String inches) {
            this.menuNum = menuNum;
            this.itemPrice = itemPrice;
            this.inches = inches;
        }
    }

    private enum BreadType {
        WHITE(1, "White"), WHEAT(2, "Wheat"), RYE(3, "Rye"), WRAP(4, "Wrap");

        private final int menuNum;
        private String name;


        BreadType(int menuNum, String name) {
            this.menuNum = menuNum;
            this.name = name;
        }
    }

    //FIXME Ensure that Toppings cannot be selected U N L E S S there is a sandwich!
    //TODO Bonus??? Make it so that a customer can edit their order at checkout, must be able to:
    // Minimum have option during creation (sandwich & toppings menus) to Confirm Order before added to HashMap
    public static void sandwichMenu(byte numOfSandwiches) {
        byte sandwichesMade = 0;
        int breadSizeInput = -1;
        Scanner scanBread = new Scanner(System.in);
        //FIXME Prooobably gonna break stuff ToT
        BreadType type = BreadType.RYE;
        BreadSize size = BreadSize.FOUR_INCH;
        //EXPLAIN Loop until all sandwiches are made
        while (sandwichesMade < (numOfSandwiches)) {
            //byte sandwichInput;
            //TODO Make Validations into methods w/ returns
            //EXPLAIN Validation for type ->
            while (true) {
                System.out.println("""
                        What type of bread would you like?
                        ==================================
                        1) White
                        2) Wheat
                        3) Rye
                        4) Wrap
                        ==================================
                        """);

                try {
                    //FIXME should be at the top?
                    int breadTypeInput = scanBread.nextInt();
                    type = BreadType.values()[breadTypeInput - 1];
                    break;
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Sorry! We don't have that in stock right now!");
                    scanBread.nextLine();
                }
            }
            //EXPLAIN END <-
            //EXPLAIN Validation for size ->
            while (true) {

                System.out.println("""
                        What size of bread would you like?
                        ==================================
                        1) 4"
                        2) 8"
                        3) 12"
                        ==================================
                        """);
                try {
                    breadSizeInput = scanBread.nextInt();
                    break;
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Sorry! We don't make them that long!");
                    scanBread.nextLine();
                }
            }
            //EXPLAIN END <-
            size = BreadSize.values()[breadSizeInput - 1];
            Bread bread = new Bread(type, size, numOfSandwiches);
            //EXPLAIN Trying to tally price for each sandwich here
            //TODO Only do this if cant access vars in Bread due to being private
            double total = 0;
            total += bread.breadSize.itemPrice;
            //TODO Need to add to orderMap
            Order.ordersMap.put(Order.itemOrderNumber++,bread);
            //FIXME Remote for final product
            System.out.println(bread);
            //FIXME Add toppingsMenu() here???
            System.out.println("\033[32m" + "Order Placed Successfully" + "\033[0m");
            sandwichesMade++;
        }
        //TODO return Bread Object???;
    }

@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    //homeSB.setLength(0);
    return sb.append("\033[33m").append("Order# ").append((Order.itemOrderNumber + 1)).append("\033[0m")
                //TODO Add a type + Details for when writing to .csv receipt???
                .append("\n\nBread Details")
                //TODO .repeat()??? might add more workload
                .append("\n===========================================")
                .append("\nType: ").append(breadType.name).append("Bread")
                .append("\nSize: ").append(breadSize.inches)
                .append(String.format("\nPrice: $%.2f%n", breadSize.itemPrice))
                .toString();
    }

    public double calcBreadPriceTotal() {
        double total = 0;
        return total;
    }
}


