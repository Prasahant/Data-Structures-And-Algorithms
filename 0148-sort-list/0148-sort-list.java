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
    public ListNode sortList(ListNode head) {
        return mergeSortApproach(head);
    }  
    public ListNode mergeSortApproach(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        leftHead = mergeSortApproach(leftHead);
        rightHead = mergeSortApproach(rightHead);

        return merge2List(leftHead, rightHead);

    }
    public ListNode middleNode(ListNode head){
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public ListNode merge2List(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            }
            else if(temp1.val>temp2.val){
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp.next;
            }
            else{
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;

                temp.next = temp2;
                temp = temp.next;
                temp2 = temp.next;
            }
            
        }
        if(temp1!=null){
            temp.next = temp1;
        }
        else if(temp2 != null){
            temp.next = temp2;
        }
        return dummyNode.next;
    }
}