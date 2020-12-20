// Hi, here's your problem today. This problem was recently asked by Microsoft:

// You are given two linked-lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Example:
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

public class MathTypeStuff {
    
    private static class Node{
        int digit;
        Node next;
        
        @Override
        public String toString() {
            return (next == null ? "" : next.toString())+""+digit;
        }
    }

    /**
     * Assuming numbers to add are passed in element 0 and 1 of args
     * @param args
     */
    public static void main(String[] args){
        Node root = new Node(), current = root;

        for(int i = args[0].length() - 1; i >= 0; i--){
            //we would have at least as many nodes as there are digits in either of our arguements
            if(i > 0){
                current.next = new Node();
            }
            
            //add both digits at that step of the link
            current.digit += 
            (Integer.parseInt(args[0].charAt(i)+"") + Integer.parseInt(args[1].charAt(i)+"")); 
            
            //check if there's need to carry over
            if(current.digit >= 10){
                //just in case becase the most significant digit might need a carry
                if(current.next == null){
                    current.next = new Node();
                }
                current.next.digit += 1;
                current.digit -= 10;
            }

            //set appropriate node for next step
            if(i > 0){
                current = current.next;
            }
        }
        System.out.println(args[0] + " + "+args[1] +" = "+ root.toString());
    }
}