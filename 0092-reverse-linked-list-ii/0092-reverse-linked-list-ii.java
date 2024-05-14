/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode leftprev=dummy;
        for(int i=0;i<left-1;i++){
            curr=curr.next;
            leftprev=leftprev.next;
        }
        ListNode prev=null;
        ListNode newhead=curr;
        for(int i=0;i<right-left+1;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        newhead.next=curr;
        leftprev.next=prev;
        return dummy.next;
    }
}