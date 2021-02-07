// You are given a binary tree representation of an arithmetic expression. In this tree, each leaf is an integer value,, and a non-leaf node is one of the four operations: '+', '-', '*', or '/'.

// Write a function that takes this tree and evaluates the expression.

// Example:

//     *
//    / \
//   +    +
//  / \  / \
// 3  2  4  5

// This is a representation of the expression (3 + 2) * (4 + 5), and should return 45.


public class ArithmeticBinaryTree{

    static class Node{
        String repped;
        Node left,right;

        public Node(String value){
            this.repped = value;       
        }    
    }

    public static void main(String[] args) {
        Node root = new Node("*");
        root.left = new Node("+");
        root.left.left = new Node("3");
        root.left.right = new Node("2");
        root.right = new Node("+");
        root.right.left = new Node("4");
        root.right.right = new Node("5");

        System.out.println(evaluateNode(root));
    }

    static String operations = "+-*/";

    static double evaluateNode(Node root){
        if(root == null)
            return 0;
        
        if(operations.contains(root.repped)){
            double left = evaluateNode(root.left);
            double right = evaluateNode(root.right);

            return root.repped.equals("+") ? left + right :
                    root.repped.equals("/") ? left / right : 
                    root.repped.equals("*") ? left * right :  left - right; 
        }
        
        return Double.parseDouble(root.repped);
    }
}