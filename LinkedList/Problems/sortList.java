class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Split list into two halves using slow-fast pointer
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;  // Split the list into 2 halves

        // Step 2: Recursively sort each half
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Helper to find middle node
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev; // Return the node before the actual mid
    }

    // Helper to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
