// Hi, here's your problem today. This problem was recently asked by Uber:

// Given a linked list of integers, remove all consecutive nodes that sum up to 0.

// Example:
// Input: 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
// Output: 10

// The consecutive nodes 5 -> -3 -> -3 -> 1 sums up to 0 so that sequence should be removed. 4 -> -4 also sums up to 0 too so that sequence should also be removed.

public class LinkedListReduction {
    public static void main(String[] args) {
        int[] list = {10,5,-3,-3,1,4,-4};

        //create list
        Node head = new Node(),current = head;
        for (int i = 0; i < list.length - 1; i++) {
            current.digit = list[i];
            current.next = new Node();
            current.next.previous = current;
            current = current.next;
        }
        current.digit = list[list.length-1];

        System.out.println("Linked list is \t\t "+head);

        Node start = head;
        int sum;
        boolean minimized;
        
        while(start != null && start.getLengthFromNode() > 1){
            sum = start.digit;
            current = start;
            minimized = false;

            while(current != null && (current = current.next) != null){
                if(minimized = (sum+=current.digit) == 0){//dispose sub link from start node to current node
                    if(start.previous == null)//but ensure list still has a head
                        head = current;

                    //actual reduction of linked list here; forgets all nodes inbetween the specified nodes while linking them together
                    Node.link(start.previous, current.next);

                    start = current.next;
                    break;
                }
            }
            if(minimized)//if reduced the list,
                continue;// continue the check from the newly created link
            start = start.next;//otherwise, start over from the next node
        }

        System.out.println(head);
    }

    static class Node{
        int digit;
        Node previous,next;

        /**
         * Get the length starting from this node to the end of the list
         */
        int getLengthFromNode(){
            if(next != null){
                return 1 + next.getLengthFromNode();
            }
            return 1;
        }

        @Override
        public String toString() {
            return digit + (next != null ? " -> " + next.toString() : "");
        }

        static void link(Node preceeding,Node following){
            if(following != null)
                following.previous = preceeding;
            if(preceeding != null)
                preceeding.next = following;
        }
    }
}