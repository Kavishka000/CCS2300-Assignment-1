package Module1;

public class BSTNode {
    String locationName;  // the name of the city/location
    BSTNode left;         // left child (alphabetically smaller)
    BSTNode right;        // right child (alphabetically larger)

    // Constructor
    public BSTNode(String locationName) {
        this.locationName = locationName;
        this.left = null;
        this.right = null;
    }
}
