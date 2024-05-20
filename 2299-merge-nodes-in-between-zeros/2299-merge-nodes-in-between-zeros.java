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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(temp!=null && temp.val==0){
            int sum=0;
            temp=temp.next;
            while(temp!=null && temp.val!=0){
                sum+=temp.val;
                temp=temp.next;
            }
            if(sum!=0){
            ListNode node=new ListNode(sum);
            curr.next=node;
            curr=curr.next;
            }
        }
        return dummy.next;
    }
}