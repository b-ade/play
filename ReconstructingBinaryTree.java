// public You are given the preorder and inorder traversals of a binary tree in the form of arrays. Write a function that reconstructs the tree represented by these traversals.

// Example:
// Preorder: [a, b, d, e, c, f, g]
// Inorder: [d, b, e, a, f, c, g]

// The tree that should be constructed from these traversals is:

//     a
//    / \
//   b   c
//  / \ / \
// d  e f  g
import java.util.Arrays;

public class ReconstructingBinaryTree{
    public static void main(String[] args) {
        char[] preorder = {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
        char[] inorder = {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
        Node tree = createTree(preorder, inorder);
    }

    static Node createTree(char[] pre,char[] in){
        if(pre.length == 1){
            return new Node(pre[0]);
        }else if (pre.length > 1){
            Node root = new Node(pre[0]);
            int rootIndexIn_IO = search(in,root.value);//informs the size of left and right subtrees

            //construct left subtree
            char[] leftPre = Arrays.copyOfRange(pre, 1, rootIndexIn_IO + 1);
            char[] leftIn = Arrays.copyOfRange(in, 0, rootIndexIn_IO);
            root.left = createTree(leftPre, leftIn);

            //construct right subtree
            char[] rightPre = Arrays.copyOfRange(pre, rootIndexIn_IO + 1,pre.length);
            char[] rightIn = Arrays.copyOfRange(in, rootIndexIn_IO + 1,in.length);
            root.right = createTree(rightPre, rightIn);
            return root;
        }
        return null;
    }

    static int search(char[] c,char target){
        String s = new String(c);
        return s.indexOf(target);
    }

    static class Node {
        Node left, right;
        char value;

        public Node(char v){
            this.value = v;
        }
    }
}