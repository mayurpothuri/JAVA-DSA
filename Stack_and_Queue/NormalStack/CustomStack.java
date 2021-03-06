package Stack_and_Queue.NormalStack;

public class CustomStack {
    int tos; // keeps track of top element on stack
    int[] data;// elements storage for stack

    CustomStack(int n) {
        this.tos = -1;
        this.data = new int[n];
    }

    // if tos + 1 == capacity of "data" array then Stack Overflow
    public void push(int val) {
        if (this.tos + 1 == this.data.length) {
            System.out.println("Stack overflow");
        } else {
            this.data[++this.tos] = val;
        }
        return;
    }

    // if tos == -1 then Stack underflow, as the stack is empty and nothing to pop
    // out.
    public int pop() {
        if (this.tos == -1) {
            System.out.println("Stack underflow");
        } else {
            int val = this.data[this.tos--];
            return val;
        }
        return -1;
    }

    public int top() {
        if (this.tos == -1) {
            System.out.println("Stack underflow");
        } else {
            return this.data[this.tos];
        }
        return -1;
    }

    // tos + 1 gives the size of stack as 0 - based counting is there
    public int size() {
        return this.tos + 1;
    }

    // from end to start of "data" array, print the elements
    public void display() {
        for (int i = this.size() - 1; i >= 0; i--) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
        return;
    }
}
