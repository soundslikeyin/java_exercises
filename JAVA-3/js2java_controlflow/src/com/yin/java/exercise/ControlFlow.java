package com.yin.java.exercise;
import java.time.LocalDate;
import java.util.Scanner;

public class ControlFlow {


    public static void main(String[] args) {
        int yearDayNumber = getYearDayNumber(-1);
        int janFirstDayNumber = getJanFirstDayNumber();
        int dayNumber = getDayNumber(janFirstDayNumber, yearDayNumber);
        int hourNumber = getHourNumber(-1);

        isBusinessHour(dayNumber, hourNumber);
    }

    public static int getYearDayNumber(int yearDayNumber) {
        Scanner in = new Scanner(System.in);

        while (yearDayNumber < 0 || yearDayNumber > 365) {
            System.out.println("Enter year day number: ");
            String input = in.next();
            try {
                yearDayNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("You didn't enter a valid number.");
            }
        }
            return yearDayNumber;
    }

    public static int getHourNumber(int hourNumber) {
        Scanner in = new Scanner(System.in);

        while (hourNumber < 0 || hourNumber > 24) {
            System.out.println("Enter the hour: ");
            String input = in.next();

            try {
                hourNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("You didn't enter a valid number.");
            }
        }
        return hourNumber;
    }

    public static int getJanFirstDayNumber() {
        int currentYear = LocalDate.now().getYear();
        int janFirstDayNumber = LocalDate.of(currentYear, 01, 01).getDayOfWeek().getValue();

        return janFirstDayNumber;
    }

    public static int getDayNumber(int janFirstDayNumber, int yearDayNumber){
//        int currentYear = LocalDate.now().getYear();
//        int dayNumber = LocalDate.ofYearDay(currentYear, yearDayNumber+1).getDayOfWeek().getValue();

        return ((yearDayNumber + janFirstDayNumber % 7) % 7);
    }

    public static boolean isBusinessHour(int dayNumber, int hourNumber) {

        if ((dayNumber >= 1) && (dayNumber <= 5)) {
            System.out.print("It is a working day ");
            if ((hourNumber >= 9) && (hourNumber <= 18)) {
                System.out.print("and it is business hours!");
                return true;
            } else {
                System.out.println("but sorry, it is not office hours");
                return false;
            }
        } else {
            System.out.println("Sorry, it is not a working day");
            return false;
        }
    }



}

