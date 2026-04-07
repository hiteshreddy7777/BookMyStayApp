import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FilePersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean dataFound = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String roomType = parts[0].trim();
                    int count = Integer.parseInt(parts[1].trim());
                    inventory.updateAvailability(roomType, count);
                    dataFound = true;
                }
            }
            if (!dataFound) {
                System.out.println("No valid inventory data found. Starting fresh.");
            }
        } catch (IOException e) {
            System.out.println("No valid inventory data found. Starting fresh.");
        }
    }
}