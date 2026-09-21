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
    public ListNode reverseList(ListNode head) {
        //return iterativeMethod(head);
        return recursiveMethod(head);
    }
    public ListNode iterativeMethod(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;
        
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp=front;
        }
        return prev;
    }
    public ListNode recursiveMethod(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newNode = recursiveMethod(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next= null;
        return newNode;
    }
}