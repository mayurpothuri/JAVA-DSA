package Stack_and_Queue.DynamicStack;

public class CustomStack {

    int tos;
    int[] data;

    CustomStack(int n) {
        this.tos = -1;
        this.data = new int[n];
    }

    public void push(int val) {
        if (this.tos + 1 == this.data.length) {
            int[] newData = new int[2 * this.data.length];
            int i = 0;
            for (; i < this.data.length; i++) {
                newData[i] = this.data[i];
            }
            newData[i] = val;
            this.tos = i;
            this.data = newData;
        } else {
            this.data[++this.tos] = val;
        }
        return;
    }

    public int pop() {
        if (this.tos == -1) {
            System.out.println("Stack underflow");
        } else {
            return this.data[this.tos--];
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

    public int size() {
        return this.tos + 1;
    }

    public void display() {
        for (int i = this.size() - 1; i >= 0; i--) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
        return;
    }
}
