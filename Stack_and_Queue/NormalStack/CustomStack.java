package Stack_and_Queue.NormalStack;

public class CustomStack {
    int tos; // keeps track of top element on stack
    int[] data;// elements storage for stack

    CustomStack(int n) {
        tos = -1;
        this.data = new int[n];
    }

    // if tos + 1 == capacity of "data" array then Stack Overflow
    public void push(int val) {
        if (tos + 1 == this.data.length) {
            System.out.println("Stack overflow");
        } else {
            this.data[++tos] = val;
        }
        return;
    }

    // if tos == -1 then Stack underflow, as the stack is empty and nothing to pop
    // out.
    public int pop() {
        if (tos == -1) {
            System.out.println("Stack underflow");
        } else {
            int val = data[tos--];
            return val;
        }
        return -1;
    }

    public int top() {
        if (tos == -1) {
            System.out.println("Stack underflow");
        } else {
            return data[tos];
        }
        return -1;
    }

    // tos + 1 gives the size of stack as 0 - based counting is there
    public int size() {
        return tos + 1;
    }

    // from end to start of "data" array, print the elements
    public void display() {
        for (int i = tos; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        return;
    }
}
