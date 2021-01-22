// You are given the root of a binary tree. Find and return the largest subtree of that tree, which is a valid binary search tree.

import java.util.ArrayList;
import java.util.List;

public class LargestBSTinBinaryTree{

    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.left = new Node(6);
        tree.left.left = new Node(2);
        tree.right = new Node(7);
        tree.right.left = new Node(4);
        tree.right.right = new Node(9);

        Node info = getLargestBSTIn(tree);
    }

    static Node getLargestBSTIn(Node root){
        Result info = new Result();
        boolean found = false;
        List<Node> potentials = new ArrayList<>();
        potentials.add(root);
        Node current;
        for (int i = 0; i < potentials.size(); i++) {
            current = potentials.get(i);
            if(current.left != null){
                if(isValid(current.left)){
                    Result temp = new Result();
                    temp.currentNode = current.left;
                    temp.currentNodeSize = current.left.getSize();
                    info.checkAndReplace(temp);
                    found |= true;
                }
            }
            if(current.right != null){
                if(isValid(current.right)){
                    Result temp = new Result();
                    temp.currentNode = current.right;
                    temp.currentNodeSize = current.right.getSize();
                    info.checkAndReplace(temp);
                    found |= true;
                }
            }

            if(found)//since starting from the root, no need to go any further when the a 
                break;//valid tree is reached

            //no valid tree was found at depth, continue searching in a breadth first manner
            if(current.left != null){
                if(current.left.left != null)
                    potentials.add(current.left.left);
                if(current.left.right != null)
                    potentials.add(current.left.right);
            }
            if(current.right != null){
                if(current.right.left != null)
                    potentials.add(current.right.left);
                if(current.right.right != null)
                    potentials.add(current.right.right);
            }
        }
        return info.currentNode;
    }

    static boolean isValid (Node root) {
        boolean leftValid = root.left == null || root.left.value <= root.value && isValid(root.left),rightValid = root.right == null || root.value < root.right.value && isValid(root.right);
        return leftValid && rightValid;
    }

    static class Node{
        Node left, right;
        int value;

        public Node(int v){
            this.value = v;
        }

        int getSize(){
            return 1 + (left == null ? 0 : left.getSize()) + (right == null ? 0 : right.getSize());
        }
    }

    static class Result{
        Node currentNode;
        int currentNodeSize;

        void checkAndReplace(Result potential){
            if(potential != null){
                if(potential.currentNodeSize > this.currentNodeSize){
                    this.currentNode = potential.currentNode;
                    this.currentNodeSize = potential.currentNodeSize;
                }
            }
        }
    }
}