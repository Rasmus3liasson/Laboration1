import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    public void displayCSVData() {
        String filePath = "csv/priser.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("");
            while ((line = br.readLine()) != null) {
                String[] fileData = line.split(",");
                String hour = fileData[0];
                String price = fileData[1];

                System.out.println("Klockslag: " + hour + ", kostnad: " + price + " öre/kWh");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
