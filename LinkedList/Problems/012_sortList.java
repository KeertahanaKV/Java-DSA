class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Solution {
    public static Node sortList(Node head) {
        // Dummy heads and tails for 0s, 1s, and 2s
        Node zeroD = new Node(0), oneD = new Node(0), twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;

        Node curr = head;

        // Step 1: Distribute nodes into three lists
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Step 2: Connect 0s -> 1s -> 2s
        zero.next = oneD.next != null ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        // New head is zeroD.next
        return zeroD.next;
    }
}
