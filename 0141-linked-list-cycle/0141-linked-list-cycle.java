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
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        // return bruteForce(head);
        return tortoiseOptimal(head);

    }
    public boolean bruteForce(ListNode head){
        HashMap<ListNode, Integer>map = new HashMap<>();
        
        ListNode temp=head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return true;
            }else{
                map.put(temp,1);
            }
            temp=temp.next;
        }
        return false;

    }
    public boolean tortoiseOptimal(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}