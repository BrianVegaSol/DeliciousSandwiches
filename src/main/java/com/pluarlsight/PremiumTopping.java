package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PremiumTopping extends Topping {
    private MeatType meatType;
    private MeatSize meatSize;
    private ExtraMeatSize extraMeatSize;
    private CheeseType cheeseType;
    private CheeseSize cheeseSize;
    private ExtraCheeseSize extraCheeseSize;
    private double premiumToppingsMenuPrice;
    private static StringBuilder sb = new StringBuilder();
    static Scanner scanner = new Scanner(System.in);

    public PremiumTopping() {
        super();
    }

    //TASK use this to fill the toppings, might need a lot of if !null
    /*public PremiumTopping () {
        super();
        this.premiumToppingsMenuPrice = cheeseSize.menuPrice +
                getExtraCheeseSize().menuPrice +
                getMeatSize().menuPrice + getExtraMeatSize().menuPrice;
    }*/


    public ExtraCheeseSize getExtraCheeseSize() {
        return extraCheeseSize;
    }


    public ExtraMeatSize getExtraMeatSize() {
        return extraMeatSize;
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

    public void setExtraCheeseSize(ExtraCheeseSize extraCheeseSize) {
        this.extraCheeseSize = extraCheeseSize;
    }

    public void setExtraMeatSize(ExtraMeatSize extraMeatSize) {
        this.extraMeatSize = extraMeatSize;
    }

    public void setPremiumToppingsMenuPrice(double premiumToppingsMenuPrice) {
        this.premiumToppingsMenuPrice = premiumToppingsMenuPrice;
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
        PEPPERONI(1, "Pepperoni", false),
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
        AMERICAN(1, "American"),
        PROVOLONE(2, "Provolone"),
        CHEDDAR(3, "Cheddar"),
        SWISS(4, "Swiss");

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

        public int getMenuNum() {
            return menuNum;
        }

        public double getMenuPrice() {
            return menuPrice;
        }

        public String getSizeName() {
            return sizeName;
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

    public static PremiumTopping updatePremTop(PremiumTopping premTop) {
        return premTop;
    }

    //FIXME Always returning null, is it necessary to return a PremiumTopping now that setters are used?
    public static PremiumTopping premiumToppingsMenu() throws InterruptedException {
        //TODO Unintended validation! Clears the prem Object everytime the user comes back here!
        PremiumTopping premiumTopping = null;
        premiumTopping = new PremiumTopping();
        byte input = -1;
        while (true) {
            sb.append("\033[31m").append("Extra Toppings Menu!").append("\033[0m");
            System.out.println(sb.toString());
            sb.setLength(0);
            //EXPLAIN Meat Options
            System.out.println("Do you want Meat?\n1) Yes\n0) No");
            try {
                input = scan.nextByte();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("I'm sorry,");
                scan.nextLine();
            }
            if (input == 1) {
                //premiumTopping = sizeAndTypeMenu("Meat", premiumTopping);
                //FIXME Play around with having updatePrem outside or inside
                // Probably should have it inside of size()
                sizeAndTypeMenu("Meat", premiumTopping);
                //System.out.println(premiumTopping);
            }
            //END

            //EXPLAIN Cheese Options
            System.out.println("Do you want Cheese?\n1) Yes\n0) No");
            try {
                input = scan.nextByte();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("I'm sorry,");
                scan.nextLine();
            }
            if (input == 1) {
                //premiumTopping = sizeAndTypeMenu("Cheese", premiumTopping);
                sizeAndTypeMenu("Cheese", premiumTopping);
                //System.out.println(premiumTopping);
            }
            //END

            /*switch (input) {
                case 0:
                    return null;
                case 1:
                    premiumTopping = sizeAndTypeMenu("Meat");
                    break;
                case 2:
                    premiumTopping = sizeAndTypeMenu("Cheese");
                    break;
            }*/
            System.out.println("Let's go over your order");
            System.out.println(premiumTopping);
            sb.setLength(0);
            if (Topping.confirmOrder("Premium Toppings") == -1) {
                return premiumTopping = null;
            } else {
                //Topping.setPremiumTopping();
                System.out.print("Lets move onto the ");
                return premiumTopping;
            }
        }
        //TASK if selected no to all, then sout No Extra Toppings Added in red! then return null
        //TASK LAST sout should say, Let's move onto the Regular Toppings Menu!
    }

    public static PremiumTopping sizeAndTypeMenu(String topping, PremiumTopping prem) throws InterruptedException {
        byte input = -1;
        //PremiumTopping prem; //= new PremiumTopping(); /FIXME Add non, null base values??? then make perm null if cancelled order???
        //FIXME oof this is why Meat is never saved xO when Cheese comes through here, it makes everything null xO
        // if (Meat/Cheese) then ???
        MeatSize meatSize;
        MeatType meatType;
        ExtraMeatSize extraMeat;

        CheeseSize cheeseSize;
        CheeseType cheeseType;
        ExtraCheeseSize extraCheese;

        if (topping.equalsIgnoreCase("Meat")) {
            meatSize = null;
            meatType = null;
            extraMeat = null;
        } else {
            cheeseSize = null;
            cheeseType = null;
            extraCheese = null;
        }
        while (true) {
            System.out.println("What type of " + topping + " would you like?");
            if (topping.equalsIgnoreCase("Meat")) {
                System.out.println("""
                        ==================================
                        1) Pepperoni
                        2) Ham
                        3) Salami
                        4) Roast Beef
                        5) Chicken
                        6) Bacon
                        ==================================
                        """);
            }

            if (topping.equalsIgnoreCase("Cheese")) {
                System.out.println("""
                        ==================================
                        1) American
                        2) Provolone
                        3) Cheddar
                        4) Swiss
                        ==================================
                        """);
            }

            //EXPLAIN Validation for Type ->
            try {
                int typeInput = scanner.nextInt();
                if (topping.equalsIgnoreCase("Meat")) {
                    meatType = MeatType.values()[typeInput - 1];
                    prem.setMeatType(meatType);
                }

                if (topping.equalsIgnoreCase("Cheese")) {
                    cheeseType = CheeseType.values()[typeInput - 1];
                    prem.setCheeseType(cheeseType);

                }
                break;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Sorry! We don't have that topping in stock right now!");
                scanner.nextLine();
            }
        }
        //END <-

        while (true) {
            System.out.println("""
                    What size would you like?
                    ==================================
                    1) 4"
                    2) 8"
                    3) 12"
                    ==================================
                    """);
            //EXPLAIN Validation for Size ->
            try {
                int sizeInput = scanner.nextInt();
                if (topping.equalsIgnoreCase("Meat")) {
                    meatSize = MeatSize.values()[sizeInput - 1];
                    prem.setMeatSize(meatSize);
                }

                if (topping.equalsIgnoreCase("Cheese")) {
                    cheeseSize = CheeseSize.values()[sizeInput - 1];
                    prem.setCheeseSize(cheeseSize);
                }
                break;
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Sorry! We don't have that size!");
                scanner.nextLine();
            }
            //END <-
        }
        //FIXME Start here if Extra Toppings is not working properly ._.
        int wantsExtra = -1;
        while (true) {
            System.out.println("Would you like Extra " + topping + "?");
            System.out.println("""
                    ==================================
                    1) Yes
                    0) No
                    ==================================
                    """);
            //EXPLAIN Validation for Extra topping ->
            try {
                wantsExtra = scanner.nextInt();
            int extraInput;
            switch (wantsExtra) {
                case 0:
                    System.out.println("No Extra " + topping + ", got it!");
                    break;
                case 1:
                    while (true) {
                        System.out.println("""
                                What size would you like?
                                ==================================
                                1) 4"
                                2) 8"
                                3) 12"
                                ==================================
                                """);
                        //EXPLAIN Validation for Extra topping ->
                        try {
                            extraInput = scanner.nextInt();
                            if (topping.equalsIgnoreCase("Meat")) {
                                extraMeat = ExtraMeatSize.values()[extraInput - 1];
                                prem.setExtraMeatSize(extraMeat);
                            }

                            if (topping.equalsIgnoreCase("Cheese")) {
                                extraCheese = ExtraCheeseSize.values()[extraInput - 1];
                                prem.setExtraCheeseSize(extraCheese);
                            }
                            break;
                        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                            sb.append("\033[31m").append("Sorry! We don't have that size!").append("\033[0m");
                            System.out.println(sb.toString());
                            sb.setLength(0);
                            scanner.nextLine();
                            continue;
                        }
                    }
                    break;
                default:
                    sb.append("\033[31m").append("I'm sorry,").append("\033[0m");
                    System.out.println(sb.toString());
                    sb.setLength(0);
                    continue;
                    //END <-
            }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                System.err.println("I'm sorry,");
                scanner.nextLine();
                continue;
            }
            break;
        }


        //FIXME Need to either separate the Meat and Cheese menus ANDOR add validation so that the values stay null
        // and only get updated by user but also get nulled when user cancels order
        //PremiumTopping prem = null;
        /*prem.setMeatSize(meatSize);
        prem.setMeatType(meatType);
        prem.setExtraMeatSize(extraMeat);
        prem.setCheeseSize(cheeseSize);
        prem.setCheeseType(cheeseType);
        prem.setExtraCheeseSize(extraCheese);*/
        //prem = new Topping(type, size);
        return prem;
    }
    //return null;


    @Override
    public String toString() {
        sb.append("\033[31m").append("Premium Topping Details")
                .append("\n===========================================").append("\033[0m");
        if (meatSize != null) {
                    sb.append("\n").append(meatType.menuName).append(" Added")
                    .append("\nSize: ").append(meatSize.sizeName)
                    .append(String.format("\nPrice: $%.2f%n", meatSize.menuPrice));
            if (extraMeatSize != null) {
                sb.append("\nExtra ").append(meatType.menuName).append(" Added")
                        .append("\nSize: ").append(extraMeatSize.sizeName)
                        .append(String.format("\nPrice: $%.2f%n", extraMeatSize.menuPrice));
            }
        }


        if (cheeseSize != null) {
            sb.append("\n===========================================")
                    .append("\n").append(cheeseType.menuName).append(" Cheese Added")
                    .append("\nSize: ").append(cheeseSize.sizeName)
                    .append(String.format("\nPrice: $%.2f%n", cheeseSize.menuPrice));
            if (extraCheeseSize != null) {
                sb.append("\nExtra ").append(cheeseType.menuName).append(" Added")
                        .append("\nSize: ").append(extraCheeseSize.sizeName)
                        .append(String.format("\nPrice: $%.2f%n", extraCheeseSize.menuPrice));
            }
        }
        System.out.print(sb.toString());
        sb.setLength(0);

        return "";
    }
}
