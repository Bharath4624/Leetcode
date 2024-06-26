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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1,o2)->{
            return o1.val-o2.val;
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.offer(lists[i]);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            temp.next=curr;
            temp=temp.next;
            if(curr.next!=null){
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}