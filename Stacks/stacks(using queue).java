/*  q1 – The main queue
 It always holds the current stack elements.
 The top of the stack is at the front of q1.*/

/*q2 – The helper queue
It is used only during push() to help reorder elements.
 After push, we swap q1 and q2.*/

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (costly)
    void push(int value) {
        // Step 1: Add the element to q2
        q2.add(value);

        // Step 2: Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println(value + " pushed to stack");
    }

    // Pop operation
    int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return q1.remove();  // Remove front element (top of stack)
    }

    // Peek operation
    int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return q1.peek();  // Get front element (top of stack)
    }

    // isEmpty
    boolean isEmpty() {
        return q1.isEmpty();
    }

    // Display stack
    void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Stack elements:");
        for (int val : q1) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); // Should print 30 20 10

        System.out.println("Top element: " + stack.peek()); // 30

        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        stack.display(); // Should print 10
    }
}
