package Module1;

public class Graph {
    private int maxSize;        // maximum number of locations
    private String[] locations; // stores location names by index
    private int[][] matrix;     // adjacency matrix (roads between locations)
    private int locationCount;  // current number of locations

    // Constructor
    public Graph(int maxSize) {
        this.maxSize = maxSize;
        this.locations = new String[maxSize];
        this.matrix = new int[maxSize][maxSize];
        this.locationCount = 0;
    }

    // ─── GET INDEX ────────────────────────────────────────
    // finds the index of a location by name
    public int getIndex(String locationName) {
        for (int i = 0; i < locationCount; i++) {
            if (locations[i].equalsIgnoreCase(locationName)) {
                return i;
            }
        }
        return -1; // not found
    }

    // ─── ADD LOCATION ─────────────────────────────────────
    public void addLocation(String locationName) {
        if (locationCount >= maxSize) {
            System.out.println("  [!] Graph is full. Cannot add more locations.");
            return;
        }
        if (getIndex(locationName) != -1) {
            System.out.println("  [!] Location '" + locationName + "' already exists in Graph.");
            return;
        }

        locations[locationCount] = locationName;
        locationCount++;
        System.out.println("  [✓] Location '" + locationName + "' added to Graph.");
    }

    // ─── REMOVE LOCATION ──────────────────────────────────
    public void removeLocation(String locationName) {
        int index = getIndex(locationName);

        if (index == -1) {
            System.out.println("  [!] Location '" + locationName + "' not found in Graph.");
            return;
        }

        // shift locations array to fill the gap
        for (int i = index; i < locationCount - 1; i++) {
            locations[i] = locations[i + 1];
        }
        locations[locationCount - 1] = null;

        // shift matrix rows up
        for (int i = index; i < locationCount - 1; i++) {
            for (int j = 0; j < locationCount; j++) {
                matrix[i][j] = matrix[i + 1][j];
            }
        }

        // shift matrix columns left
        for (int j = index; j < locationCount - 1; j++) {
            for (int i = 0; i < locationCount; i++) {
                matrix[i][j] = matrix[i][j + 1];
            }
        }

        // clear last row and column
        for (int i = 0; i < locationCount; i++) {
            matrix[locationCount - 1][i] = 0;
            matrix[i][locationCount - 1] = 0;
        }

        locationCount--;
        System.out.println("  [✓] Location '" + locationName + "' removed from Graph.");
    }

    // ─── ADD ROAD ─────────────────────────────────────────
    public void addRoad(String from, String to) {
        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);

        if (fromIndex == -1) {
            System.out.println("  [!] Location '" + from + "' not found.");
            return;
        }
        if (toIndex == -1) {
            System.out.println("  [!] Location '" + to + "' not found.");
            return;
        }
        if (fromIndex == toIndex) {
            System.out.println("  [!] Cannot add road from a location to itself.");
            return;
        }
        if (matrix[fromIndex][toIndex] == 1) {
            System.out.println("  [!] Road between '" + from + "' and '" + to + "' already exists.");
            return;
        }

        // undirected graph — road goes both ways
        matrix[fromIndex][toIndex] = 1;
        matrix[toIndex][fromIndex] = 1;
        System.out.println("  [✓] Road added between '" + from + "' and '" + to + "'.");
    }

    // ─── REMOVE ROAD ──────────────────────────────────────
    public void removeRoad(String from, String to) {
        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);

        if (fromIndex == -1) {
            System.out.println("  [!] Location '" + from + "' not found.");
            return;
        }
        if (toIndex == -1) {
            System.out.println("  [!] Location '" + to + "' not found.");
            return;
        }
        if (matrix[fromIndex][toIndex] == 0) {
            System.out.println("  [!] No road exists between '" + from + "' and '" + to + "'.");
            return;
        }

        matrix[fromIndex][toIndex] = 0;
        matrix[toIndex][fromIndex] = 0;
        System.out.println("  [✓] Road removed between '" + from + "' and '" + to + "'.");
    }

    // ─── DISPLAY CONNECTIONS ──────────────────────────────
    public void displayConnections() {
        if (locationCount == 0) {
            System.out.println("  [!] No locations in the graph.");
            return;
        }

        System.out.println("\n  ──── Graph Connections ────");
        for (int i = 0; i < locationCount; i++) {
            System.out.print("  " + locations[i] + " → ");
            boolean hasConnection = false;
            for (int j = 0; j < locationCount; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(locations[j] + "  ");
                    hasConnection = true;
                }
            }
            if (!hasConnection) {
                System.out.print("No connections");
            }
            System.out.println();
        }
        System.out.println("  ───────────────────────────");
    }

    // ─── DISPLAY MATRIX ───────────────────────────────────
    public void displayMatrix() {
        if (locationCount == 0) {
            System.out.println("  [!] No locations in the graph.");
            return;
        }

        System.out.println("\n  ──── Adjacency Matrix ────");
        System.out.print("         ");
        for (int i = 0; i < locationCount; i++) {
            System.out.printf("%-10s", locations[i]);
        }
        System.out.println();

        for (int i = 0; i < locationCount; i++) {
            System.out.printf("  %-8s", locations[i]);
            for (int j = 0; j < locationCount; j++) {
                System.out.printf("%-10d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("  ──────────────────────────");
    }

    // ─── GETTERS (used by Traversal.java) ─────────────────
    public int getLocationCount() { return locationCount; }
    public String getLocation(int index) { return locations[index]; }
    public int[][] getMatrix() { return matrix; }
}
