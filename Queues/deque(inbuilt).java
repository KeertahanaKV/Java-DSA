// Insert at front	addFirst(element)
// Insert at rear	addLast(element)
// Delete from front	removeFirst()
// Delete from rear	removeLast()
// Peek front	peekFirst()
// Peek rear	peekLast()
// Check empty	isEmpty()
// Size	size()
// Display all	Use loop (like for-each)

import java.util.Deque;
import java.util.ArrayDeque;

public class BuiltInDequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Insert at rear
        deque.addLast(10);
        deque.addLast(20);

        // Insert at front
        deque.addFirst(5);
        deque.addFirst(2);

        // Display
        System.out.println("Deque: " + deque); // [2, 5, 10, 20]

        // Delete from front
        deque.removeFirst(); // removes 2
        System.out.println("After removeFirst: " + deque); // [5, 10, 20]

        // Delete from rear
        deque.removeLast(); // removes 20
        System.out.println("After removeLast: " + deque); // [5, 10]

        // Peek front and rear
        System.out.println("Front: " + deque.peekFirst()); // 5
        System.out.println("Rear: " + deque.peekLast());   // 10

        // Check size and empty
        System.out.println("Size: " + deque.size());
        System.out.println("Is empty? " + deque.isEmpty());

        // Loop to display elements
        System.out.print("All elements: ");
        for (int num : deque) {
            System.out.print(num + " ");
        }
    }
}
