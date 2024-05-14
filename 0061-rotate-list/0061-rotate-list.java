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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0){
            return head;
        }
        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        if(k%len==0){
            return head;
        }
        k=k%len;
        temp.next=head;
        ListNode kthnode=find(head,len-k);
        head=kthnode.next;
        kthnode.next=null;
        return head;
    }
    public ListNode find(ListNode head,int k){
        int count=1;
        while(head!=null){
            if(count==k){
                return head;
            }
            count++;
            head=head.next;
        }
        return head;
    }
}