class StackLinkedList {
    Node top = null;  // Points to top of the stack

    // Push = add to top
    void push(int value) {
        Node newNode = new Node(value);  // Create a new node with the value
        newNode.next = top;              // Point it to the current top
        top = newNode;                   // Now, newNode becomes the top
        System.out.println(value + " pushed to stack");
    }

    // Pop = remove from top
    int pop() {
        if (top == null) {
            System.out.println("Stack is Empty.");
            return -1;
        }
        int value = top.data;   // Save the value
        top = top.next;         // Move top to the next node
        return value;
    }

    // Peek = just see the top value
    int peek() {
        if (top == null) {
            System.out.println("Stack is Empty.");
            return -1;
        }
        return top.data;
    }

    // Check if empty
    boolean isEmpty() {
        return top == null;
    }

    // Display the stack
    void display() {
        if (top == null) {
            System.out.println("Stack is Empty.");
            return;
        }
        Node temp = top;
        System.out.println("Stack elements:");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(10);  // stack: 10
        stack.push(20);  // stack: 20 -> 10
        stack.push(30);  // stack: 30 -> 20 -> 10

        stack.display(); // should print from top to bottom

        System.out.println("Top element is: " + stack.peek()); // 30

        System.out.println("Popped: " + stack.pop()); // removes 30
        System.out.println("Popped: " + stack.pop()); // removes 20

        stack.display(); // should now show only 10
    }
}
