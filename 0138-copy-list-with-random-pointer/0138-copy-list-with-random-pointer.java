/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //return bruteForce(head);
        return optimalApproach( head);
    }

    public Node bruteForce(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }
    public Node optimalApproach(Node head){
        Node temp = head;
        while(temp!=null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(temp!=null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}