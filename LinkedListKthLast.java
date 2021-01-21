// You are given a singly linked list and an integer k. Return the linked list, removing the k-th last element from the list. 

// Try to do it in a single pass and using constant space.

public class LinkedListKthLast {
    static class Node{
        Node next;
        int value;
        
        public Node(int v){
            this.value = v;
        }

        public Node(int v,Node next){
            this(v);
            this.next = next;
        }

        @Override
        public String toString() {
            return this.value + (this.next == null ? "" : " -> "+this.next.toString());
        }

        public int getLength(){
            if(this.next != null)
                return this.next.getLength() + 1;
            return 1;
        }

    }

    public static void main(String[] args) {
        Node list = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
        int k = 3;
        System.out.println("Before elemination: "+list);
        System.out.println("After elemination: "+eliminate(list,k));
    }

    static Node eliminate(Node listHead, int k) {
        int length = listHead.getLength();
        int breakPoint = length - k;
        if(breakPoint == 0)
            return listHead.next;
        Node current = listHead;
        for (int i = 1; i < breakPoint; i++) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = current.next.next;
        temp.next = null;
        return listHead;
    }
}