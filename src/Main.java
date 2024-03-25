public class Main {
    private static final String FILEPATH = "./fibonacci.txt";

    static String printFibonacci(int count) {
        int n1 = 0, n2 = 1, n3;
        StringBuilder fibonacciSequence = new StringBuilder(n1 + " " + n2);
        for (int i = 2; i < count; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            fibonacciSequence.append(" ").append(n3);
        }
        return fibonacciSequence.toString();
    }

    public static void main(String[] args) {
        int count = 1000;

        CreateFile cf = new CreateFile();
        WriteToFile wf = new WriteToFile();
        FibonacciChecker fc = new FibonacciChecker();

        // Create the file
        if (cf.createFile(FILEPATH)) {
            String fibonacciSequence = printFibonacci(count);
            if (fibonacciSequence != null) {
                // Write Fibonacci sequence to the file
                wf.writeFile(FILEPATH, fibonacciSequence);
                System.out.println("Fibonacci sequence successfully written to the file.");
            } else {
                System.out.println("\nFailed to generate Fibonacci Sequence");
            }
        } else {
            System.out.println("Failed to create file.");
        }

        boolean isCorrect = fc.isFibonacciSequence(FILEPATH);
        if (isCorrect) {
            System.out.println("The sequence in the file is a correct Fibonacci sequence.");
        } else {
            System.out.println("The sequence in the file is not a correct Fibonacci sequence.");
        }
    }
}
