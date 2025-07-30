class MyHashMap {
    // Size of the array (number of buckets)
    private final int SIZE = 1000;
    // Each bucket is a Linked List of Nodes
    Node[] map;

    // Node class to store key-value pairs
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public MyHashMap() {
        map = new Node[SIZE];
    }

    // Hash function (division method)
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = map[index];

        // If bucket is empty, directly insert
        if (head == null) {
            map[index] = new Node(key, value);
            return;
        }

        // Traverse and update if key exists
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // update
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        // If key not found, add new node at end
        curr.next = new Node(key, value);
    }

    // Retrieve value for key
    public int get(int key) {
        int index = getIndex(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; // key not found
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = getIndex(key);
        Node curr = map[index];

        if (curr == null) return;

        // If first node is the target
        if (curr.key == key) {
            map[index] = curr.next;
            return;
        }

        // Find and remove target node
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
