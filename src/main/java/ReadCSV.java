import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {


    private static List<HourAndPrice> readCSVFile() {
        String filePath = "csv/priser.csv";

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

    public List<HourAndPrice> getCSVData() {
        return readCSVFile();

    }

    public void displayCSVData() {
        List<HourAndPrice> csvData = readCSVFile();

        for (HourAndPrice data : csvData) {
            int startHour = data.getHour();
            int endHour = (startHour + 1) % 24;

            System.out.println("\nKlockslag: " + formatTime(startHour, endHour) + "\nKostnad: " + data.getPrice() + " öre/kWh");
        }
    }

    private String formatTime(int startHour, int endHour) {
        if (startHour == 23 && endHour == 0) {
            return "23-00";
        }

        String addedZeroToStartHour = (startHour < 10) ? "0" + startHour : String.valueOf(startHour);
        String addedZeroToEndHour = (endHour < 10) ? "0" + endHour : String.valueOf(endHour);

        return addedZeroToStartHour + "-" + addedZeroToEndHour;

    }
}