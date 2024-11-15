package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bread extends Sandwich implements Ingredient {
    private BreadType breadType;
    private BreadSize breadSize;
    private static boolean isToasted;
    private static Scanner scan = new Scanner(System.in);
    private static StringBuilder sb = new StringBuilder();

    public Bread() {
        super();

    }

    public Bread(BreadType breadType, BreadSize breadSize) {
        super();
        this.breadType = breadType;
        this.breadSize = breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public double getBreadMenuPrice() {
        return breadSize.getMenuPrice();
    }

    public static Bread sandwichMenu(String function) throws InterruptedException {
        //EXPLAIN Loop until all sandwiches are made
        while (true) {
            Bread bread;
            bread = (Bread) sizeAndTypeMenu();
            System.out.println("Let's go over your order");
            System.out.println(bread.print("Print"));
            sb.setLength(0);
            if (Topping.confirmOrder("Bread") == -1) {
                bread = null;
                return null;
            }

            if (function.equalsIgnoreCase("Signature")) {
                return bread;
            }
            //EXPLAIN END <-

            //EXPLAIN Validation for Toppings Menu ->
            Topping topping;
            if ((topping = Topping.toppingsMenu()) == null) {
                return null;
            } else {
                Sandwich sandwich = new Sandwich(bread, topping, isToasted);
                System.out.println(sandwich.print("Print", 1));
                sb.setLength(0);
                Order.ordersMap.put(++Order.itemOrderNumber, sandwich);
            }
            //END <-
            System.out.println("\033[92m" + "Sandwich Order Placed Successfully" + "\033[0m\n");
            break;
        }
        return null;
    }

    public static boolean wantsToasted() throws InterruptedException {
        isToasted = false;
        while (true) {
            int input = -1;
            System.out.println("Do you want your sandwich toasted?\n1) Yes\n0) No");
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\033[31m" + "I'm sorry, " + "\033[0m");
                scan.nextLine();
                continue;
            }
            switch (input) {
                case 0:
                    isToasted = false;
                    return isToasted;
                case 1:
                    System.out.print("\033[32m" + "Toasting sandwich");
                    Thread.sleep(700);
                    System.out.print(" .");
                    Thread.sleep(700);
                    System.out.print(" .");
                    Thread.sleep(700);
                    System.out.print(" ." + "\033[0m\n");
                    Thread.sleep(700);
                    isToasted = true;
                    return isToasted;
                default:
                    System.out.println("\033[31m" + "So..." + "\033[0m");
                    scan.nextLine();
            }
        }
    }

    public static Bread sizeAndTypeMenu() {
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
    public String print(String function) {
        sb.setLength(0);
        if (function.equalsIgnoreCase("Receipt")) {
            sb.append("Bread Details\n=============")
                    .append("\nType: ").append(breadType.getName()).append(" Bread")
                    .append("\nSize: ").append(breadSize.getSizeName())
                    .append(String.format("\nPrice: $%.2f%n", breadSize.getMenuPrice()))
                    .append("\n");
            return sb.toString();
        }
        //EXPLAIN For most cases
        sb.append("\033[34m").append("Bread Details")
                //TODO .repeat()??? might add more workload
                .append("\n=============").append("\033[0m")
                .append("\nType: ").append(breadType.getName()).append(" Bread")
                .append("\nSize: ").append(breadSize.getSizeName())
                .append("\033[32m").append(String.format("\nPrice: $%.2f%n", breadSize.getMenuPrice()))
                .append("\033[0m");
        sb.append("\n");
        return sb.toString();
    }
}


