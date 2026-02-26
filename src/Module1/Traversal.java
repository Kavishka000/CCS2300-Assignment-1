package Module1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    private Graph graph;

    // Constructor
    public Traversal(Graph graph) {
        this.graph = graph;
    }

    // ─── BFS TRAVERSAL (Using Queue) ──────────────────────
    // Visits all locations level by level from a starting point
    public void bfs(String startLocation) {
        int startIndex = graph.getIndex(startLocation);

        if (startIndex == -1) {
            System.out.println("  [!] Location '" + startLocation + "' not found.");
            return;
        }

        boolean[] visited = new boolean[graph.getLocationCount()];
        Queue<Integer> queue = new LinkedList<>();

        // start from the given location
        visited[startIndex] = true;
        queue.add(startIndex);

        System.out.println("\n  ──── BFS Traversal from '" + startLocation + "' ────");
        System.out.print("  Route: ");

        while (!queue.isEmpty()) {
            int current = queue.poll(); // remove front of queue
            System.out.print(graph.getLocation(current) + "  ");

            // check all neighbors in matrix
            int[][] matrix = graph.getMatrix();
            for (int i = 0; i < graph.getLocationCount(); i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
        System.out.println("  ─────────────────────────────────────────");
    }

    // ─── DFS TRAVERSAL (Using Stack) ──────────────────────
    // Visits locations by going as deep as possible first
    public void dfs(String startLocation) {
        int startIndex = graph.getIndex(startLocation);

        if (startIndex == -1) {
            System.out.println("  [!] Location '" + startLocation + "' not found.");
            return;
        }

        boolean[] visited = new boolean[graph.getLocationCount()];
        Stack<Integer> stack = new Stack<>();

        // start from the given location
        stack.push(startIndex);

        System.out.println("\n  ──── DFS Traversal from '" + startLocation + "' ────");
        System.out.print("  Route: ");

        while (!stack.isEmpty()) {
            int current = stack.pop(); // remove top of stack

            if (!visited[current]) {
                visited[current] = true;
                System.out.print(graph.getLocation(current) + "  ");

                // push neighbors onto stack (in reverse for correct order)
                int[][] matrix = graph.getMatrix();
                for (int i = graph.getLocationCount() - 1; i >= 0; i--) {
                    if (matrix[current][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println();
        System.out.println("  ─────────────────────────────────────────");
    }

    // ─── FIND PATH BETWEEN TWO LOCATIONS (Using Queue) ────
    // Checks if a path exists between two locations
    public void findPath(String startLocation, String endLocation) {
        int startIndex = graph.getIndex(startLocation);
        int endIndex = graph.getIndex(endLocation);

        if (startIndex == -1) {
            System.out.println("  [!] Location '" + startLocation + "' not found.");
            return;
        }
        if (endIndex == -1) {
            System.out.println("  [!] Location '" + endLocation + "' not found.");
            return;
        }

        boolean[] visited = new boolean[graph.getLocationCount()];
        int[] previous = new int[graph.getLocationCount()];
        Queue<Integer> queue = new LinkedList<>();

        // initialize previous array with -1
        for (int i = 0; i < graph.getLocationCount(); i++) {
            previous[i] = -1;
        }

        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == endIndex) break; // reached destination

            int[][] matrix = graph.getMatrix();
            for (int i = 0; i < graph.getLocationCount(); i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    previous[i] = current; // remember how we got here
                    queue.add(i);
                }
            }
        }

        // check if path was found
        if (!visited[endIndex]) {
            System.out.println("  [!] No path found between '"
                + startLocation + "' and '" + endLocation + "'.");
            return;
        }

        // reconstruct path using previous array
        Stack<String> path = new Stack<>();
        int current = endIndex;

        while (current != -1) {
            path.push(graph.getLocation(current));
            current = previous[current];
        }

        System.out.println("\n  ──── Path from '" + startLocation
            + "' to '" + endLocation + "' ────");
        System.out.print("  Path: ");
        while (!path.isEmpty()) {
            System.out.print(path.pop());
            if (!path.isEmpty()) System.out.print(" → ");
        }
        System.out.println();
        System.out.println("  ──────────────────────────────────────────────");
    }
}
