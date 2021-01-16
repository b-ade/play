// Given a sorted list of numbers, change it into a balanced binary search tree. You can assume there will be no duplicate numbers in the list.

public class BalancedBinaryTreeFromList {
    
    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5, 6, 7};
    
        Node balancedTree = toTree(list,0,list.length - 1);
    }

    static Node toTree(int[] array,int start, int end){
        if(start == end)
            return new Node(array[start]);

        if(start < end){

            int middle = /*length of sub array / 2 + start */
                ((end - start + 1) / 2) + start;
            
            Node myRoot = new Node(array[middle]);
            myRoot.left = toTree(array,start,middle-1);
            myRoot.right = toTree(array,middle+1,end);
            return myRoot;
        }

        return null;
    }

    static class Node {
        Node left,right;
        int value;

        public Node(int v){
            this.value = v;
        }
    }
}