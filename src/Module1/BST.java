package Module1;

public class BST {
    BSTNode root;  // the top node of the tree

    // Constructor
    public BST() {
        this.root = null;
    }

    // ─── INSERT ───────────────────────────────────────────
    public void insert(String locationName) {
        root = insertRec(root, locationName);
    }

    private BSTNode insertRec(BSTNode node, String locationName) {
        // if tree is empty or reached a null spot, create new node
        if (node == null) {
            return new BSTNode(locationName);
        }

        int compare = locationName.compareToIgnoreCase(node.locationName);

        if (compare < 0) {
            // locationName comes before current node → go left
            node.left = insertRec(node.left, locationName);
        } else if (compare > 0) {
            // locationName comes after current node → go right
            node.right = insertRec(node.right, locationName);
        } else {
            // locationName already exists in tree
            System.out.println("  [!] Location '" + locationName + "' already exists in BST.");
        }

        return node;
    }

    // ─── SEARCH ───────────────────────────────────────────
    public boolean search(String locationName) {
        return searchRec(root, locationName);
    }

    private boolean searchRec(BSTNode node, String locationName) {
        if (node == null) {
            return false; // not found
        }

        int compare = locationName.compareToIgnoreCase(node.locationName);

        if (compare == 0) {
            return true; // found!
        } else if (compare < 0) {
            return searchRec(node.left, locationName); // search left
        } else {
            return searchRec(node.right, locationName); // search right
        }
    }

    // ─── DELETE ───────────────────────────────────────────
    public void delete(String locationName) {
        if (!search(locationName)) {
            System.out.println("  [!] Location '" + locationName + "' not found in BST.");
            return;
        }
        root = deleteRec(root, locationName);
        System.out.println("  [✓] Location '" + locationName + "' removed from BST.");
    }

    private BSTNode deleteRec(BSTNode node, String locationName) {
        if (node == null) return null;

        int compare = locationName.compareToIgnoreCase(node.locationName);

        if (compare < 0) {
            node.left = deleteRec(node.left, locationName);
        } else if (compare > 0) {
            node.right = deleteRec(node.right, locationName);
        } else {
            // Node found — 3 cases:

            // Case 1: No children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Case 3: Two children
            // Find smallest value in right subtree (inorder successor)
            BSTNode successor = findMin(node.right);
            node.locationName = successor.locationName;
            node.right = deleteRec(node.right, successor.locationName);
        }

        return node;
    }

    // helper — finds the leftmost (smallest) node
    private BSTNode findMin(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ─── DISPLAY (InOrder = alphabetical order) ────────────
    public void inOrder() {
        if (root == null) {
            System.out.println("  [!] No locations stored in BST.");
            return;
        }
        System.out.print("  Locations (A-Z): ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.locationName + "  ");
            inOrderRec(node.right);
        }
    }
}
