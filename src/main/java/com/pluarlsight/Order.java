package com.pluarlsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
            //FIXME Will paste this into method later
           /* Order.ordersMap.forEach((key, value) -> {
                sb.append("\n\033[33m").append("Item #").append(key + 1).append("\033[0m\n");*/
            //System.out.println(sb.toString());
            //sb.setLength(0);

                        /*if (value instanceof OtherProduct) {
                            if (OtherProduct.getType().equals("Drink")) {
                                System.out.println(((OtherProduct) value).print("Drink"));
                            }
                            if (OtherProduct.getType().equals("Chips")) {
                                System.out.println(((OtherProduct) value).print("Drink"));
                            }
                        }*/
            //EXPLAIN Holds all distinct Objects in ordersMap as its Key, and # occurrences as its Value
            //TODO So should forEach
            sb.append("\n\n\nTESTING AREA AHEAD\n\n");
            distinctWithQuantity();
            System.out.println("\n\n\n\n");
            //EXPLAIN Legacy version w/o distinct printing
            /*distinctMapEntriesAndQuantity().forEach((Object,count) ->{
                        if (Object instanceof Sandwich) {
                            sb.append(((Sandwich) Object).print("Checkout", count));
                        }

                        if (Object instanceof OtherProduct){
                            if (((OtherProduct) Object).getType().equalsIgnoreCase("Drink")) {
                                sb.append(((OtherProduct) Object).print("Checkout", count));
                            }

                            if (((OtherProduct) Object).getType().equalsIgnoreCase("Chips")) {
                                sb.append(((OtherProduct) Object).print("Checkout", count));
                            }

                        }
                    });*/
            //END
            sb.append("END OF TEST\n\n\n");







                /*if (value instanceof Sandwich) {
                    sb.append(((Sandwich) value).print("Checkout"));
                }

                if (value instanceof OtherProduct) {
                    if (((OtherProduct) value).getType().equalsIgnoreCase("Drink")) {
                        sb.append(((OtherProduct) value).print("Checkout"));
                    }

                    if (((OtherProduct) value).getType().equalsIgnoreCase("Chips")) {
                        sb.append(((OtherProduct) value).print("Checkout"));
                    }
                }

                *//*if (function.equalsIgnoreCase("Print")) {
                    System.out.println(sb + "\n");
                }*//*
            });
            if (function.equalsIgnoreCase("Write")) {
                return sb.toString();
            }*/
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

    public static Map<Object, Long> distinctMapEntriesAndQuantity() {
        //EXPLAIN Duplicate Keys error, probably closest to solution
        /*var fileredMap = ordersMap.values().stream().distinct()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return fileredMap.values().stream().collect(Collectors.toMap(
                Function.identity(),
                value -> ordersMap.values().stream()
                        .filter(v -> v.equals(value))
                        .count()
        ));*/
        //END

        return ordersMap.values().stream()
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(), // Key is the distinct value itself
                        value -> ordersMap.values().stream()
                                .filter(value2 -> value2.equals(value))
                                .count() // Value is the count of this distinct value
                ));

        //If only the comparison worked :')
        /*return ordersMap.values().stream()
                .collect(Collectors.groupingBy(
                        Sandwich::print,
                        Collectors.counting()
                ));*/

    }

    //public static Map<String, Integer> distinctWithQuantity() {
    public static void distinctWithQuantity() {
        /*for (Map.Entry<Integer, Object> entry : ordersMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Count: " + entry.getValue());
        }*/
        String orderDetails = "";
        Map<String, Integer> duplicatesWithCount = new HashMap<>();
        for (Object obj : ordersMap.values()) {
            if (obj instanceof Sandwich) {
                orderDetails = ((Sandwich) obj).print2();
            }

            if (obj instanceof OtherProduct) {
                if (((OtherProduct) obj).getType().equalsIgnoreCase("Drink")) {
                    orderDetails = ((OtherProduct) obj).print2(1);
                }

                if (((OtherProduct) obj).getType().equalsIgnoreCase("Chips")) {
                    orderDetails = ((OtherProduct) obj).print2(1);
                }
            }

            duplicatesWithCount.put(orderDetails, duplicatesWithCount.getOrDefault(orderDetails, 0) + 1);
        }
        int quantity = 0;
        for (Map.Entry<Integer, Object> sout : ordersMap.entrySet()) {
            if (ordersMap.values() instanceof Sandwich) {
                if (sout instanceof Sandwich) {
                    //orderDetails = ((Sandwich) obj).print2();
                    //if (sout.getKey().equals(((Sandwich) ordersMap.values()).print2())) {
                    orderDetails = ((Sandwich) sout.getValue()).print2();
                    quantity = duplicatesWithCount.get(orderDetails);
                    sb.append(((Sandwich) ordersMap.values()).print2()); //FIXME Quantity goes inside print2()
                }
            }

            if (sout.getValue() instanceof OtherProduct) {
                if (((OtherProduct) sout.getValue()).getType().equalsIgnoreCase("Drink")) {
                    orderDetails = ((OtherProduct) sout.getValue()).print2(1);
                    quantity = duplicatesWithCount.get(orderDetails);
                    if (quantity == 1) {
                        sb.append(((OtherProduct) sout.getValue()).print2(quantity));
                    }
                }

                //EXPLAIN This is so close!
                if (((OtherProduct) sout.getValue()).getType().equalsIgnoreCase("Chips")) {
                    orderDetails = ((OtherProduct) sout.getValue()).print2(1);
                    quantity = duplicatesWithCount.get(orderDetails);
                    sb.append(((OtherProduct) sout.getValue()).print2(quantity));
                }
            }
        }
        //FIXME Can probably still keep the old prints and feel the value into them now!
            /*sb.append("Quantity: ").append(sout.getValue());
            sb.append("\n").append(sout.getKey());
            sb.append("\033[32m").append(("\nPrice: $%.2f" ))
                    .append("\033[0m");*/
        System.out.println(sb.toString());
        sb.setLength(0);

        // return duplicatesWithCount;
    }

    /*public static void workPLS () {
        ordersMap.values().stream().filter(order -> order instanceof Sandwich)
                .map(order -> (Sandwich) order)
                .map(Sandwich::getBread)

                .distinct()
                .collect(Collectors.groupingBy());
    }*/

    /*public static Map <Object, Long> workPLS () {
        return ordersMap.values().stream().filter(o -> o instanceof OtherProduct)
                .distinct()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }*/

//public static long countUniqueOrdersSandwich() {
//long count =
                /*var o = ordersMap.values().stream().filter(order -> order instanceof Sandwich)
                        .distinct().co
                .map(order -> (sandwich.print("Receipt")));*/

        /*long count = ordersMap.values().stream().filter(order -> order instanceof Sandwich)
                .map(order -> (Sandwich) order)
                .forEach(order -> Comparator.comparing(Sandwich.bread.getBreadType()))
                .count();

        ordersMap.values().stream().filter(order -> order instanceof Sandwich)
                .map(order -> (Sandwich) order)
                .distinct()
                .forEach(order -> order.print("Receipt" , count));*/
//EXPLAIN Not sure what this is counting but looks promising
        /*long duplcateValues = ordersMap.values().stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().filter(quantity -> quantity > 1)
                .count();
        return duplcateValues;*/
//END

//EXPLAIN Also looked promising
        /*var count = ordersMap.values().stream().distinct()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingLong(e -> 1L)));
                return count;*/
//END
//}


//TODO needs to be names LocalDateTime.now().txt
// String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
// where should the file that holds receipts be???
//file path = receipts\fileName
    /*public void writeToReceiptFolder() {

    }*/

    public String print(String function) {
        return "";
    }
}