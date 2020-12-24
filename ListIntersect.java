// Hi, here's your problem today. This problem was recently asked by Apple:

// You are given two singly linked lists. The lists intersect at some node. Find, and return the node. Note: the lists are non-cyclical.

// Example:

// A = 1 -> 2 -> 3 -> 4
// B = 6 -> 3 -> 4 

// This should return 3 (you may assume that any nodes with the same value are the same node).

public class ListIntersect{
    
    static class Node{
        int number;
        Node next;
        Node previous;
        int sublenght = 0;

        public void addToPreviousNodeLength() {
            if(this.previous != null){
                this.previous.sublenght += 1;
                this.previous.addToPreviousNodeLength();
            }
        }

        public int getLength(){
            return this.sublenght +1;
        }
    }

    public static void main(String[] args){
        Node listARoot = new Node(), listBRoot = new Node();

    
        //form both list
        int[] firstList = stringToIntArray(args[0]);
        createNodes(listARoot,firstList);
        
        int[] secondList = stringToIntArray(args[1]);
        createNodes(listBRoot,secondList);

        int link = findLink(listARoot,listBRoot);
        System.out.println(String.format("Link between list %1s and %2s is %d",args[0],args[1],link));
    }

    private static int findLink(Node rootA, Node rootB){
        //compare eitherlist against the other
        //current choice is rootA
        //as an attempt to reduce, you can keep track of the length of a list starting at a 
        //particular node,say...'sub-length'
        //then use the shorter list as reference list

        Node currentForReferenceList = rootA.getLength() - rootB.getLength() < 0 ? rootA : rootB;
        Node designatedOtherListm = currentForReferenceList == rootA? rootB : rootA, currentForOtherList;

        while(currentForReferenceList != null){
            currentForOtherList = designatedOtherListm;
            while(currentForOtherList != null){
                if(currentForReferenceList.number == currentForOtherList.number){
                    return currentForReferenceList.number;
                }
                currentForOtherList = currentForOtherList.next;
            }
            currentForReferenceList = currentForReferenceList.next;
        }

        return -1;//this should never happen
    }

    private static void createNodes(Node root, int[] list){
        Node current = root;
        for (int i = 0; i < list.length - 1; i++) {
            current.number = list[i];
            current.next = new Node();
            current.next.previous = current;
            current = current.next;
            current.addToPreviousNodeLength();
        }
        current.number = list[list.length-1];
    }

    public static int[] stringToIntArray(String input){
        String[] arrayString = input.replace(" ","").replace("[","")
                                                        .replace("]","")
                                                        .split(",");
            
        int[] numbers = new int[arrayString.length];
        for(int i  = 0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(arrayString[i]);
        }
        return numbers;
    }
}