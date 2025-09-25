class CircularDeque {
    int[] arr;
    int front, rear, size, capacity;

    CircularDeque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;   // empty deque
        rear = -1;    // empty deque
        size = 0;
        this.capacity = capacity;
    }

    // Check if deque is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Check if deque is full
    boolean isFull() {
        return size == capacity;
    }

    // Insert at front
    void insertFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()) { // first element
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity; // circular decrement
        }

        arr[front] = x;
        size++;
    }

    // Insert at rear
    void insertRear(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()) { // first element
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity; // circular increment
        }

        arr[rear] = x;
        size++;
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
            front = (front + 1) % capacity; // circular increment
        }

        size--;
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
            rear = (rear - 1 + capacity) % capacity; // circular decrement
        }

        size--;
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

    // Display deque elements
    void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.print("Deque elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
