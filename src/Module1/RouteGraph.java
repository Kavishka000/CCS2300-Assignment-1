package Module1;

import java.util.*;

/**
 * Graph implementation using an Adjacency List for road management
 */
public class RouteGraph {
    private Map<String, List<String>> adjList;

    public RouteGraph() {
        this.adjList = new HashMap<>();
    }

    // Adds a location as a vertex in the graph
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    // Removes a location and all its associated roads
    public void removeLocation(String location) {
        adjList.values().forEach(list -> list.remove(location));
        adjList.remove(location);
    }

    // Adds a road (edge) between two locations
    public void addRoad(String u, String v) {
        if (adjList.containsKey(u) && adjList.containsKey(v)) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Assuming roads are bidirectional
        }
    }

    // Displays all existing connections in the city
    public void displayConnections() {
        System.out.println("\n--- City Road Map (Adjacency List) ---");
        for (String loc : adjList.keySet()) {
            System.out.println(loc + " is connected to: " + adjList.get(loc));
        }
    }

    /**
     * Traversal using a Queue (Breadth-First Search) to list routes
     */
    public void bfs(String startNode) {
        if (!adjList.containsKey(startNode)) {
            System.out.println("Location not found in system.");
            return;
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        System.out.print("Route Traversal Sequence (BFS): ");
        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");
            for (String neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}