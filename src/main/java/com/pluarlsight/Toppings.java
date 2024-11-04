package com.pluarlsight;

public class Toppings {
    private int numOfToppings;
    private MeatType meatType;
    private MeatSize meatSize;
    private ExtraMeatSize extraMeatSize;
    private CheeseType cheeseType;
    private CheeseSize cheeseSize;
    private ExtraCheeseSize extraCheeseSize;
    //FIXME Not sure how to handle the Regular toppings since they're already included???
    // Should I ask if the user wants to remove certain toppings instead of asking to add???
    // Hashmap prefilled with RegToppings, have user remove those toppings, then add remaining toppings to???
    // Have a method that returns the prefilled HashMap in case user makes a mistake (clear existing list before doing so?)

    //FIXME Use an Arraylist, remove from list, then add what remains to the Topping Object?
    // make it so if (instance of valueOf Object) isEmpty   OR

    //FIXME Use a HashMap, normal for loop over all indices (the max should always be the same)
    // for (int i = 0; i < 10; i++) {
    // if i == null/isEmpty then {print/return No pickles}
    // in StringBuilder/sandwichBuilder have is display all ingredients and \n No pickles etc
    // if (String.contains (maaaybe use split/substring))
    // loop over split[], if i.contains(removedItems) remove & print No removedItem


    //FIXME Should this be in the Sandwich toString()???
    //TODO Leaning towards Arraylist<String> since I'll need it to print the Included Ingredients UNLESS for
    // HashMap have a condition if (entry/index != Empty) then print
    // HashMap seems to be the winner to avoid contains/subString
    // Probably gonna need 2 Collections, the IncludedMap and RemovedMap OR compare resetMap and RemovedMap

    //TODO F I N A L Use 2 Arraylists, one with allToppings, another with removedToppings
    // Add 2 Arraylists to Toppings???
    // Add Bread and Toppings to Sandwich
    // Make toString in Sandwich
    // Add Sandwich to ordersMap

    /*FIXME F I N A L sout Sandwich Order # 1
       Sandwich Details
       Bread
       Included Ingredients
       Removed Ingredients
     */



    //FIXME Flow Collection removes toppings -> Add to sandwichBuilder() then Sandwich/Bread Object, add the Obj to map
    // Sandwich class should accept Bread and Toppings as its Constructor, potentially extend???

    //FIXME LATER Omit price in toStrings() and keep a priceTotalForType to display at the bottoms
    // need to keep the individual prices too tho!

    //private RegularToppings regTops;
    //private Sauces sauce;
    //private Sides side;

    Toppings top;

    public Toppings() {
        if (this instanceof Toppings) {


        }
    }

    //EXPLAIN Meat Enums ->
    //FIXME Probably gonna wanna add the type for HashMap here
    private enum MeatType {
        STEAK(1, "Steak", false),
        HAM(2, "Ham", false),
        SALAMI(3, "Salami", false),
        ROAST_BEEF(4, "Roast Beef", false),
        CHICKEN(5, "Chicken", false),
        BACON(6, "Bacon", false);

        private int menuNum;
        private String menuName;
        private boolean wantsExtraMeat;

        MeatType(int menuNum, String menuName, boolean wantsExtraMeat) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

    }

    private enum MeatSize {
        FOUR_INCH(1, "4\"", 1.00),
        EIGHT_INCH(2, "8\"", 2.00),
        TWELVE_INCH(3, "12\"", 3.00);

        private int menuNum;
        private String sizeName;
        private double menuPrice;
        private boolean wantsExtra;

        MeatSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }

    private enum ExtraMeatSize {
        FOUR_INCH(1, "4\"", 0.50),
        EIGHT_INCH(2, "8\"", 1.00),
        TWELVE_INCH(3, "12\"", 1.50);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        ExtraMeatSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }

    //END <-
    //EXPLAIN Cheese enums ->
    private enum CheeseType {
        AMERICAN(1, "American"), PROVOLONE(2, "Provolone"),
        CHEDDAR(3, "Cheddar"), SWISS(4, "Swiss");

        private int menuNum;
        private String menuName;

        CheeseType(int menuNum, String menuName) {
            this.menuNum = menuNum;
            this.menuName = menuName;
        }

    }

    private enum CheeseSize {
        FOUR_INCH(1, "4\"", 0.75),
        EIGHT_INCH(2, "8\"", 1.50),
        TWELVE_INCH(3, "12\"", 2.25);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        CheeseSize(int menuNum, String sizeName, double menuPrice) {
            this.menuNum = menuNum;
            this.sizeName = sizeName;
            this.menuPrice = menuPrice;
        }
    }

    private enum ExtraCheeseSize {
        FOUR_INCH(1, "4\"", 0.30),
        EIGHT_INCH(2, "8\"", 0.60),
        TWELVE_INCH(3, "12\"", 0.90);

        private int menuNum;
        private String sizeName;
        private double menuPrice;

        ExtraCheeseSize(int menuNum, String sizeName, double menuPrice) {
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "";
    }

}

