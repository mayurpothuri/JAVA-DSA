package Stack_and_Queue.MinStackI;

import java.util.Stack;

public class MinStack {

    Stack<Integer> allData;
    Stack<Integer> minData;

    public MinStack() {
        allData = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int val) {
        if (allData.empty()) {
            minData.push(val);
        } else {
            minData.push(Math.min(val, minData.peek()));
        }
        allData.push(val);
        return;
    }

    public int pop() {
        if (allData.empty()) {
            System.out.println("Stack underflow");
        } else {
            minData.pop();
            return allData.pop();
        }
        return -1;
    }

    public int top() {
        if (allData.empty()) {
            System.out.println("Stack underflow");
        } else {
            return allData.peek();
        }
        return -1;
    }

    public int size() {
        return allData.size();
    }

    public int min() {
        if (minData.empty()) {
            System.out.println("Stack underflow");
        } else {
            return minData.peek();
        }
        return -1;
    }
}
