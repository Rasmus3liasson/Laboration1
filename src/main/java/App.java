import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int[] prices = new int[24];
        char userChoice;
        boolean isUserData = false;

        Scanner scanner = new Scanner(System.in);
        Electricity electricity = new Electricity();

        ReadCSV readCSV = new ReadCSV();
        List<HourAndPrice> csvData = readCSV.getCSVData();

        //sets prices array to csv data if user haven't entered own data
        if (!electricity.isArrayFilled(prices)) {
            for (HourAndPrice price : csvData) {
                prices[price.getHour()] = price.getPrice();
            }
        }

        do {
            electricity.printMenuOptions();
            userChoice = scanner.next().charAt(0); // gets the first character

            switch (userChoice) {

                case '1':
                    electricity.enterPricePerHour(prices, scanner);
                    isUserData=true;
                    break;

                case '2':
                case '3':
                case '4':


                    if (electricity.isArrayFilled(prices)) {

                        // check if array holds values from alternative 1 or the csv data

                        System.out.println(!isUserData ? "\nDenna data kommer från CSV-filen." : "");
                        switch (userChoice) {
                            case '2':
                                electricity.getLowestPrice(prices);
                                electricity.getHighestPrice(prices);
                                electricity.getAveragePrice(prices);
                                break;
                            case '3':
                                electricity.sortPrices(prices);
                                break;
                            case '4':
                                electricity.bestLoadingHours(prices);
                                break;
                        }
                    }
                    break;

                case '5':
                    readCSV.displayCSVData();
                    break;
                case 'e':
                case 'E':

                    System.out.println("\nAvslutar programmet.");
                    break;
                default:
                    System.out.println("\nInget giltigt alternativ. Försök igen.");
                    break;
            }
        } while (userChoice != 'e' && userChoice != 'E');
    }
}