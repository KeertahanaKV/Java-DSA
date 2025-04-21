// insertFront(int x) – Insert at front

// insertRear(int x) – Insert at rear

// deleteFront() – Delete from front

// deleteRear() – Delete from rear

// getFront() – Get front element

// getRear() – Get rear element

// isFull() – Check if full

// isEmpty() – Check if empty

// display() – Print all elements

class ArrayDeque {
    int[] arr;
    int front, rear, size, capacity;

    ArrayDeque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    // Check full
    boolean isFull() {
        return size == capacity;
    }

    // Check empty
    boolean isEmpty() {
        return size == 0;
    }

    // Insert at front
    void insertFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
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

        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
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

        front = (front + 1) % capacity;
        size--;

        if (size == 0) front = rear = -1;
    }

    // Delete from rear
    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        if (rear == 0)
            rear = capacity - 1;
        else
            rear--;

        size--;

        if (size == 0) front = rear = -1;
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
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
