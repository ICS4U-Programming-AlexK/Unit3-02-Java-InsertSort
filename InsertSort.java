import java.util.Random;
import java.util.Arrays;
import java.io.FileWriter;
/**
 * This program uses insertion sort to sort an array of random numbers.
 * @author Alex Kapajika
 * @version 1.0
 * @since 2025-04-14
 */
public final class InsertSort {
    /** Defining MAX_SIZE. */
    private static final int MAX_SIZE = 6;
    /** Defining MAX_VALUE. */
    private static final int MAX_VALUE = 100;
    /** Defining MAX_ARRAYS. */
    private static final int MAX_ARRAYS = 100;
    /**
     * This is to satisfy the style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private InsertSort() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * This is the main method.
     *
     * @param args Unused.
     * @throws Exception - IO Exception
     */
    public static void main(final String[] args) throws Exception {
        FileWriter inputFile = new FileWriter("input.txt");
        FileWriter outputFile = new FileWriter("output.txt");
        Random random = new Random();
        for (int counterArray = 0; counterArray < MAX_ARRAYS; counterArray++) {
            int[] numArray = new int[MAX_SIZE];
            for (int counter = 0; counter < MAX_SIZE; counter++) {
                int randomNum = random.nextInt(MAX_VALUE);
                numArray[counter] = randomNum;
            }
            inputFile.write("Array " + (counterArray + 1)
                    + " Unsorted: " + Arrays.toString(numArray) + "\n\n");
            insertSort(numArray);
            outputFile.write("Array " + (counterArray + 1)
                    + " Sorted:   " + Arrays.toString(numArray) + "\n\n");
        }
        inputFile.close();
        outputFile.close();
    }
    /**
     * This method sorts an array using the insertion sort algorithm.
     *
     * @param numArray The array to be sorted.
     */
    public static void insertSort(final int[] numArray) {
        // Loop through the array starting from the second element
        for (int counter = 1; counter < numArray.length; counter++) {
            int current = numArray[counter];
            int numSet = counter - 1;
            while (numSet >= 0 && numArray[numSet] > current) {
                numArray[numSet + 1] = numArray[numSet];
                numSet--;
            }
            numArray[numSet + 1] = current;
        }
    }
}
