import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    private static String filePath = "csv/priser.csv";

    public List<HourAndPrice> getCSVData() {

        List<HourAndPrice> csvDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String data;

            while ((data = br.readLine()) != null) {
                String[] fileData = data.split(",");

                int hour = Integer.parseInt(fileData[0].split("-")[0]); // converting to int
                int price = Integer.parseInt(fileData[1].trim()); // converting to int
                csvDataList.add(new HourAndPrice(hour, price));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return csvDataList;
    }

    public void displayCSVData() {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String data;

            System.out.println("");
            while ((data = br.readLine()) != null) {
                String[] fileData = data.split(",");
                String hour = fileData[0];
                String price = fileData[1];

                System.out.println("\nKlockslag: " + hour + ", \nkostnad: " + price + " öre/kWh");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
