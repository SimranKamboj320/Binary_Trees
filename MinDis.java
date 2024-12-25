class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class MinDis {
    public static Node LCA(Node root, int n1, int n2) {
        // Base case: if root is null or matches any of the nodes
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Search in left and right subtrees
        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        // If both subtrees return non-null, current node is LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null subtree
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        return (leftDist != -1) ? leftDist + 1 : rightDist + 1;
    }
    public static int mindis(Node root, int n1, int n2) {
        Node lca = LCA(root, n1, n2);
        if (lca == null) {
            return -1; // Nodes are not present
        }

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6;
        System.out.println("Minimum distance between " + n1 + " and " + n2 + " is: " + mindis(root, n1, n2));
    }
}