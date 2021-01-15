// Given a sorted list of numbers, change it into a balanced binary search tree. You can assume there will be no duplicate numbers in the list.

public class TreeFromList {
    public static void main(String[] args) {
        int[] list = {1,2,3,4};
        Node root = new Node();
        fill(list, root, 0, list.length-1);
    }

    static void fill(int[] list, Node root, int start, int end){
        if(end < start || start > end)
            return;
    
        int length = end - start + 1;
        int middle = (length / 2) + start;
        root.value = list[middle];

        root.left = new Node();
        root.right = new Node();

        fill(list,root.left,start,middle-1);
        fill(list,root.right,middle+1,end);
    }

    static class Node{
        Node left,right;
        int value;
    }
}