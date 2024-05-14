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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map=new HashMap<>();
        ListNode temp=head;
        while(temp!=null){
            map.put(temp.val,map.getOrDefault(temp.val,0)+1);
            temp=temp.next;
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        List<Integer> key=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()<2){
                key.add(entry.getKey());
            }
        }
        Collections.sort(key);
        for(int k:key){
            ListNode newnode=new ListNode(k);
            curr.next=newnode;
            curr=curr.next;
        }
        return dummy.next;
    }
}