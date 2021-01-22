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
        Result info = new Result(null,0);
        boolean found = false;
        List<Node> atDepth = new ArrayList<>(), replaceMent = new ArrayList<>();
        atDepth.add(root);
        Node current;
        while(atDepth.size() > 0){
            replaceMent.clear();

            //iterate through all nodes at current depth
            for (int i = 0; i < atDepth.size(); i++) {
                current = atDepth.get(i);
                if(current.left != null){
                    if(isValid(current.left)){
                        Result temp = new Result(current.left,current.left.getSize());
                        info.checkAndReplace(temp);
                        found |= true;
                    }
                }
                if(current.right != null){
                    if(isValid(current.right)){
                        Result temp = new Result(current.right,current.right.getSize());
                        info.checkAndReplace(temp);
                        found |= true;
                    }
                }
            }

            if(found)//since starting from the root, no need to go any further when the a 
                break;//valid tree is reached

            //no valid was foud at depth
            for(Node atL: atDepth){
                if(atL.left != null)
                    replaceMent.add(atL.left);
                if(atL.right != null)
                    replaceMent.add(atL.right);
            }
            atDepth.clear();//move to next level
            atDepth.addAll(replaceMent);
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

        public Result(Node node,int nodeSize){
            this.currentNode = node;
            this.currentNodeSize = nodeSize;
        }

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