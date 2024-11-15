package com.pluarlsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeMenu {
    static Scanner scan = new Scanner(System.in);

    static StringBuilder homeSB = new StringBuilder();

    public static void homeMenu() {
        byte homeInput = -1;
        homeSB.append("\033[32m").append("Welcome to Delicious Sandwiches!").append("\033[0m");
        System.out.println(homeSB.toString());
        homeSB.setLength(0);
        while (true) {
            System.out.println("""
                    What would you like to do?
                     1) New Order
                     0) Exit - exit the application""");
            try {
                homeInput = scan.nextByte();
                switch (homeInput) {
                    case 0:
                        homeSB.append("\033[92m")
                                .append("Thank you for visiting Delicious Sandwiches! Have a great day! :D")
                                .append("\033[0m");
                        System.out.println(homeSB.toString());
                        homeSB.setLength(0);
                        System.out.println("                                                                                \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@%########%@@@@#**#@*#%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@%##*#%@@@@%@@@%#:.:-+%@@%#*=::+**@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@@@@@@@%%##*+*##%@@@@+++=..-*-.          ..=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@@@@@%#*****#+:  .:--:.     .=-.          -#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@@@%******##.                .::        .:+%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@@%********-                 ::.      :-+*#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@%#******#+.                .=:   :=*#**#*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@@@%******#+=++=--:.       :-=#%#+=********#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @@@%%#**********####****+++***###***********%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " @#**********=+******#########***#*********#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " ***********+-+*****************#**********#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " ***********+++***************##**************#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " ********************************************+**#%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " ************************###************++*****##**%@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " *********************###********************##**#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " **********************************+++***###***###*%@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                " ***********************************##%##***##*****%@@@@@@@@@@@@@@%#%@@@@@@@@@@ \n" +
                                " **********++++****+*****++**###******###*#***##%%@@@@@@@@@@@@@%%@*#%@@@@@@@@@@ \n" +
                                " ***************#########%%#******###******#%##*#@@@@@@@@@@@@@*##%%%##@@@@@@@@@ \n" +
                                " **********###***####*****###*###*******###****#%@@@@@@@@@@@%*#%##@#**%@@@@@@@@ \n" +
                                " ************#########%##*******######*******#%@@@@@@@@@@@@#**@##%%*#@%#%@@@@@@ \n" +
                                " *********#***########*****####************#%@@@@@@@@@@@@@**#%**%%*%%%@%@@@@@@@ \n" +
                                " **********##**#####*#####****************#%@@@@@@@@@@%@%#*###*%%**%##@%@@@@@@@ \n" +
                                " ***********#%*****#%#******************#%@@@@@@@@@@@@*%#+*%#*#%#*#%##@##@@@@@@ \n" +
                                " *************#####*******************#%@@@@@@@@@@@@@@*%%**##*@#**%#*#@**#@@@@@ \n" +
                                " ******************+***************##%@@@@@@@@@@@@@@@@*%#*%#**@#*#@#**%#**#@@@@ \n" +
                                " ***************++***************%@@@@@@@@@@@@@@@@@@@@##**@#**%**#@**#%%#**@@@@ \n" +
                                " ********++*******+**********#%@@@@@@@@@@@@@@@@@@@@@%#%**##***#**##**#%%#*#@@@@ \n" +
                                " ****************+****#%%@@@@@@@@@@@@@@@@@@@@@@@@@@@%***************#%##*#%@@@@ \n" +
                                " %%#***********##%%%%@@@@@@@@@@@@@@@@@@@%%%@@@@@@@@@%***************#@@#*#@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@##%@@@@@@@%***************#%***#@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#**%@@@@@%*++**********+*#%***#@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#**#%@@@#*************+*#%***#@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#*****%%#*************+*#%***#@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*++**%#***************##***#@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#**+*%#**************%#***#%@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#***%%**************%#***%@@@@@@ \n" +
                                " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n" +
                                "                                                                                \n");
                        scan.close();
                        return;
                    case 1:
                        orderMenu();
                        break;
                    default:
                        homeSB.append("\033[31m").append("Sorry! I didn't quite catch that!\n").append("\033[0m");
                        System.out.println(homeSB.toString());
                        homeSB.setLength(0);
                        continue;
                }
                if (homeInput == 1) {
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("What did you say???\n");
                scan.nextLine();
            }
        }
    }

    public static void orderMenu() {
        while (true) {
            homeSB.append("\033[34m").append("Order Menu\n===========================================")
                    .append("\033[0m");
            System.out.println(homeSB.toString());
            homeSB.setLength(0);
            System.out.print("""
                    Select one of the following to get started!
                    o 1) Add Sandwich
                    o 2) Add Drink
                    o 3) Add Chips
                    o 4) Signature Sandwich
                    o 5) Checkout
                    o 0) Cancel Order
                    """);
            homeSB.append("\033[34m").append("===========================================")
                    .append("\033[0m");
            System.out.println(homeSB.toString());
            homeSB.setLength(0);
            try {
                byte orderInput = scan.nextByte();
                switch (orderInput) {
                    case 0:
                        System.err.print("Cancelling order");
                        System.err.print(".");
                        Thread.sleep(800);
                        System.err.print(".");
                        Thread.sleep(800);
                        System.err.print(".");
                        Thread.sleep(800);
                        Order.ordersMap.clear();
                        System.out.println("\n");
                        return;
                    case 1:
                        //EXPLAIN Sandwich Menu
                        Bread.sandwichMenu("Normal");
                        break;
                    case 2:
                        OtherProduct.addDrink();
                        break;
                    case 3:
                        OtherProduct.addChips();
                        break;
                    case 4:
                        SignatureSandwich.signatureSandwichMenu();
                        break;
                    case 5:
                        checkout();
                        break;
                    default:
                        System.out.print("Sorry! That's not on the menu!\nLets have a look at the ");
                        continue;
                }
                if (orderInput >= 1 && orderInput <= 5) {
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.print("What did you say???\nDid you want to look at the ");
                scan.nextLine();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void checkout() {
        homeSB.setLength(0);
        homeSB.append("\033[36m").append("\nCheckout Menu!\n==============\n")
                .append("\033[0m")
                .append("Let's go over your order");
        System.out.println(homeSB.toString());
        homeSB.setLength(0);
        Order.formatReceipt("Print");
        homeSB.append("\033[36m").append("\nReady to Checkout?\n\n").append("\033[0m")
                .append("\033[32m").append("1) Sure am!\n").append("\033[0m")
                .append("\033[31m").append("0) Hold on! I forgot something!").append("\033[0m");
        System.out.println(homeSB.toString());
        homeSB.setLength(0);
        byte checkoutInput = scan.nextByte();
        switch (checkoutInput) {
            case 0:
                break;
            case 1:
                homeSB.append("\033[92m").append("Thank You For Shopping at Delicious Sandwiches! :D\n\n")
                        .append("Here is a copy of you receipt!\n").append("\033[0m");
                Order.writeReceipt();
                homeSB.append("\033[32m").append("Is there anything else I can help you with?").append("\033[0m");
                System.out.println(homeSB.toString());
                homeSB.setLength(0);
                Order.ordersMap.clear();
                break;
        }
    }
}
