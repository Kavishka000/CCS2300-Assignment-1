package module3;

import java.util.Random;

public class PerformanceAnalyzer {

    public static void analyze() {

        int[] sizes = {100, 500, 1000};

        System.out.println("----------------------------------------------");
        System.out.println("Size\tSort Time(ns)\tSearch Time(ns)");
        System.out.println("----------------------------------------------");

        for (int size : sizes) {

            int[] arr = generateRandomArray(size);

            // Measure sorting time
            long startSort = System.nanoTime();
            SortForAnalysis.quickSort(arr, 0, arr.length - 1);
            long endSort = System.nanoTime();
            long sortTime = endSort - startSort;

            // Pick middle element as search key
            int key = arr[size / 2];

            // Measure search time
            long startSearch = System.nanoTime();
            SearchAlgorithms.binarySearch(arr, key);
            long endSearch = System.nanoTime();
            long searchTime = endSearch - startSearch;

            System.out.println(size + "\t" + sortTime + "\t\t" + searchTime);
        }

        System.out.println("----------------------------------------------");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }

        return arr;
    }
}