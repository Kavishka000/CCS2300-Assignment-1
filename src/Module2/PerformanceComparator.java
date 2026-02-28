package Module2;

public class PerformanceComparator {
    public static void displayComparisonTable(String[] algorithms, long[] executionTimes) {
        System.out.println("\n=================================================");
        System.out.println("       ALGORITHM PERFORMANCE COMPARISON          ");
        System.out.println("=================================================");
        System.out.printf("%-20s | %-20s\n", "Algorithm Name", "Time (Nanoseconds)");
        System.out.println("-------------------------------------------------");
        
        for (int i = 0; i < algorithms.length; i++) {
            System.out.printf("%-20s | %-20d\n", algorithms[i], executionTimes[i]);
        }
        System.out.println("=================================================\n");
    }
}