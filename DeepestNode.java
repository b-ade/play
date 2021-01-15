import java.util.ArrayList;
import java.util.List;

// You are given the root of a binary tree. Return the deepest node (the furthest node from the root).

// Example:
//     a
//    / \
//   b   c
//  /
// d

// The deepest node in this tree is d at depth 3.


public class DeepestNode{
    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
    
        System.out.println("Deepest node in tree is ["+findDeepest(root).value+"]");
    }

    static Node findDeepest(Node root){
        List<Node> atDepth = new ArrayList<>();
        List<Node> nextLevel = new ArrayList<>();
        atDepth.add(root);
        
        while(true){
            nextLevel.clear();
            for(Node n: atDepth){
                if(n.left != null)
                    nextLevel.add(n.left);
                if(n.right != null)
                    nextLevel.add(n.right);
            }
            if(nextLevel.isEmpty())
                break;
            atDepth.clear();
            atDepth.addAll(nextLevel);
        }
        return atDepth.get(0);
    }

    static class Node{
        Node left,right;
        char value;

        public Node(char value){
            this.value = value;
        }
    }
    
}