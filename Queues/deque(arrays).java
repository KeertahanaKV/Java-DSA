// insertFront(int x) – Insert at front

// insertRear(int x) – Insert at rear

// deleteFront() – Delete from front

// deleteRear() – Delete from rear

// getFront() – Get front element

// getRear() – Get rear element

// isFull() – Check if full

// isEmpty() – Check if empty

// display() – Print all elements

class SimpleDeque {
    int[] arr;
    int front, rear, capacity;

    SimpleDeque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;       // index of front element
        rear = -1;        // index of rear element
    }

    // Check if empty
    boolean isEmpty() {
        return front == -1;
    }

    // Check if full
    boolean isFull() {
        return rear == capacity - 1;
    }

    // Insert at rear
    void insertRear(int x) {
        if (isFull()) {
            System.out.println("Deque is full at rear");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear++;
        }

        arr[rear] = x;
    }

    // Insert at front
    void insertFront(int x) {
        if (front == 0) {
            System.out.println("Deque is full at front");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front--;
        }

        arr[front] = x;
    }

    // Delete from front
    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        if (front == rear) { // only one element
            front = rear = -1;
        } else {
            front++;
        }
    }

    // Delete from rear
    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        if (front == rear) { // only one element
            front = rear = -1;
        } else {
            rear--;
        }
    }

    // Get front element
    int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[front];
    }

    // Get rear element
    int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[rear];
    }

    // Display deque
    void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.print("Deque elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
