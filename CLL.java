// Circular Linked List Implementation in Java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Insert after a specific value
    public void insertAfter(int key, int data) {
        if (head == null) return;

        Node current = head;
        do {
            if (current.data == key) {
                Node newNode = new Node(data);
                newNode.next = current.next;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Delete a node by value
    public void delete(int key) {
        if (head == null) return;

        Node current = head, prev = null;

        // If head is to be deleted
        if (head.data == key) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        // Search for the node to delete
        do {
            prev = current;
            current = current.next;
            if (current.data == key) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                return;
            }
        } while (current != head);
    }

    // Search for a value
    public boolean search(int key) {
        if (head == null) return false;

        Node temp = head;
        do {
            if (temp.data == key) return true;
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    // Reverse the circular linked list
    public void reverse() {
        if (head == null || head.next == head) return;

        Node prev = tail, current = head, next;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        tail = head;
        head = prev;
        tail.next = head;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insertAtBeginning(5);
        cll.insertAfter(20, 25);

        System.out.println("Circular Linked List:");
        cll.display();

        System.out.println("Search 25: " + cll.search(25));
        System.out.println("Search 100: " + cll.search(100));

        cll.delete(20);
        System.out.println("After deleting 20:");
        cll.display();

        cll.reverse();
        System.out.println("After reversing:");
        cll.display();
    }
}
