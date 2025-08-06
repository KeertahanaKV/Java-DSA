//To FInd the Length of the Linked List
class Solution {
    public int countLoopLength(ListNode head) {
        if (head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                return countLength(slow);
            }
        }

        // No cycle
        return 0;
    }

   
