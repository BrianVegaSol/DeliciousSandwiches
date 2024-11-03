package com.pluarlsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Order{
    StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Object> ordersMap = new HashMap<>();
    static Integer itemOrderNumber = -1;
    private Bread bread;
    private Toppings toppings;
    //Make this take in the two ArrList<Obj>
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
//needs to be names LocalDateTime.now().txt
    //where should the file that holds receipts be???
    //file path = receipts\fileName
public void writeToReceiptFolder () {

}
}