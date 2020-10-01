package com.viktorijakurauskiene;

public class SymmetricDate {
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear < 0 || toYear < 0) {
            throw new IllegalArgumentException("year cannot be negative");
        }
        if (fromYear >= toYear) {
            throw new IllegalArgumentException("fromYear cannot be more or equal to toYear");
        }

        for (int year = fromYear; year < toYear; year++) {
            int month = reverse(year % 100);
            int day = reverse(year / 100);
            if (isValidDate(year, month, day)) {
                System.out.printf("%04d-%02d-%02d\n", year, month, day);
            }
        }
    }

    private static int reverse(int number) {
        return number % 10 * 10 + number / 10;
    }

    private static boolean isValidDate(int year, int month, int day) {
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return false;
        } else if (day <= 28) {
            return true;
        } else {
            int maxDays = 31;
            switch (month) {
                case 2:
                    maxDays = isLeapYear(year) ? 29 : 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    maxDays = 30;
            }
            return day <= maxDays;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 == 0) || (year % 400 == 0);
    }
}
