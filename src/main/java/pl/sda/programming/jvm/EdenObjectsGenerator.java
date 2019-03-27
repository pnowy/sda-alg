package pl.sda.programming.jvm;

public class EdenObjectsGenerator {
    private void createArrays() {
        int arraySize = 50000;

        // Create arrays in an infinite loop
        while (true) {
            System.out.println("Available memory (in bytes): " + CheckJavaMemory.humanReadableByteCount(Runtime.getRuntime().freeMemory()));
            int[] fillMemory = new int[arraySize];
        }
    }

    public static void main(String[] args) throws Exception {
        EdenObjectsGenerator leakGenerator = new EdenObjectsGenerator();
        leakGenerator.createArrays();
    }
}