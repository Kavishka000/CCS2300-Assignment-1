package Module1;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class representing each location in the tree
 */
class Node {
    String locationName;
    Node left, right;

    public Node(String name) {
        this.locationName = name;
        this.left = this.right = null;
    }
}

/**
 * Binary Search Tree to store locations before mapping to the Graph
 */
public class LocationTree {
    private Node root;

    // Method to insert a location name into the BST
    public void insert(String name) {
        root = insertRec(root, name);
    }

    private Node insertRec(Node root, String name) {
        if (root == null) {
            return new Node(name);
        }
        if (name.compareTo(root.locationName) < 0) {
            root.left = insertRec(root.left, name);
        } else if (name.compareTo(root.locationName) > 0) {
            root.right = insertRec(root.right, name);
        }
        return root;
    }

    // In-order traversal to retrieve all locations for graph mapping
    public List<String> getAllLocations() {
        List<String> locations = new ArrayList<>();
        inorder(root, locations);
        return locations;
    }

    private void inorder(Node root, List<String> locations) {
        if (root != null) {
            inorder(root.left, locations);
            locations.add(root.locationName);
            inorder(root.right, locations);
        }
    }
}