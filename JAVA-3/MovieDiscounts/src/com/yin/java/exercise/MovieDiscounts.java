package com.yin.java.exercise;
import java.util.Scanner;

    public class MovieDiscounts {
            public static final int ticketPrice = 7;
            public static final Scanner in = new Scanner(System.in);


        public static void main(String[] args) {
            int age = getAge();
            int ticketQuantity = getTicketQuantity();
            int ticketSales = ticketQuantity * ticketPrice;

            // assuming that age discount is applied to all the tickets purchased by person with the discount
            int ageDiscountPercentage = ageDiscountCalculator(age);
            float ageDiscountTotal = ( ((float)ageDiscountPercentage / 100) * ticketSales);

            // assuming that quantity discount is applied after age discount
            int quantityDiscountPercentage = quantityDiscountCalculator(ticketQuantity);
            float quantityDiscountTotal = ( ((float)quantityDiscountPercentage / 100) * (ticketSales-ageDiscountTotal));

            float totalDiscountAmount = ageDiscountTotal + quantityDiscountTotal;
            System.out.printf("You have saved $%.2f\nThe net payable amount after discounts is: $%.2f",
                    totalDiscountAmount, ticketSales - totalDiscountAmount);
        }

        public static int getAge () {
            int age = 0;
            boolean inputValid = false;

            while (!inputValid) {
                System.out.print("Enter your age: ");
                String input = in.next();
                try {
                    age = Integer.parseInt(input);
                    inputValid = true;
                }  catch (NumberFormatException e) {
                    System.out.println("You didn't enter a valid number.");
                }
            }
            return age;
        }

        public static int getTicketQuantity () {
            int ticketQuantity = 0;
            boolean inputValid = false;

            while (!inputValid) {
                System.out.print("Enter the number of tickets you wish to purchase: ");
                String input = in.next();
                try {
                    ticketQuantity = Integer.parseInt(input);
                    inputValid = true;
                }  catch (NumberFormatException e) {
                    System.out.println("You didn't enter a valid number.");
                }
            }
            return ticketQuantity;

        }

        public static int ageDiscountCalculator (int age) {

            if (age > 60) {
                System.out.println("You are entitled to a 55% discount");
                return 55;
            } else if (age < 5) {
                System.out.println("You are entitled to a 60% discount");
                return 60;
            } else {
                return 0;
            }
        }

        public static int quantityDiscountCalculator (int quantity) {

            if (quantity >= 2) {
                System.out.println("You are entitled to an additional 30% discount for your bulk purchase");
                return 30;
            } else {
                return 0;
            }
        }

    }

