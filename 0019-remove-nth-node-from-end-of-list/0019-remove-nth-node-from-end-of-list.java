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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        //return bruteForce(head, n);
        return optimalApproach(head, n);
    }
    public ListNode bruteForce(ListNode head, int n){
        
        
        int cnt = 0;
        ListNode temp = head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        int num =cnt-n;
        if(num==0){
            return head.next;
        }
        cnt = 0;
        temp = head;
        while(temp.next!=null){
            cnt++;
            if(cnt==num){
                temp.next = temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public ListNode optimalApproach(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0; i<n; i++){
            fast=fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast=fast.next;
        }
        ListNode delnode = slow.next;
        slow.next = delnode.next;
        return head;
    }
}