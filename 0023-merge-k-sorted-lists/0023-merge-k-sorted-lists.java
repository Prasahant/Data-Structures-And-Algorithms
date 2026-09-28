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
    public ListNode mergeKLists(ListNode[] lists) {
        //return bruteForce(lists);
        return optimalApproach(lists);
    }
    public ListNode bruteForce(ListNode[] lists){
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i] ;
            while(temp!=null){
                list.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(list);
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        for(int num:list){
            temp.next = new ListNode(num);
            temp=temp.next;
        }
        return dummyNode.next;
    }
    public ListNode optimalApproach(ListNode[] lists){
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++){
            head = mergeList(head,lists[i]);
        }
        return head;
    }
    public ListNode mergeList(ListNode list1, ListNode list2){
        if (list1 == null) return list2;
        if (list2 == null) return list1;
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
                temp2 = temp2.next;
            }
            else{
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;

                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
            
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyNode.next;
    }
}