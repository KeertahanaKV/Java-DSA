// Class for a Node in the Doubly Linked List
class Node {
    int data;
    Node prev, next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Class for the Doubly Linked List
class DoublyLinkedList {
    Node head; // Head pointer

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertAtPosition(int data, int pos) {
    Node newNode = new Node(data);

    // Case 1: Insert at position 0 (i.e., at the beginning)
    if (pos == 0) {
        newNode.next = head;
        if (head != null) head.prev = newNode;
        head = newNode;
        return;
    }

    // Traverse to the node just before the desired position
    Node temp = head;
    for (int i = 0; temp != null && i < pos - 1; i++) {
        temp = temp.next;
    }

    // If position is beyond list length, do nothing
    if (temp == null) return;

    newNode.next = temp.next;
    newNode.prev = temp;

    if (temp.next != null) temp.next.prev = newNode;
    temp.next = newNode;
}


     // ✅ Delete node by value (clean version)
    public void deleteNode(int value) {
        if (head == null) return;

        Node temp = head;

        // Search for the node
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        // Not found
        if (temp == null) return;

        // Case 1: Node to delete is head
        if (temp == head) {
            head = temp.next;
            if (head != null) head.prev = null;
        }
        // Case 2: Node is not head (middle or tail)
        else {
            temp.prev.next = temp.next;
            if (temp.next != null) temp.next.prev = temp.prev;
        }
    }
    // Delete the first node
    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.prev != null) temp.prev.next = null;
        else head = null; // If only one node was present
    }

    // Search for an element
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Reverse the doubly linked list
    public void reverse() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) head = temp.prev;
    }
    /*Temp stores the previous pointer of the node before swapping.
At the end, temp holds the second-last processed node,
and temp.prev becomes the new head.*/

    // Display the list forward
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display the list backward
    public void printBackward() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}

// Main class to test the Doubly Linked List
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insertions
        dll.insertAtBeginning(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtPosition(25, 3);

        // Display
        System.out.println("Forward Traversal:");
        dll.printForward(); // 10 ⇄ 20 ⇄ 25 ⇄ 30 ⇄ null

        System.out.println("Backward Traversal:");
        dll.printBackward(); // 30 ⇄ 25 ⇄ 20 ⇄ 10 ⇄ null

        // Deletions
        dll.deleteNode(20);
        System.out.println("After Deleting 20:");
        dll.printForward(); // 10 ⇄ 25 ⇄ 30 ⇄ null

        dll.reverse();
        System.out.println("After Reversing:");
        dll.printForward(); // 30 ⇄ 25 ⇄ 10 ⇄ null
    }
}
