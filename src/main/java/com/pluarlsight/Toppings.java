package com.pluarlsight;

public class Toppings {
    private int numOfToppings;
    private MeatType meatType;
    private MeatSize meatSize;
    /*private Cheeses cheese;
    private RegularToppings regTops;
    private Sauces sauce;
    private Sides side;*/

    //EXPLAIN Meat Enums ->
    private enum MeatType {
        STEAK(1, "Steak"), HAM (2, "Ham"),
        SALAMI (3, "Salami"), ROAST_BEEF (4, "Roast Beef"),
        CHICKEN (5, "Chicken"), BACON (6,"Bacon");

        private int menuNum;
        private String menuName;
        MeatType(int menuNum, String menuName) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

    }

    private enum MeatSize{
        FOUR_INCH (1, "4\"", 1.00) ,
        EIGHT_INCH (2, "8\"", 2.00) ,
        TWELVE_INCH (3, "12\"", 3.00);

        private int menuNum;
        private String sizeName;
        private double menuPrice;
        MeatSize (int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }
    //END <-













/*
Toppings: - the user should be able to add extras of each topping
§ Meat:
§ Cheese:
§ Other toppings:
§ Select sauces:
o Would you like the sandwich toasted?
*/


}

