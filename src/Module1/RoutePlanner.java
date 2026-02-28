package Module1;

import java.util.Scanner;

/**
 * Controller class for Module 1: Smart City Route Planner
 */
public class RoutePlanner {
    private static LocationTree tree = new LocationTree();
    private static RouteGraph graph = new RouteGraph();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\n--- Module 1: Smart City Route Planner ---");
            System.out.println("1. Add Location (to Tree)");
            System.out.println("2. Map Locations from Tree to Graph");
            System.out.println("3. Add Road between Locations");
            System.out.println("4. Display All Road Connections");
            System.out.println("5. Traverse Routes (BFS)");
            System.out.println("6. Return to Main Menu");
            System.out.print("Select an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Location Name: ");
                        tree.insert(scanner.nextLine());
                        break;
                    case 2:
                        // Transfers data from Tree structure to Graph structure
                        for (String loc : tree.getAllLocations()) {
                            graph.addLocation(loc);
                        }
                        System.out.println("Successfully mapped tree data to the graph.");
                        break;
                    case 3:
                        System.out.print("Enter Source Location: ");
                        String u = scanner.nextLine();
                        System.out.print("Enter Destination Location: ");
                        String v = scanner.nextLine();
                        graph.addRoad(u, v);
                        break;
                    case 4:
                        graph.displayConnections();
                        break;
                    case 5:
                        System.out.print("Enter starting location for traversal: ");
                        graph.bfs(scanner.nextLine());
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid input. Please choose 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a numeric choice.");
            }
        }
    }
}