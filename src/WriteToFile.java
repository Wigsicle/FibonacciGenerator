import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writeFile(String filePath, String fileContents) throws IOException {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(fileContents);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            throw new IOException("Error writing to file");
        }
    }
}