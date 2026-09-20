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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //return bruteForceMethod(head);
        return optimalMethod(head);
    }
    public ListNode bruteForceMethod(ListNode head){
        ArrayList<Integer>list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp!=null){
            list.add(temp.val);
        }
        temp = head.next;
        while(temp!=null && temp.next!=null){
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp!=null){
            list.add(temp.val);
        }
        temp = head;
        for(int i=0; i<list.size();i++){
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
    public ListNode optimalMethod(ListNode head){
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead= head.next;
        while(even!=null &&  even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next; 
        }
        odd.next = evenHead;
        return head;
    }
}