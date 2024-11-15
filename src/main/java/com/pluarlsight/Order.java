package com.pluarlsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Object> ordersMap = new HashMap<>();
    static int itemOrderNumber = -1;
    static double subtotal = 0.0;

    public Order() {
    }

    public static String formatReceipt(String function) {
        sb.setLength(0);
        if (Order.ordersMap.isEmpty()) {
            sb.append("\033[31m").append("Hmmm, it doesn't look like you've ordered anything yet!\n")
                    .append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
        } else {
            return distinctWithQuantity(function);
        }
        return "";
    }

    static void writeReceipt() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String now = LocalDateTime.now().format(format);
        String filePath = "receipts/" + now + ".txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(formatReceipt("Receipt"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.setLength(0);
    }

    public static String distinctWithQuantity(String function) {
        sb.setLength(0);
        subtotal = 0.0;
        String orderDetails = "";
        //EXPLAIN Taking the Objects as the key and having the # of duplicate entries as the value ->
        Map<String, Integer> duplicatesWithCount = new HashMap<>();
        for (Object obj : ordersMap.values()) {
            if (obj instanceof Sandwich) {
                orderDetails = ((Sandwich) obj).print("Checkout", 1);
                subtotal += ((Sandwich) obj).getCombinedPrice();
            }

            if (obj instanceof OtherProduct) {
                if (((OtherProduct) obj).getType().equalsIgnoreCase("Drink")) {
                    orderDetails = ((OtherProduct) obj).print("Checkout", 1);
                    subtotal += ((OtherProduct) obj).getDrinkPriceTotal();
                }

                if (((OtherProduct) obj).getType().equalsIgnoreCase("Chips")) {
                    orderDetails = ((OtherProduct) obj).print("Checkout", 1);
                    subtotal += ((OtherProduct) obj).getChipsPriceTotal();
                }
            }

            duplicatesWithCount.put(orderDetails, duplicatesWithCount.getOrDefault(orderDetails, 0) + 1);
        }
        //END <-
        int quantity = 0;
        //EXPLAIN Used to filter duplicates
        Set<String> seenEntries = new HashSet<>();
        //END
        StringBuilder sandwichSB = new StringBuilder();
        StringBuilder drinkSB = new StringBuilder();
        StringBuilder chipsSB = new StringBuilder();

        //EXPLAIN Updating the Quantity of duplicates in the print()s
        for (Map.Entry<Integer, Object> sout : ordersMap.entrySet()) {

            if (sout.getValue() instanceof Sandwich) {
                orderDetails = ((Sandwich) sout.getValue()).print("Checkout", 1);
                quantity = duplicatesWithCount.get(orderDetails);
                if (!seenEntries.contains(orderDetails)) {
                    seenEntries.add(orderDetails);
                    if (function.equals("Receipt")) {

                        sandwichSB.append(((Sandwich) sout.getValue()).print("Receipt", quantity));
                    } else {
                        sandwichSB.append(((Sandwich) sout.getValue()).print("Checkout", quantity));
                    }
                }
            }

            if (sout.getValue() instanceof OtherProduct) {
                if (((OtherProduct) sout.getValue()).getType().equalsIgnoreCase("Drink")) {
                    orderDetails = ((OtherProduct) sout.getValue()).print("Checkout", 1);
                    quantity = duplicatesWithCount.get(orderDetails);
                    //EXPLAIN Adding unique entries to Hashset and sb to filter out duplicates ->
                    if (!seenEntries.contains(orderDetails)) {
                        seenEntries.add(orderDetails);
                        if (function.equals("Receipt")) {
                            drinkSB.append(((OtherProduct) sout.getValue()).print("Receipt", quantity));
                        } else {
                            drinkSB.append(((OtherProduct) sout.getValue()).print("Checkout", quantity));
                        }
                    }
                    //END <-
                }

                if (((OtherProduct) sout.getValue()).getType().equalsIgnoreCase("Chips")) {
                    orderDetails = ((OtherProduct) sout.getValue()).print("Checkout", 1);
                    quantity = duplicatesWithCount.get(orderDetails);
                    if (!seenEntries.contains(orderDetails)) {
                        seenEntries.add(orderDetails);
                        if (function.equals("Receipt")) {
                            chipsSB.append(((OtherProduct) sout.getValue()).print("Receipt", quantity));
                        } else {
                            chipsSB.append(((OtherProduct) sout.getValue()).print("Checkout", quantity));
                        }
                    }
                }
            }
        }
        //EXPLAIN Ensures that all orders print as follows: Sandwich, Drink, Chips
        sb.append(sandwichSB);
        sandwichSB.setLength(0);
        sb.append(drinkSB);
        drinkSB.setLength(0);
        sb.append(chipsSB);
        chipsSB.setLength(0);
        if (function.equalsIgnoreCase("Receipt")) {
            sb.append(Order.printSubtotal());
        } else {
            sb.append("\033[92m").append(Order.printSubtotal()).append("\033[0m");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String printSubtotal() {
        return "\n----------------------------------------------------------------------------------------\n" +
                String.format("Subtotal : $%.2f", subtotal);
    }

    public String print(String function) {
        return "";
    }
}