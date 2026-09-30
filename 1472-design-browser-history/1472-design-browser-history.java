class Node {
    String val;
    Node next;
    Node prev;
    public Node(String val) { 
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage) {
        this.curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node nextPage = new Node(url);
        curr.next = nextPage;
        nextPage.prev = curr;
        curr = nextPage;

    }
    
    public String back(int steps) {
        while(steps>0){
            if(curr.prev!=null){
                curr=curr.prev;
                steps--;
            } else{
                break;
            }
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(steps>0){
            if(curr.next!=null){
                curr = curr.next;
                steps--;
            }
            else{
                
                break;
            }
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */