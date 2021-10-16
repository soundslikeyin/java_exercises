package com.yin.java.exercise;
import java.util.Scanner;

public class CommissionCalculator {

    public static void main(String[] args) {
        float totalSales;
        int commissionPercentage;
        float totalCommission;

        totalSales = getTotalSales();
        commissionPercentage = commissionPercentCalculator(totalSales);
        totalCommission = commissionPercentage * totalSales / 100;

        if (totalCommission == 0) {
            System.out.println("You don't have to pay any commission");
        } else {
            System.out.println("You have to pay " + commissionPercentage + "% of your sales amount. I.e. $" + totalCommission);
        }
    }

    public static float getTotalSales () {
        float totalSales = 0;
        Scanner in = new Scanner(System.in);
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print("Enter the total sales figure: ");
            String input = in.next();
            try {
                totalSales = Float.parseFloat(input);
                inputValid = true;
            }  catch (NumberFormatException e) {
                System.out.println("You didn't enter a valid number.");
            }
        }
        return totalSales;
    }

    public static int commissionPercentCalculator (float totalSales) {

        if (totalSales >= 10000) {
            return 30;
        } else if (totalSales >= 5000) {
            return 20;
        } else if (totalSales >= 1000) {
            return 10;
        } else {
            return 0;
        }
    }


}

