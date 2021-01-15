// You are given the root of a binary search tree. Return true if it is a valid binary search tree, and false otherwise. Recall that a binary search tree has the property that all values in the left subtree are less than or equal to the root, and all values in the right subtree are greater than or equal to the root.


// #    5
// #   / \
// #  3   7
// # / \ /
// #1  4 6

import java.util.ArrayList;
import java.util.List;

public class ValidateBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right = new Node(7);
        root.right.left = new Node(6);

        System.out.println(isValid(root));
    }

    static boolean isValid(Node root){
        List<Integer> asList = getList(root);//check that inorder list is sorted
        for (int i = 1; i < asList.size(); i++) {
            if(asList.get(i) < asList.get(i-1))
                return false;
        }
        return true;
    }

    //get the elements in inorder fashion
    static List<Integer> getList(Node root){
        List<Integer> tr = new ArrayList<>();
        
        if(root == null)
            return tr;
    
        if(root.left == null && root.right == null){
            tr.add(root.value);
            return tr;    
        }

        tr.addAll(getList(root.left));
        tr.add(root.value);
        tr.addAll(getList(root.right));
        return tr;
    }

    static class Node{
        Node left,right;
        int value;

        public Node(int v){
            this.value = v;
        }
    }
}