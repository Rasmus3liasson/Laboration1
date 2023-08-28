package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Electricity {

    public void printMenuOptions() {
        System.out.println("");
        System.out.println("");
        System.out.println("Elpriser");
        System.out.println("========");
        System.out.println("1. Inmatning");
        System.out.println("2. Min, Max och Medel");
        System.out.println("3. Sortera");
        System.out.println("4. Bästa Laddningstid (4h)");
        System.out.println("e. Avsluta");
        System.out.print("Välj ett alternativ: ");
    }
    public void enterPricePerHour(int[] prices, Scanner scanner) {
        System.out.println("Ange priserna mellan timmarna i öre/kWh nedan " + "\u2193");
        for (int i = 0; i < 24; i++) {
            int startHour = i;
            int endHour = (i + 1) % 24;

            System.out.printf("Timme %02d-%02d: ", startHour, endHour); // printf for formatting hours
            prices[i] = scanner.nextInt();
        }
    }
    public boolean isArrayFilled(int [] array){
        for (int price : array) {
            if (price == 0) {
                return false;
            }
        }
        return true;

    }
    public void getLowestPrice(int [] array){
        int minValue = array[0];

        for (int price : array) {
            if (price < minValue)
                minValue = price;
        }

        System.out.println("Minsta Kostnaden: " + minValue + " öre/kWh");
    }
    public void getHighestPrice(int [] array){
        int maxValue = array[0];

        for (int price : array) {
            if (price > maxValue) {
                maxValue = price;
            }
        }

        System.out.println("Högsta Kostnaden: " + maxValue + " öre/kWh");
    }
    public void getAvergePrice(int [] array){

        int sumOfPrices = 0;
        for (int price : array) {
            sumOfPrices += price;
        }

        double averagePrice = (double) sumOfPrices / array.length;
        // format to 2 decimal
        DecimalFormat formatToTwoDecimal = new DecimalFormat("#.00");
        String averagePriceFormatted = formatToTwoDecimal.format(averagePrice);

        System.out.println("Medelvärde: " + averagePriceFormatted + " öre/kWh");
    }
}


