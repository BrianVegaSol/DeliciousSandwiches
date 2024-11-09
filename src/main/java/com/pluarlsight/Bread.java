package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;
//TASK Can use setters to change order at CheckOut Menu ugh
// Maybe ovverride the Menus so that they look the same but use setters?
public class Bread extends Sandwich{
    //FIXME Separate Bread and make this Sandwich
    // might need to make the enums not private
    private int numOfSandwiches;
    private BreadType breadType;
    private BreadSize breadSize;
    static Scanner scan = new Scanner(System.in);

    public Bread(BreadType breadType, BreadSize breadSize, int numOfSandwiches) {
        super();
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.numOfSandwiches = numOfSandwiches;
    }

    public Bread(BreadType breadType, BreadSize breadSize) {
        super();
        this.breadType = breadType;
        this.breadSize = breadSize;
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

    public double getBreadMenuPrice () {
        return breadSize.getMenuPrice();
    }

    private enum BreadSize {
        FOUR_INCH(1, "4\"", 5.50),
        EIGHT_INCH(2, "8\"", 7.00),
        TWELVE_INCH(3, "12\"", 8.50);

        public double getMenuPrice() {
            return menuPrice;
        }

        private String itemType;
        private final int menuNum;
        private String sizeName;
        private final double menuPrice;

        BreadSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.menuPrice = menuPrice;
            this.sizeName = sizeName;
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
    public static void sandwichMenu(byte numOfSandwiches) throws InterruptedException {
        byte sandwichesMade = 0;
        int breadSizeInput = -1;
        double sandwichPriceTally = 0;
        //FIXME Prooobably gonna break stuff ToT
        BreadType type = BreadType.RYE;
        BreadSize size = BreadSize.FOUR_INCH;
        //EXPLAIN Loop until all sandwiches are made
        while (sandwichesMade < (numOfSandwiches)) {
            Bread bread;
        bread = (Bread) sizeAndTypeMenu();
            //byte sandwichInput;
            //TODO Make Validations into methods w/ returns
            /*//EXPLAIN Validation for type ->
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
                    size = BreadSize.values()[breadSizeInput - 1];
                    break;
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Sorry! We don't make them that long!");
                    scanBread.nextLine();
                }
            }
            //EXPLAIN END <-*/
            //FIXME Need to move this AFTER calling the Toppings()s to have a complete Sandwich
            // If dynamicMenu 0) return acts like I think it does, will not add Bread if Toppings order is cancelled
            //TODO Only do this if cant access vars in Bread due to being private
            //FIXME Remove when sandwichBuilder() works
            //Order.ordersMap.put(++Order.itemOrderNumber,bread);
            //FIXME Remove for final product
            //FIXME Add toppingsMenu() here???
            //Toppings.remainingRegularToppingsMenu();
            //FIXME Probably need to return -1 for extraToppingsMenu() as well
            // Rerunning itself
            //EXPLAIN Validation for Toppings Menu ->
            if ((Topping.toppingsMenu() == null)) {
                return;
            } else {
                //TASK Planning on removing keeping the numOfSandwiches as a loop condition and instead
                // just making 1 sandwich at a time
                // Then have Topping and Bread added to Sandwich class here, ordersMap.add(sandwich) and
                // sout Order Placed Successfully, reflect this change in the Checkout()
                //Bread breadName = new Bread(type, size, numOfSandwiches);
                System.out.println(bread);
                //Sandwich sandwich = new Sandwich(bread, );
                System.out.println("Sandwich Order Placed Successfully!");
                //EXPLAIN Trying to tally price for each sandwich here
                sandwichPriceTally += bread.breadSize.menuPrice;
                //END
                sandwichesMade++;
            }
            //END <-
        }
        System.out.println("\033[32m" + "Order Placed Successfully" + "\033[0m\n");
        //TODO return Bread Object???;
    }

    public double calcBreadPriceTotal() {
        double total = 0;
        return total;
    }

public static Object sizeAndTypeMenu () {
        byte input = -1;
                Bread bread = null;
                BreadSize size;
                BreadType type;
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
                        int breadTypeInput = scan.nextInt();
                        type = BreadType.values()[breadTypeInput - 1];
                        break;
                    } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Sorry! We don't have that in stock right now!");
                        scan.nextLine();
                    }
                }
                //END <-

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
                        int breadSizeInput = scan.nextInt();
                        size = BreadSize.values()[breadSizeInput - 1];
                        break;
                    } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Sorry! We don't make them that long!");
                        scan.nextLine();
                    }
                    //END <-
                }
                return bread = new Bread(type, size);
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
                .append("\nType: ").append(breadType.name).append(" Bread")
                .append("\nSize: ").append(breadSize.sizeName)
                .append(String.format("\nPrice: $%.2f%n", breadSize.menuPrice))
                .toString();
    }
}


