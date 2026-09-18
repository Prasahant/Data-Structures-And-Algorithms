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
}