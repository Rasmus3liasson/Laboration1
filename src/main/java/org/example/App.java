package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int[] prices = new int[24];
        int[] testArr = {8, 5, 6, 7, 8};
        char userChoice;

        Scanner scanner = new Scanner(System.in);
        Electricity electricity = new Electricity();

        do {
            electricity.printMenuOptions();
            userChoice = scanner.next().charAt(0); // gets the first character
            Arrays.stream(prices).sorted();


            switch (userChoice) {
                case '1':
                    electricity.enterPricePerHour(prices, scanner);
                    break;
                case '2':
                    // check if array holds values from alternative 1 before proceeding
                    if (electricity.isArrayFilled(prices)) {
                        electricity.getLowestPrice(prices);
                        electricity.getHighestPrice(prices);
                        electricity.getAvergePrice(prices);
                    } else {
                        System.out.println("Du måste ange priserna i alternativ 1 innan du går vidare till detta alternativ");
                    }
                    break;
                case '3':
                    // check if array holds values from alternative 1 before proceeding
                    if (electricity.isArrayFilled(prices)) {
                     electricity.sortPrices(prices);

                    } else {
                        System.out.println("Du måste ange priserna i alternativ 1 innan du går vidare till detta alternativ");
                    }
                    break;
                case '4':
                    System.out.println("Alternativ " + userChoice);
                    break;
                case 'e':
                case 'E':
                    System.out.println("Avslutar programmet.");
                    break;
                default:
                    System.out.println("Inget giltigt val. Försök igen.");
                    break;
            }
        } while (userChoice != 'e' && userChoice != 'E');
    }
}