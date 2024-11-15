package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PremiumTopping extends Topping implements Ingredient {
    private MeatType meatType;
    private MeatSize meatSize;
    private ExtraMeatSize extraMeatSize;
    private CheeseType cheeseType;
    private CheeseSize cheeseSize;
    private ExtraCheeseSize extraCheeseSize;
    private double premiumToppingsMenuPrice;
    private static StringBuilder sb = new StringBuilder();
    private static Scanner scanner = new Scanner(System.in);

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
            while (true) {
                System.out.println("Do you want Meat?\n1) Yes\n0) No\n");
                try {
                    input = scan.nextByte();
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("\033[31m" + "I'm sorry, " + "\033[0m");
                    scan.nextLine();
                    continue;
                }

                switch (input) {
                    case 0:
                        break;
                    case 1:
                        //premiumTopping = sizeAndTypeMenu("Meat", premiumTopping);
                        //FIXME Play around with having updatePrem outside or inside
                        // Probably should have it inside of size()
                        sizeAndTypeMenu("Meat", premiumTopping, "Normal");
                        //System.out.println(premiumTopping);
                        break;
                    default:
                        System.out.println("\033[31m" + "So..." + "\033[0m");
                        scan.nextLine();
                        continue;
                }
                break;
            }
            //END

            //EXPLAIN Cheese Options
            while (true) {
                System.out.println("Do you want Cheese?\n1) Yes\n0) No");
                //FIXME # Over not working >:(
                try {
                    input = scan.nextByte();
                } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("\033[31m" + "I'm sorry, " + "\033[0m");
                    scan.nextLine();
                    continue;
                }

                switch (input) {
                    case 0:
                        break;
                    case 1:
                        sizeAndTypeMenu("Cheese", premiumTopping, "Normal");
                        break;
                    default:
                        System.out.println("\033[31m" + "So..." + "\033[0m");
                        scan.nextLine();
                        continue;
                }
                break;
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
            System.out.println(premiumTopping.print("Print"));
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

    public static PremiumTopping sizeAndTypeMenu(String topping, PremiumTopping prem, String function) throws InterruptedException {
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
                        1) Steak
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
                    if (function.equalsIgnoreCase("Signature")) {
                        prem.setPremiumToppingsMenuPrice(meatSize.getMenuPrice());
                    } else {
                        prem.premiumToppingsMenuPrice += meatSize.getMenuPrice();
                    }
                }

                if (topping.equalsIgnoreCase("Cheese")) {
                    cheeseSize = CheeseSize.values()[sizeInput - 1];
                    prem.setCheeseSize(cheeseSize);
                    if (function.equalsIgnoreCase("Signature")) {
                        prem.setPremiumToppingsMenuPrice(cheeseSize.getMenuPrice());
                    } else {
                        prem.premiumToppingsMenuPrice += cheeseSize.getMenuPrice();
                    }
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
                        if (function.equalsIgnoreCase("Signature")) {
                            return prem;
                        }
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
                            //EXPLAIN More Validation for Extra topping ->
                            try {
                                extraInput = scanner.nextInt();
                                if (topping.equalsIgnoreCase("Meat")) {
                                    extraMeat = ExtraMeatSize.values()[extraInput - 1];
                                    prem.setExtraMeatSize(extraMeat);
                                    prem.premiumToppingsMenuPrice += extraMeat.getMenuPrice();
                                }

                                if (topping.equalsIgnoreCase("Cheese")) {
                                    extraCheese = ExtraCheeseSize.values()[extraInput - 1];
                                    prem.setExtraCheeseSize(extraCheese);
                                    prem.premiumToppingsMenuPrice += extraCheese.getMenuPrice();
                                }

                                if (function.equalsIgnoreCase("Signature")) {
                                    return prem;
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
    public String print(String function) {
        sb.setLength(0);

        if (function.equalsIgnoreCase("Receipt")) {
            sb.append("Premium Topping Details\n=======================\n");
            if (meatSize != null) {
                sb.append("\nMeat\n====")
                        .append("\n").append(meatType.getMenuName()).append(" Added")
                        .append("\nSize: ").append(meatSize.getSizeName())
                        .append(String.format("\nPrice: $%.2f%n", meatSize.getMenuPrice()));
                if (extraMeatSize != null) {
                    sb.append("\nExtra ").append(meatType.getMenuName()).append(" Added")
                            .append("\nSize: ").append(extraMeatSize.getSizeName())
                            .append(String.format("\nPrice: $%.2f%n", extraMeatSize.getMenuPrice()));
                }
            }

            if (cheeseSize != null) {
                sb.append("\nCheese\n======")
                .append("\n").append(cheeseType.getMenuName()).append(" Cheese Added")
                        .append("\nSize: ").append(cheeseSize.getSizeName())
                        .append(String.format("\nPrice: $%.2f%n", cheeseSize.getMenuPrice()));
                if (extraCheeseSize != null) {
                    sb.append("\nExtra ").append(cheeseType.getMenuName()).append(" Added")
                            .append("\nSize: ").append(extraCheeseSize.getSizeName())
                            .append(String.format("\nPrice: $%.2f%n", extraCheeseSize.getMenuPrice()));
                }
            }
            sb.append("\n");
            return sb.toString();
        }

        //EXPLAIN Most cases
        sb.append("\033[31m").append("Premium Topping Details")
                .append("\n=======================\n").append("\033[0m");
        if (meatSize != null) {
            sb.append("\033[31m").append("\nMeat\n====").append("\033[0m");
            sb.append("\n").append(meatType.getMenuName()).append(" Added")
                    .append("\nSize: ").append(meatSize.getSizeName())
                    .append("\033[32m").append(String.format("\nPrice: $%.2f%n", meatSize.getMenuPrice()))
                    .append("\033[0m");
            if (extraMeatSize != null) {
                sb.append("\nExtra ").append(meatType.getMenuName()).append(" Added")
                        .append("\nSize: ").append(extraMeatSize.getSizeName())
                        .append("\033[32m").append(String.format("\nPrice: $%.2f%n", extraMeatSize.getMenuPrice()))
                        .append("\033[0m");
            }
        }


        if (cheeseSize != null) {
            sb.append("\033[31m").append("\nCheese\n======").append("\033[0m");
            sb.append("\n").append(cheeseType.getMenuName()).append(" Cheese Added")
                    .append("\nSize: ").append(cheeseSize.getSizeName())
                    .append("\033[32m").append(String.format("\nPrice: $%.2f%n", cheeseSize.getMenuPrice())).append("\033[0m");
            if (extraCheeseSize != null) {
                sb.append("\nExtra ").append(cheeseType.getMenuName()).append(" Added")
                        .append("\nSize: ").append(extraCheeseSize.getSizeName())
                        .append("\033[32m").append(String.format("\nPrice: $%.2f%n", extraCheeseSize.getMenuPrice()))
                        .append("\033[0m");
            }
        }
        sb.append("\n");
        //sb.append(String.format("Subtotal: $%.2f%n", premiumToppingsMenuPrice));
        //System.out.print(sb.toString());
        //sb.setLength(0);
        return sb.toString();
    }
}
