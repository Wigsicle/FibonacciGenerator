import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public int[] readFile(String filePath) {
        List<Integer> sequenceList = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] numbers = data.split("\\s+");
                for (String number : numbers) {
                    sequenceList.add(Integer.parseInt(number));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Convert list to array
        int[] sequence = new int[sequenceList.size()];
        for (int i = 0; i < sequenceList.size(); i++) {
            sequence[i] = sequenceList.get(i);
        }
        return sequence;
    }
}
