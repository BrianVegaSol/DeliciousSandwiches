package com.pluarlsight;

import java.util.Scanner;

public class PremiumTopping extends Topping{
    private PremiumTopping.MeatType meatType;
    private PremiumTopping.MeatSize meatSize;
    private PremiumTopping.ExtraMeatSize extraMeatSize;
    private PremiumTopping.CheeseType cheeseType;
    private PremiumTopping.CheeseSize cheeseSize;
    private PremiumTopping.ExtraCheeseSize extraCheeseSize;
    private double premiumToppingsMenuPrice;
    private static StringBuilder sb = new StringBuilder();

    public PremiumTopping () {
        super();
        this.premiumToppingsMenuPrice = getCheeseSize().menuPrice + getExtraCheeseSize().menuPrice +
        getMeatSize().menuPrice + getExtraMeatSize().menuPrice;
    }

    public CheeseSize getCheeseSize() {
        return cheeseSize;
    }

    public void setCheeseSize(CheeseSize cheeseSize) {
        this.cheeseSize = cheeseSize;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public ExtraCheeseSize getExtraCheeseSize() {
        return extraCheeseSize;
    }

    public void setExtraCheeseSize(ExtraCheeseSize extraCheeseSize) {
        this.extraCheeseSize = extraCheeseSize;
    }

    public ExtraMeatSize getExtraMeatSize() {
        return extraMeatSize;
    }

    public void setExtraMeatSize(ExtraMeatSize extraMeatSize) {
        this.extraMeatSize = extraMeatSize;
    }

    public MeatSize getMeatSize() {
        return meatSize;
    }

    public void setMeatSize(MeatSize meatSize) {
        this.meatSize = meatSize;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    /*public PremiumTopping(PremiumTopping premiumTopping, double premToppingsTotalPrice, CheeseSize cheeseSize,
                          CheeseType cheeseType, ExtraCheeseSize extraCheeseSize, ExtraMeatSize extraMeatSize,
                          MeatSize meatSize, MeatType meatType, double premiumToppingsMenuPrice) {
        super(premiumTopping, premToppingsTotalPrice);
        this.cheeseSize = cheeseSize;
        this.cheeseType = cheeseType;
        this.extraCheeseSize = extraCheeseSize;
        this.extraMeatSize = extraMeatSize;
        this.meatSize = meatSize;
        this.meatType = meatType;
        this.premiumToppingsMenuPrice = premiumToppingsMenuPrice;
    }*/


    public double getPremiumToppingsMenuPrice() {
        return premiumToppingsMenuPrice;
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

    //EXPLAIN Separate extraToppingsMenu()???
    public static void premiumToppingsMenu() {
        //vars
        Scanner scan = new Scanner(System.in);
        sb.append("\033[31m").append("Welcome to to Extra Toppings Menu!").append("\033[0m");
        System.out.println(sb.toString());
        sb.setLength(0);
        System.out.println("""
                Would you like Extra Meat?
                1) Yes
                0) No
                """);

        while (true) {
            //sb
            byte input = scan.nextByte();
            switch (input) {
                case 0:

                    break;
                case 1:

            }
        }
    }

    @Override
    public String toString() {
        return "PremiumTopping{" +
                "cheeseSize=" + cheeseSize +
                ", meatType=" + meatType +
                ", meatSize=" + meatSize +
                ", extraMeatSize=" + extraMeatSize +
                ", cheeseType=" + cheeseType +
                ", extraCheeseSize=" + extraCheeseSize +
                '}';
    }
}
