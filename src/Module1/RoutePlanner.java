package Module1;

import java.util.Scanner;

public class RoutePlanner {

    static BST bst = new BST();
    static Graph graph = new Graph(50); // max 50 locations
    static Traversal traversal = new Traversal(graph);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     Smart City Route Planner             ║");
        System.out.println("║     Module 1 - CCS2300 Assignment        ║");
        System.out.println("╚══════════════════════════════════════════╝");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("  Enter your choice: ");

            switch (choice) {
                case 1  -> addLocation();
                case 2  -> removeLocation();
                case 3  -> addRoad();
                case 4  -> removeRoad();
                case 5  -> displayConnections();
                case 6  -> displayMatrix();
                case 7  -> displayBSTLocations();
                case 8  -> bfsTraversal();
                case 9  -> dfsTraversal();
                case 10 -> findPath();
                case 0  -> {
                    System.out.println("\n  Exiting Smart City Route Planner. Goodbye!");
                    running = false;
                }
                default -> System.out.println("  [!] Invalid choice. Please try again.");
            }
        }
    }

    // ─── MENU ─────────────────────────────────────────────
    private static void printMenu() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║              MAIN MENU                   ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1. Add Location                         ║");
        System.out.println("║  2. Remove Location                      ║");
        System.out.println("║  3. Add Road                             ║");
        System.out.println("║  4. Remove Road                          ║");
        System.out.println("║  5. Display All Connections              ║");
        System.out.println("║  6. Display Adjacency Matrix             ║");
        System.out.println("║  7. Display BST Locations (A-Z)          ║");
        System.out.println("║  8. BFS Traversal (Queue)                ║");
        System.out.println("║  9. DFS Traversal (Stack)                ║");
        System.out.println("║  10. Find Path Between Two Locations     ║");
        System.out.println("║  0. Exit                                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    // ─── ADD LOCATION ─────────────────────────────────────
    private static void addLocation() {
        System.out.println("\n  ──── Add Location ────");
        String name = getStringInput("  Enter location name: ");

        // add to BST first, then to Graph
        bst.insert(name);
        graph.addLocation(name);
    }

    // ─── REMOVE LOCATION ──────────────────────────────────
    private static void removeLocation() {
        System.out.println("\n  ──── Remove Location ────");
        String name = getStringInput("  Enter location name to remove: ");

        // remove from both BST and Graph
        bst.delete(name);
        graph.removeLocation(name);
    }

    // ─── ADD ROAD ─────────────────────────────────────────
    private static void addRoad() {
        System.out.println("\n  ──── Add Road ────");
        String from = getStringInput("  Enter first location: ");
        String to   = getStringInput("  Enter second location: ");
        graph.addRoad(from, to);
    }

    // ─── REMOVE ROAD ──────────────────────────────────────
    private static void removeRoad() {
        System.out.println("\n  ──── Remove Road ────");
        String from = getStringInput("  Enter first location: ");
        String to   = getStringInput("  Enter second location: ");
        graph.removeRoad(from, to);
    }

    // ─── DISPLAY CONNECTIONS ──────────────────────────────
    private static void displayConnections() {
        graph.displayConnections();
    }

    // ─── DISPLAY MATRIX ───────────────────────────────────
    private static void displayMatrix() {
        graph.displayMatrix();
    }

    // ─── DISPLAY BST ──────────────────────────────────────
    private static void displayBSTLocations() {
        System.out.println("\n  ──── BST Locations (Alphabetical Order) ────");
        bst.inOrder();
    }

    // ─── BFS TRAVERSAL ────────────────────────────────────
    private static void bfsTraversal() {
        System.out.println("\n  ──── BFS Traversal ────");
        String start = getStringInput("  Enter starting location: ");
        traversal.bfs(start);
    }

    // ─── DFS TRAVERSAL ────────────────────────────────────
    private static void dfsTraversal() {
        System.out.println("\n  ──── DFS Traversal ────");
        String start = getStringInput("  Enter starting location: ");
        traversal.dfs(start);
    }

    // ─── FIND PATH ────────────────────────────────────────
    private static void findPath() {
        System.out.println("\n  ──── Find Path ────");
        String from = getStringInput("  Enter start location: ");
        String to   = getStringInput("  Enter end location: ");
        traversal.findPath(from, to);
    }

    // ─── INPUT HELPERS ────────────────────────────────────
    // gets a valid non-empty string from user
    private static String getStringInput(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("  [!] Input cannot be empty. Please try again.");
            }
        }
        return input.trim();
    }

    // gets a valid integer from user
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a number.");
            }
        }
    }
}
