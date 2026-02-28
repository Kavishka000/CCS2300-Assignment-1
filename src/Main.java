import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============================================");
            System.out.println("       CCS2300 ASSIGNMENT MAIN MENU          ");
            System.out.println("=============================================");
            System.out.println("1. Module 1: Smart City Route Planner");
            System.out.println("2. Module 2: Data Sorter & Performance");
            System.out.println("3. Module 3: Algorithm Performance Analysis");
            System.out.println("4. Exit");
            System.out.print("Select a module to run: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        Module1.RoutePlanner.showMenu();
                        break;
                    case 2:
                        Module2.DataSorter.showMenu();
                        break;
                    case 3:
                        Module3.PerformanceAnalyzer.analyze();
                        break;
                    case 4:
                        System.out.println("Exiting Application. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a numeric value.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
