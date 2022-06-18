package Stack_and_Queue.MinStackII;

import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    // so if top of stack >= min then top of stack is normal and min can be minimum
    // of both
    // if val < top of stack then, min = val and top of stack should be less than
    // min to distinguish if the top value is popped out then we need previous min
    // value.
    public void push(int val) {
        if (st.empty()) {
            st.push(val);
            min = val;
        } else if (val >= min) {
            // here val >= min case
            //
            st.push(val);
        } else {
            // val < min case
            // so val - min is also less than min
            st.push(val - min);
            // since val was less than min,
            min = val;
        }
        return;
    }

    public int pop() {
        if (st.empty()) {
            System.out.println("Stack underflow");
        } else if (min <= st.peek()) {
            // here top of stack >= min then the top of stack can be popped out and min
            // won't be affected as min is below those the top of stack value.
            return st.pop();
        } else {
            // val < min case
            // here we know that the original top of stack value is min, but when popping
            // out top of stack value, we need updated min for previous stack values. As the
            // top of stack is = val - min, so if min - top of stack is performed then we
            // get the updated min for previous stack values.
            int val = min;
            min = min - st.pop();
            return val;
        }
        return -1;
    }

    public int top() {
        if (st.empty()) {
            System.out.println("Stack underflow");
        } else if (min <= st.peek()) {
            return st.peek();
        } else {
            // min > top of stack then min was the top of the stack
            return min;
        }
        return -1;
    }

    public int size() {
        return st.size();
    }

    public int min() {
        if (st.empty()) {
            System.out.println("Stack underflow");
        } else {
            return min;
        }
        return -1;
    }
}
