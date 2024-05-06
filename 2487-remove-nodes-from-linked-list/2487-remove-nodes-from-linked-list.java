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
    public ListNode removeNodes(ListNode head) {
        ListNode temp = reverse(head);
        ListNode curr = temp;
        ListNode prev = temp;
        int max = temp.val;
        while(curr!=null){
            if(curr.val<max){
                prev.next = curr.next;
            }
            else if(curr.val>=max){
                max = curr.val;
                prev = curr;
                
            }
            curr = curr.next;
        }
        temp = reverse(temp);
        return temp;
        
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}