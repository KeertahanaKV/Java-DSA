class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // 1. Enqueue - Add element at rear
    void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // 2. Dequeue - Remove element from front
    int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int val = front.data;
        front = front.next;

        // If front becomes null, rear should also be null
        if (front == null)
            rear = null;

        return val;
    }

    // 3. Peek - See front element
    int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    // 4. isEmpty - Check if queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // 5. Display queue
    void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Front element is: " + q.peek());
        System.out.println("Is queue empty? " + q.isEmpty());
    }
}
