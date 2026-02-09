/*
Design a stack class that supports the push, pop, top, and getMin operations.

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

*/
import java.util.*;
class MinStack {
    Stack<Integer> mystack;
    public MinStack() {
        mystack=new Stack<>();
    }
    
    public void push(int val) {
        mystack.push(val);
    }
    
    public void pop() {
          mystack.pop(); 
    }
    
    public int top() {
      return mystack.peek(); 
    }
    
    public int getMin() {
        int min=mystack.firstElement();
        for(int i:mystack)
        {
            if(i<min)
            {
                min=i;
            }
        }
        return min;
    }
}
