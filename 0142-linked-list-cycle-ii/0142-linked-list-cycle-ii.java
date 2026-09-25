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
            return null ;
        }
        //return bruteForce(head);
        return tortoisAndHare(head);
    }
    public ListNode bruteForce(ListNode head){
        HashMap<ListNode, Integer>map = new HashMap<>();
        int counter = 0;
        ListNode temp=head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return temp;
            }else{
                map.put(temp,counter);
                counter++;
            }
            temp=temp.next;
        }
        return temp ;

    }
    public ListNode tortoisAndHare(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                fast = head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}