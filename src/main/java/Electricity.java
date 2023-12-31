import java.text.DecimalFormat;
import java.util.Arrays;
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
        System.out.println("5. Visa generella priser mellan olika timmar");
        System.out.println("e. Avsluta");
        System.out.print("\nVälj ett alternativ: ");
    }

    public void enterPricePerHour(int[] prices, Scanner scanner) {
        System.out.println("\nAnge priserna mellan timmarna i öre/kWh nedan " + "\u2193");
        for (int i = 0; i < 24; i++) {
            int startHour = i;
            int endHour = (i + 1) % 24;

            System.out.printf("Timme %02d-%02d: ", startHour, endHour); // printf for formatting hours
            prices[i] = scanner.nextInt();
        }
    }

    public boolean isArrayFilled(int[] array) {
        for (int price : array) {
            if (price == 0) {
                return false;
            }
        }
        return true;

    }

    public void getLowestPrice(int[] array) {
        int minValue = array[0];

        for (int price : array) {
            if (price < minValue)
                minValue = price;
        }

        System.out.println("Minsta Kostnaden: " + minValue + " öre/kWh");

        int hour = 0;
        for (int price : array) {
            if (price == minValue) {
                int endHour = (hour + 1) % 24;

                // inside loop if they are same price on more the one occasion
                System.out.println(String.format("under %02d-%02d", hour, endHour));
            }
            hour++;
        }
    }

    public void getHighestPrice(int[] array) {
        int maxValue = array[0];

        for (int price : array) {
            if (price > maxValue) {
                maxValue = price;
            }
        }

        System.out.println("Högsta Kostnaden: " + maxValue + " öre/kWh");

        int hour = 0;
        for (int price : array) {
            if (price == maxValue) {
                int endHour = (hour + 1) % 24;

                // inside loop if they are same price on more the one occasion
                System.out.println(String.format("under %02d-%02d", hour, endHour));
            }
            hour++;
        }
    }

    public void getAveragePrice(int[] array) {

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

    public void sortPrices(int[] prices) {
        HourAndPrice[] hourPriceCombined = new HourAndPrice[prices.length];

        for (int i = 0; i < prices.length; i++) {
            hourPriceCombined[i] = new HourAndPrice(i, prices[i]);
        }


        Arrays.sort(hourPriceCombined); // Sort prices with the compareTo method

        System.out.println("Sorterad ordning baserat på öre/kWh:");
        for (HourAndPrice pair : hourPriceCombined) {
            // %24 to ensure coverts to 00
            System.out.println(String.format("%02d-%02d  %d öre/kWh", pair.hour, (pair.hour + 1) % 24, pair.price));

        }

    }


    public void bestLoadingHours(int[] array) {
        int startHour = 0;
        double averagePrice = Double.MAX_VALUE;

        for (int i = 0; i <= array.length - 4; i++) { // (-4) to make sure there will always be 4 hours
            double totalPrice = array[i] + array[i + 1] + array[i + 2] + array[i + 3];
            double calculatedAveragePrice = totalPrice / 4;

            if (calculatedAveragePrice < averagePrice) {
                startHour = i;
                averagePrice = calculatedAveragePrice;
            }
        }

        System.out.println("Bästa laddningstid under 4h är:");
        System.out.println(String.format("Börja ladda kl %02d-%02d för att få lägst totalpris.", startHour, startHour + 4));
        System.out.println(String.format("Genomsnitts kostnad per timme kommer att bli : %.2f öre/kWh", averagePrice));
    }

}


