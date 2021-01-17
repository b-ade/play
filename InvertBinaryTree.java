// You are given the root of a binary tree. Invert the binary tree in place. That is, all left children should become right children, and all right children should become left children.

// Example:
//     a
//    / \
//   b   c
//  / \  /
// d   e f

// The inverted version of this tree is as follows:
//   a
//  / \
//  c  b
//  \  / \
//   f e  d


public class InvertBinaryTree{
    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right = new Node('c');
        root.right.left = new Node('f');

        invert(root);
    }

    static void invert(Node root){
        if(root != null){
            Node temp = null;
            temp = root.right;
            root.right = root.left;
            root.left = temp;
            invert(root.left);
            invert(root.right);
        }
    }

    static class Node{
        Node left,right;
        char value;

        public Node(char v){
            this.value = v;
        }
    }
}