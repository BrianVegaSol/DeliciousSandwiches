package com.pluarlsight;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Order{
    StringBuilder sb = new StringBuilder();
    HashMap<LocalDateTime, Order> orders;
    private Bread bread;
    public Order (Bread bread, Toppings toppings) {
        this.bread = bread;
    }


//Super long toString for Checkout
public String formatReceipt (Bread sand, Toppings top) {
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

