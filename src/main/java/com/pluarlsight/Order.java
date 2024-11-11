package com.pluarlsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    static StringBuilder sb = new StringBuilder();
    //FIXME Need to either make toString here, update all other toStrings, or accept all other Objects into Order Obj
    // OR can just chop off the Order# (since it needs to get deleted anyway) and only show that in checkout() 0.0
    static HashMap<Integer, Object> ordersMap = new HashMap<>();
    //FIXME is it not saving because of this???
    static int itemOrderNumber = -1;
    //private Bread bread;
    //private Toppings toppings;
    private Sandwich sandwich;
    private OtherProduct products;

    public Order(Sandwich sandwich, OtherProduct products) {
        this.sandwich = sandwich;
        this.products = products;
    }

    public Order(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Order(OtherProduct products) {
        this.products = products;
    }

    public Order() {

    }

    public double getOrderSubTotal() {
        return 0;
        //sandwich.getCombinedPrice() + products.getDrinkMenuPrice() + products.getChipsMenuPrice();
    }

    /*public Order (Bread bread, Toppings toppings) {
        this.bread = bread;
        this.toppings = toppings;
    }*/
    /*public Order (Bread bread) {
        this.bread = bread;
    }
    public Order (Toppings toppings) {
        this.toppings = toppings;
    }*/

    //TASK Use this in dynamicMenu(), return Sandwich Object, feed Sandwich Object to printSandwich()
    // all for last step in dynamicMenu()
    //TODO Move the bottom half of this method into Sandwich and do as above ^
   /* public void sandwichBuilder() {
        if (ordersMap.containsValue(sandwich instanceof Bread)) {
            System.out.println(sandwich.getBread().toString()); // Rely on toString() of each class
            System.out.println(sandwich.getCombinedPrice()); // Probably need to manually format this one, OR
            // just make the toString() in sandwich do that to just do sandwich.toString() here
        }

        //TODO Implement this in the Sandwich class to make the above the only necessary code
        *//*if (ordersMap.containsValue(toppings)) {
            System.out.println(bread); // Rely on toString() of each class
        }
        if (ordersMap.containsValue(bread)) {
            System.out.println(bread); // Rely on toString() of each class
        }*//*
    }*/

//Unless theres a better way to do this, like having an Order Builder
//Where there is a centralized method that takes in all situations for cases like
//no sandwich/toppings/drink only chips

    public String orderNoDrinkNoChips(Bread sand, Topping top) {
        return "";
    }

    //Super long toString for Checkout
    //public String formatReceipt(HashMap<LocalDateTime, Order> orders) {
        /*return sb.append("s")//.append(var).
                //.append()
                .toString();*/
    //FIXME ditch toString()s, name them all print() and hope that value prints it properly? :')
    public static String formatReceipt(String function) {
        sb.setLength(0);
        if (Order.ordersMap.isEmpty()) {
            sb.append("\033[31m").append("Hmmm, it doesn't look like you've ordered anything yet!\n")
                    .append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);


        } else {
            Order.ordersMap.forEach((key, value) -> {
                sb.append("\n\033[33m").append("Order# ").append(key + 1).append("\033[0m");
                System.out.println(sb.toString());
                //sb.setLength(0);

                        /*if (value instanceof OtherProduct) {
                            if (OtherProduct.getType().equals("Drink")) {
                                System.out.println(((OtherProduct) value).print("Drink"));
                            }
                            if (OtherProduct.getType().equals("Chips")) {
                                System.out.println(((OtherProduct) value).print("Drink"));
                            }
                        }*/
                if (value instanceof OtherProduct) {
                    sb.append(((OtherProduct) value).print());
                }

                if (value instanceof Sandwich) {
                    sb.append(((Sandwich) value).print());
                }
                /*if (function.equalsIgnoreCase("Print")) {
                    System.out.println(sb + "\n");
                }*/
            });
            if (function.equalsIgnoreCase("Write")) {
                return sb.toString();
            }
        }
        System.out.println(sb.toString());
        sb.setLength(0);
        return "";
    }

     static void writeReceipt() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String now = LocalDateTime.now().format(format);
        String filePath = "receipts/" + now + ".txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(formatReceipt("Write"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.setLength(0);
    }

    //TODO needs to be names LocalDateTime.now().txt
// String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
    // where should the file that holds receipts be???
    //file path = receipts\fileName
    /*public void writeToReceiptFolder() {

    }*/

    public String print () {
        return "";
    }
}