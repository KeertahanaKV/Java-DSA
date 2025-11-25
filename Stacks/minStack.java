//Linkedlist approch

class MinStack {

    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null)
            head = new Node(val,val,null);
        else
            head = new Node(val,Math.min(head.minVal,val),head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.minVal;
    }

    private class Node
    {
        int val;
        int minVal;
        Node next;
        public Node(int val,int minVal, Node next)
        {
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }



//Two stack approch

class MinStack {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> minst=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
           st.push(val);
           if(minst.isEmpty() || val<=minst.peek()){
              minst.push(val);
           } 
    }
    
    public void pop() {
        if(!st.isEmpty()){
          int  popped=st.pop();
           if(popped==minst.peek()){
            minst.pop();
        }
        } 
    }
   public int top() {
        if(!st.isEmpty())
       return st.peek();
       return -1;
    }
    
    public int getMin() {
        return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

    class MinStack {

    Stack<Integer> main;
    Stack<Integer> min;

    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        main.push(x);

        if (min.isEmpty()) {
            min.push(x);
        } else {
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        if (!main.isEmpty()) {
            main.pop();
            min.pop();
        }
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

