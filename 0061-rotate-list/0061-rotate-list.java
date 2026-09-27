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
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        int d = k%len;
        if(d==0){
            return head;
        }
      
            ListNode temp = head;
            tail.next = head;
            int total = len - d- 1;
            ListNode newNode  = getKthNode(temp,total);
            head = newNode.next;
            newNode.next=null;
        
        return head;
    }
    public ListNode getKthNode(ListNode head, int total){
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        for(int i=0; i<total; i++){
            temp=temp.next;
        }
        return temp;
    }
}