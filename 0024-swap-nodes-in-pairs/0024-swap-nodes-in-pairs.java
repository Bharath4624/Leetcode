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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode point=temp;
        while(point.next!=null && point.next.next!=null){
            ListNode first=point.next;
            ListNode second=point.next.next;
            first.next=second.next;
            second.next=first;
            point.next=second;
            point=first;
        }
        return temp.next;
    }
}