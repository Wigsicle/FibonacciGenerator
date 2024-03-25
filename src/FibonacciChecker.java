import java.io.IOException;

public class FibonacciChecker {

    public static boolean isFibonacciSequence(String filePath) {
        ReadFile reader = new ReadFile();
        try {
            // Read the sequence from the file
            int[] sequence = reader.readFile(filePath);

            if (sequence == null || sequence.length == 0) {
                System.out.println("Sequence is empty or could not be read from the file.");
                return false;
            }

            // Check if the sequence is a Fibonacci sequence
            return isFibonacci(sequence);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFibonacci(int[] sequence) {
        if (sequence.length < 3) {
            return false; // Fibonacci sequence should contain at least 3 numbers
        }

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] != sequence[i - 1] + sequence[i - 2]) {
                return false; // The current number is not the sum of the two preceding numbers
            }
        }

        return true; // All numbers in the sequence follow Fibonacci sequence rules
    }
}
