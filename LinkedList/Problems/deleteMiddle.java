class Solution {
    static{
        for(int i=0;i<100;i++){
            deleteMiddle(new ListNode(0));
        }}
    public static ListNode deleteMiddle(ListNode head) {
        
        if(head==null || head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null&& fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=prev.next.next;
        return head;

    }
}
