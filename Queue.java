// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.util.*;

class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<Integer> ();
        stack2 = new Stack<Integer> ();

    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
            while(!stack1.isEmpty())
            stack2.push(stack1.pop());
            stack2.push(x);
            while(!stack2.isEmpty())
            stack1.push(stack2.pop());


    }

    // Removes the element from in front of queue.
    public int dequeue() {
        return stack1.pop();

    }
    
    // Get the front element.
    public int peek() {
        return stack1.peek();

    }
    
    // Return whether the queue is empty.
    public boolean empty() {

    }

    // Return the number of elements in queue.
    public boolean size() {

    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                queue.dequeue();
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());
            } 
        }
    }
}
