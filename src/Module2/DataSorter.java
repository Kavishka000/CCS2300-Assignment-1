package Module2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataSorter {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\n[Module 2: Data Sorter]");
        System.out.println("1. Manual Input");
        System.out.println("2. Random Dataset Generation");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();

        int[] data;
        if (choice == 1) {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();
            data = new int[n];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) data[i] = scanner.nextInt();
        } else {
            System.out.print("Enter dataset size: ");
            int n = scanner.nextInt();
            data = new Random().ints(n, 1, 1000).toArray();
        }

        runComparison(data);
    }

    private static void runComparison(int[] data) {
        String[] algos = {"Bubble Sort", "Merge Sort", "Quick Sort"};
        long[] times = new long[3];

        // Bubble Sort
        int[] bData = Arrays.copyOf(data, data.length);
        long start = System.nanoTime();
        BubbleSort.sort(bData);
        times[0] = System.nanoTime() - start;

        // Merge Sort
        int[] mData = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        MergeSort.sort(mData, 0, mData.length - 1);
        times[1] = System.nanoTime() - start;

        // Quick Sort
        int[] qData = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        QuickSort.sort(qData, 0, qData.length - 1);
        times[2] = System.nanoTime() - start;

        System.out.println("\nSorted Output: " + Arrays.toString(qData));
        PerformanceUtils.printTable(algos, times);
    }
}