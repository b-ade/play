import java.util.ArrayList;
import java.util.List;

// Given an integer k and a binary search tree, find the floor (less than or equal to) of k, and the ceiling (larger than or equal to) of k. If either does not exist, then print them as None.

// Here is the definition of a node for the tree.

public class BinaryTreeFloorCeiling {
    
    static class Node{
        int value;
        Node left,right;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value+"";
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);
        
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int[] floorCeiling = getFloorAndCeiling(root,50);
        System.out.println("The floor is "+floorCeiling[0]+" The ceiling is "+floorCeiling[1]);
    }


    static int[] getFloorAndCeiling(Node root,int k){
        /*
          8
        /   \    
      4      12
    /  \    /  \
   2    6  10   14

   //binary search tree, so tree is sorted
   Inorder 2 4 6 8 10 12 14
   k = 5
        */
        List<Integer> list = new ArrayList<>();
        fillInorder(root, list);

        int floor = -1, ceiling = -1,current,floorIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if((current = list.get(i)) > k){
                floorIndex = i;
                if(current == k)
                    floor = k;
                else if(i > 0)
                    floor = list.get(i-1);
                break;
            }
        }


        if(floorIndex != -1){//if we found a floor, start checking for celing starting from floor position
            for (int i = floorIndex; i < list.size(); i++) {
                if(k <= list.get(floorIndex)){
                    ceiling = list.get(i);
                    break;
                }
            }
        }else{//otherwise start checking from the end of the list
            for (int i = list.size() - 1; i >= 0; i--) {
                if((current = list.get(i)) >= k){
                    ceiling = current;
                }else{
                    break;
                }
            }
        }

        return new int[]{floor,ceiling};
    }

    
    static void fillInorder(Node current, List<Integer> list){
        if(current != null){
            fillInorder(current.left, list);
            list.add(current.value);
            fillInorder(current.right, list);
        }
    }
}