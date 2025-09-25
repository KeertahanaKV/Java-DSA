// enqueue(int data) – Add element at rear

// dequeue() – Remove element from front

// peek() – Show front element

// isEmpty() – Check if queue is empty

// isFull() – Check if queue is full

class NormalQueue {
    int[] arr;
    int front, rear, capacity;

    NormalQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;    // points to first element
        rear = -1;    // no elements yet
    }

    // Check if queue is empty
    boolean isEmpty() {
        return rear < front;
    }

    // Check if queue is full
    boolean isFull() {
        return rear == capacity - 1;
    }

    // Enqueue (insert at rear)
    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = x;
    }

    // Dequeue (delete from front)
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Dequeued: " + arr[front]);
        front++;
    }

    // Get front element
    int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Get rear element
    int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[rear];
    }

    // Display queue elements
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
