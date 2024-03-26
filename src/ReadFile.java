import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class ReadFile {
    public BigInteger[] readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int count = 0;

        // Count the number of lines in the file
        while (reader.readLine() != null) {
            count++;
        }

        // Reset the reader to read from the beginning of the file
        reader.close();
        reader = new BufferedReader(new FileReader(filePath));

        // Skip the first line
        reader.readLine();

        BigInteger[] sequence = new BigInteger[count - 1]; // Subtract 1 to exclude the first line
        int index = 0;

        while ((line = reader.readLine()) != null) {
            sequence[index] = new BigInteger(line);
            index++;
        }

        reader.close();
        return sequence;
    }
}