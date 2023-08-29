import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int[] prices = new int[24];
        char userChoice;

        Scanner scanner = new Scanner(System.in);
        Electricity electricity = new Electricity();

        do {
            electricity.printMenuOptions();
            userChoice = scanner.next().charAt(0); // gets the first character

            switch (userChoice) {

                case '1':
                    electricity.enterPricePerHour(prices, scanner);
                    break;

                case '2':
                case '3':
                case '4':

                    // check if array holds values from alternative 1 before proceeding
                    if (electricity.isArrayFilled(prices)) {
                        switch (userChoice) {
                            case '2':
                                electricity.getLowestPrice(prices);
                                electricity.getHighestPrice(prices);
                                electricity.getAvergePrice(prices);
                                break;
                            case '3':
                                electricity.sortPrices(prices);
                                break;
                            case '4':
                                electricity.bestLoadingHours(prices);
                                break;
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Du måste ange priserna i alternativ 1 innan du går vidare till detta alternativ");
                    }
                    break;

                case '5':
                    ReadCSV readCSV = new ReadCSV();
                    ReadCSV csvFileData = readCSV;
                    csvFileData.displayCSVData();
                    break;
                case 'e':
                case 'E':
                    System.out.println("Avslutar programmet.");
                    break;
                default:
                    System.out.println("Inget giltigt alternative. Försök igen.");
                    break;
            }
        } while (userChoice != 'e' && userChoice != 'E');
    }
}