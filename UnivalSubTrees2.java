import java.util.ArrayList;
import java.util.List;

// A unival tree is a tree where all the nodes have the same value. Given a binary tree, return the number of unival subtrees in the tree.

// For example, the following tree should return 5:
//    0
//   / \
//  1   0
//     / \
//    1   0
//   / \
//  1   1

// The 5 trees are:
// - The three single '1' leaf nodes. (+3)
// - The single '0' leaf node. (+1)
// - The [1, 1, 1] tree at the bottom. (+1)


public class UnivalSubTrees2 {
    
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        root.right.left.left  = new Node(1);  
        root.right.left.right  = new Node(1);  

        int univalSubTreeCount = 0;
        if(root.left != null)
            univalSubTreeCount += getUnivalTreeCount(root.left);
        if(root.right != null)
            univalSubTreeCount += getUnivalTreeCount(root.right);
        System.out.println("Number of Unival subtrees is "+univalSubTreeCount);
    }


    static int getUnivalTreeCount(Node root){
        int count = 0;
        List<Node> allNodes = new ArrayList<>();
        allNodes.add(root);
        int iterationsRequired = allNodes.size();
        int sizeDelta = 0;

        //since each node is a subtree root
        Node n;
        for (int i = 0; i < iterationsRequired; i++) {
            sizeDelta = 0;
            n = allNodes.get(i);
            if(isUnival(n))
                count++;
            if(n.left != null)
                allNodes.add(i+(++sizeDelta),n.left);
            if(n.right != null)
                allNodes.add(i+(++sizeDelta),n.right);
            iterationsRequired += sizeDelta;
        }
        
        return count;
    }

    static boolean isUnival(Node root){
        boolean leftSame = root.left == null || root.left.value == root.value && isUnival(root.left);
        boolean rightSame = root.right == null || root.right.value == root.value && isUnival(root.right);
        return leftSame && rightSame;
    }

    static class Node{
        Node left, right;
        int value;

        public Node(int v){
            this.value = v;
        }
    }
}
