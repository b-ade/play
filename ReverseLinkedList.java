import java.util.Stack;

// Given a singly-linked list, reverse the list. This can be done iteratively or recursively. Can you get both solutions?

// Example: 
// Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL
// Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL


public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        System.out.println("Iteratively reversed => "+reverseIteratively(head));
        System.out.println("Recursively reversed => "+reverseIteratively(head));
    }

    static Node reverseIteratively(Node head) {
        int[] rep = new int[head.getLength()];
        rep[0] = head.value;
        Node current = head;

        for (int j = 0; j < rep.length; j++) {
            rep[j] = current.value;
            current = current.next;
        }

        current = head = new Node(rep[rep.length-1]);
        for (int j = rep.length - 2; j >= 0; j--) {
            current.next = new Node(rep[j]);
            current = current.next;
        }

        return head;
    }

    static Node reverseRecursively(Node head) {
        if(head.next.next != null){
            Node newHead = reverseRecursively(head.next);
            newHead.getTail().next = head;
            head.next = null;
            return newHead;
        }else if(head.next != null){
            Node tr = head.next;
            tr.next = head;
            head.next = null;
            return tr;
        }
        return head;
    }

    static Node getReversed(Node node){
        if(node.next != null)
            return getReversed(node.next);
        return node;
    }

    static class Node {
        Node next;
        int value;

        public Node(int v){
            this.value = v;
        }

        public int getLength(){
            if(next != null)
                return next.getLength() + 1;
            return 1;
        }

        public Node getTail(){
            if(next != null)
                return next.getTail();
            return this;
        }

        public String toString(){
            return this.value + "" + (next == null?"" : " -> "+next.toString());
        }
    }
}