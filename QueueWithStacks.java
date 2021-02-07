import java.util.Iterator;
import java.util.Stack;

// Implement a queue class using two stacks. A queue is a data structure that supports the FIFO protocol (First in = first out). Your class should support the enqueue and dequeue methods like a standard queue.

public class QueueWithStacks {
    
    public static void main(String[] args) {
        Queue<Integer> q = new Queue();
        for (int i = 0; i < 10; i++) {
            q.enQueue((i+1));
        }

        Integer current;
        while((current = q.deQueue()) != null){
            System.out.print(current+" ");
        }
        System.out.println();
    }

    static class Queue <T>{
        private Stack<T> auxStack = new Stack<T>();
        private Stack<T> mainStack = new Stack<T>();

        public int size(){
            return mainStack.size();
        }

        public T poll(){
            return mainStack.peek();
        }

        public void enQueue(T value){
            while(mainStack.size() > 0){
                auxStack.add(mainStack.pop());
            }
            auxStack.add(value);
            while(auxStack.size() > 0){
                mainStack.add(auxStack.pop());
            }
        }

        public T deQueue(){
            if(mainStack.size() < 1)
                return null;
            return mainStack.pop();
        }
    }
}