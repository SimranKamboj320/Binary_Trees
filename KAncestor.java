class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class KAncestor {
    public static int Ancestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0; // Found the target node, return distance 0
        }

        // Recursive search in left and right subtrees
        int leftDist = Ancestor(root.left, n, k);
        int rightDist = Ancestor(root.right, n, k);

        // If node not found in both subtrees
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // Distance from the current node to the target
        int maxDist = Math.max(leftDist, rightDist);
        if (maxDist + 1 == k) {
            System.out.println("The " + k + "-th ancestor of node " + n + " is: " + root.data);
        }
        return maxDist + 1; // Return updated distance
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n = 5, k = 2;
        int result = Ancestor(root, n, k);
        if (result == -1 || result < k) {
            System.out.println("No " + k + "-th ancestor exists for node " + n + ".");
        }
    }
}