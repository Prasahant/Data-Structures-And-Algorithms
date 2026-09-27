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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ArrayList<Integer>list = new ArrayList<>();

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                list.add(temp1.val);
                temp1 = temp1.next;
            }
            else if(temp1.val>temp2.val){
                list.add(temp2.val);
                temp2=temp2.next;
            }
            else{
                list.add(temp1.val);
                list.add(temp2.val);
                temp1=temp1.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            list.add(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            list.add(temp2.val);
            temp2=temp2.next;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        for (int num : list) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        ListNode newhead = head.next;
        return newhead;

    }
}