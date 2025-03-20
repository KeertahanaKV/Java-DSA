// Define a Node class to represent each element of the linked list
class Node {
    int data;  // Stores the value
    Node next; // Pointer to the next node

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.next = null; // Initially, the next pointer is set to null
    }
}

// Define the Singly Linked List class
class SinglyLinkedList {
    Node head; // Head node of the linked list (points to the first element)

    // 1️Insert at the Beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // Point the new node to the current head
        head = newNode; // Update head to the new node
    }

    // 2️ Insert at the End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If list is empty, make newNode the head
            return;
        }
        Node temp = head; // Start from the head
        while (temp.next != null) {
            temp = temp.next; // Move to the last node
        }
        temp.next = newNode; // Add newNode at the end
    }

    // 3️ Insert at a Specific Position
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data); // If position is 0, insert at beginning
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next; // Traverse to the required position
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next; // Insert newNode between temp and temp.next
        temp.next = newNode;
    }

    // 4️ Delete a Node by Value
    public void deleteNode(int key) {
        Node temp = head, prev = null;

        // If head contains the key
        if (temp != null && temp.data == key) {
            head = temp.next; // Update head
            return;
        }

        // Search for the key in the list
        while (temp != null && temp.data != key) {
            prev = temp; // Store previous node
            temp = temp.next; // Move to next node
        }

        // If key is not found
        if (temp == null) return;

        prev.next = temp.next; // Remove the node from the list
    }

    // 5️  Search for an Element
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true; // Key found
            temp = temp.next;
        }
        return false; // Key not found
    }

    // 6️ Reverse the Linked List
    public void reverse() {
        Node prev = null, current = head, next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = next; // Move current to next
        }
        head = prev; // Update head to new first node
    }

    // 7️ Detect a Loop in the Linked List (Floyd’s Cycle Detection)
    public boolean detectLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move 1 step
            fast = fast.next.next; // Move 2 steps
            if (slow == fast) return true; // Loop detected
        }
        return false; // No loop
    }

    // 8️ Find the Middle Node
    public Node findMiddle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move 1 step
            fast = fast.next.next; // Move 2 steps
        }
        return slow; // Middle node
    }

    // 9️ Remove Duplicates (For a Sorted List)
    public void removeDuplicates() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next; // Skip duplicate node
            } else {
                temp = temp.next;
            }
        }
    }

    //  Merge Two Sorted Linked Lists
    public Node mergeSortedLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data < l2.data) {
            l1.next = mergeSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSortedLists(l1, l2.next);
            return l2;
        }
    }

    // Display the Linked List
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main class to test the Linked List operations
public class LinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAtPosition(15, 2);

        System.out.println("Linked List after insertions:");
        list.display();

        // Search an element
        System.out.println("Is 20 in the list? " + list.search(20));

        // Delete a node
        list.deleteNode(20);
        System.out.println("Linked List after deleting 20:");
        list.display();

        // Reverse the list
        list.reverse();
        System.out.println("Reversed Linked List:");
        list.display();

        // Find middle element
        Node middle = list.findMiddle();
        System.out.println("Middle Node: " + (middle != null ? middle.data : "List is empty"));

        // Detect loop
        System.out.println("Loop detected? " + list.detectLoop());
    }
}
