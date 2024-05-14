/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=iscycle(head);
        ListNode slow=head;
        if(fast!=null && fast.next!=null){
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
    public ListNode iscycle(ListNode head){
    ListNode fast=head;
    ListNode slow=head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
        if(slow==fast){
            return fast;
        }
    }
    return null;
    }
}