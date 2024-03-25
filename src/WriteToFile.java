import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
    public void writeFile(String filePath, String fileContents) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(fileContents);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
