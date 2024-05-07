class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode newhead=new ListNode();
        newhead.next=head;
        ListNode left=newhead;
        ListNode right=head;
        while(right!=null){
            if(right.val*2>=10){
                left.val+=1;
            }
            right.val=(right.val*2)%10;
            left=left.next;
            right=right.next;
        }
        if(newhead.val>0){
            return newhead;
        }
        return head;
    }
}
