import java.util.*;

/**
 * @author: Austin Snyder
 * This is a java code benchmark of selection sort
 */
public class SortingBenchmark {
    public static void main(String[] args) {

        //Set up all constants in the program
        final int arraySize = 1000;
        final int numArrays = 1000;
        final int min = 1;
        final int max = 1000;
        final int NUMBER_TRIALS = 100;

        //This will hold the time of each trial
        List<Long> times = new ArrayList<>();

        //Go through trials
        for(int numTrials = 0; numTrials < NUMBER_TRIALS; numTrials++) {

            //This will hold the arrays that are randomly generated
            List<int[]> arrays = new ArrayList<>();

            // Generate unique arrays
            for (int i = 0; i < numArrays; i++) {
                int[] array = generateUniqueArray(arraySize, min, max);
                arrays.add(array);
            }

            // Start the timer for this trial
            long startTime = System.currentTimeMillis();

            // BASIC OPERATION EXECUTION: SELECTION SORT ON ARRAY
            for (int[] array : arrays) {
                selectionSort(array);
            }

            // end the timer and calculate the time
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            times.add(duration);
        }

        //Sum the times
        long sum = 0;
        for(long time : times){
             sum += time;
        }

        //Calculate an average using double to keep decimal points.
        double average = (double)sum / NUMBER_TRIALS;
        System.out.println("Average time in ms: " + average);
    }

    // Generate unique array with random integers between min and max
    public static int[] generateUniqueArray(int size, int min, int max) {
        int[] array = new int[size];
        Set<Integer> set = new HashSet<>();

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(max - min + 1) + min;
            } while (set.contains(randomNumber));
            array[i] = randomNumber;
            set.add(randomNumber);
        }

        return array;
    }

    //Java implementation of Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first element of the unsorted part
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}



