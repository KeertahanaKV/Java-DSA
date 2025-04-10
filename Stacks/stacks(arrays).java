public class StackArray {
    int top;
    int capacity;
    int[] stack;

    // Constructor
    StackArray(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // Push operation
    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is Full. Cannot push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed to stack");
    }

    // Pop operation
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty. Cannot pop");
            return -1;
        }
        return stack[top--];
    }

    // Peek (top element)
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty. Nothing to peek");
            return -1;
        }
        return stack[top];
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    boolean isFull() {
        return top == capacity - 1;
    }

    // Display stack elements
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty.");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // Main method to test the stack
    public static void main(String[] args) {
        StackArray stack = new StackArray(5); // size of the stack is 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // This should say stack is full

        stack.display();

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();
    }
}
