// enqueue(int data) – Add element at rear

// dequeue() – Remove element from front

// peek() – Show front element

// isEmpty() – Check if queue is empty

// isFull() – Check if queue is full

class ArrayQueue {
    int[] arr;
    int front, rear, size, capacity;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    // Dequeue
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Peek
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // isEmpty
    boolean isEmpty() {
        return size == 0;
    }

    // isFull
    boolean isFull() {
        return size == capacity;
    }

    // Display
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.display(); // 20 30

        System.out.println("Front element: " + q.peek()); // 20

        System.out.println("Is queue empty? " + q.isEmpty()); // false
        System.out.println("Is queue full? " + q.isFull());   // false
    }
}
