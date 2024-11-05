package com.pluarlsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Order{
    StringBuilder sb = new StringBuilder();
    //FIXME Need to either make toString here, update all other toStrings, or accept all other Objects into Order Obj
    // OR can just chop off the Order# (since it needs to get deleted anyway) and only show that in checkout() 0.0
    static HashMap<Integer, Object> ordersMap = new HashMap<>();
    //FIXME is it not saving because of this???
    static int itemOrderNumber = -1;
    private Bread bread;
    private Toppings toppings;
    private OtherProduct products;
    
    /*public Order (Bread bread, Toppings toppings) {
        this.bread = bread;
        this.toppings = toppings;
    }*/
    public Order (Bread bread) {
        this.bread = bread;
    }
    public Order (Toppings toppings) {
        this.toppings = toppings;
    }

    public void sandwichBuilder(Bread bread, Toppings toppings){

    }

//Unless theres a better way to do this, like having an Order Builder
//Where there is a centralized method that takes in all situations for cases like
//no sandwich/toppings/drink only chips

public String orderNoDrinkNoChips (Bread sand, Toppings top) {
        return "";
}
//Super long toString for Checkout
public String formatReceipt (HashMap<LocalDateTime, Order> orders) {
    return sb.append("s")//.append(var).
            //.append()
            .toString();
}
//TODO needs to be names LocalDateTime.now().txt
// String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
    // where should the file that holds receipts be???
    //file path = receipts\fileName
public void writeToReceiptFolder () {

}
}