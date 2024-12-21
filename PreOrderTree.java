import java.util.*;

public class PreOrderTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes); // Recursive call for the left subtree
            newNode.right = buildTree(nodes); // Recursive call for the right subtree
            return newNode; // Return the created node
        }
        public static void preorder(Node root){
            if(root == null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(nodes); // Call the static method using the class name
        System.out.println("Root node data: " + root.data); // Print the root node's data

        tree.preorder(root);
    }
}