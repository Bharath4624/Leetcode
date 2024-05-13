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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevlast=null;
        while(temp!=null){
            ListNode kthnode=getkth(temp,k);
            if(kthnode==null){
                if(prevlast!=null){
                    prevlast.next=temp;
                }
                break;
            }
            ListNode nextnode=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthnode;
            }
            else{
                prevlast.next=kthnode;
            }
            prevlast=temp;
            temp=nextnode;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public ListNode getkth(ListNode head,int k){
        k-=1;
        ListNode temp=head;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
}