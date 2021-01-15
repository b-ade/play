// Given a binary tree, return all values given a certain height h.
//      1
//     / \
//    2   3
//   / \   \
//  4   5   7


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeValuesAtHeight {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
    
    
        int depth = 1;
        System.out.println("Nodes are depth "+depth+" are "+Arrays.toString(getNodesAtDepth(root,depth)));
    }

    //assuming the tree has children nodes
    static int[] getNodesAtDepth(Node root,int depth){
        List<Node> atDepth = new ArrayList<>();
        atDepth.add(root);
        int currentDepth = 1;
        
        List<Node> replacement = new ArrayList<>();
        while(++currentDepth <= depth){
            replacement.clear();

            for(Node n:atDepth){
                if(n.left != null)
                    replacement.add(n.left);
                if(n.right != null){
                    replacement.add(n.right);
                }
            }
            
            atDepth.clear();
            atDepth.addAll(replacement);
        }

        int[] tr = new int[atDepth.size()];
        for (int i = 0; i < tr.length; i++) {
            tr[i] = atDepth.get(i).value;
        }
        return tr;
    }

    static class Node{
        Node left,right;
        int value;

        public Node(int value){
            this.value = value;
        }
    }
}