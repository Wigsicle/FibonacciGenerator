import java.io.IOException;

public class Main {
    private static final String FILEPATH = "./fibonacci.txt";

    static String printFibonacci(int count) {
        int n1 = 0, n2 = 1, n3;
        StringBuilder fibonacciSequence = new StringBuilder(1001 + "\n" + n1 + "\n" + n2);
        for (int i = 2; i < count; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            fibonacciSequence.append("\n").append(n3);
        }
        return fibonacciSequence.toString();
    }

    public static void main(String[] args) {
        int count = 1000;

        CreateFile cf = new CreateFile();
        if (cf.createFile(FILEPATH)) {
            String fibonacciSequence = printFibonacci(count);
            if (fibonacciSequence != null) {
                WriteToFile wf = new WriteToFile();
                try {
                    wf.writeFile(FILEPATH, fibonacciSequence);
                    System.out.println("Fibonacci sequence successfully written to the file.");
                } catch (IOException e) {
                    System.out.println("Failed to write Fibonacci sequence to the file.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("\nFailed to generate Fibonacci Sequence");
            }
        } else {
            System.out.println("Failed to create file.");
        }

        boolean isCorrect = FibonacciChecker.isFibonacciSequence(FILEPATH);
        if (isCorrect) {
            System.out.println("The sequence in the file is a correct Fibonacci sequence.");
        } else {
            System.out.println("The sequence in the file is not a correct Fibonacci sequence.");
        }
    }
}