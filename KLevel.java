public class KLevel {
    public static void KLevels(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.println(root.data+" ");
            return;
        }
        KLevels(root.left, level+1, k);
        KLevels(root.right, level, k);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        KLevels(root, 1, k);
    } 
}