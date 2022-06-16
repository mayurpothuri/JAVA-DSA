package Stack_and_Queue.MergeOverlapInterval;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlapInterval {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] intervals = new int[n][2];
        String line = "";
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            intervals[i][0] = Integer.parseInt(line.split(" ")[0]);
            intervals[i][1] = Integer.parseInt(line.split(" ")[1]);
        }
        getMergeOverlapInterval(intervals);
        br.close();
        return;
    }

    // implement the comparable interface where the object to be compared if of Pair
    // type
    static class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;

        Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // for sorting in increasing order
        // this > p then return +ve
        // this == p then return 0
        // this < p then return -ve
        @Override
        public int compareTo(Pair p) {
            // if start time is not equal for some object[here it is "interval start times"]
            // then this.startTime is smaller then place it before p.startTime
            if (this.startTime != p.startTime) {
                return this.startTime - p.startTime;
            }
            // if start times are equal then smaller end time must come before other end
            // time
            else {
                return this.endTime - p.endTime;
            }
        }
    }

    // time-complexity - O(n)
    private static void getMergeOverlapInterval(int[][] intervals) {

        Pair[] pairs = new Pair[intervals.length];
        Pair p;
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        // used dual pivot quick sort algo
        // in order to use the in-built sorting algo, we need to be able to compare the
        // pair object with respect to some parameter. So sort it as per the starting
        // time in increasing order.
        Arrays.sort(pairs);

        for (int i = 0; i < pairs.length; i++) {
            // if first pair then push it on stack
            if (i == 0) {
                st.push(pairs[i]);
            }
            // if other than first pair then check if the pair's end time on top of stack is
            // less than the current pair's start time, if yes then those intervals aren't
            // overlapping so push onto the stack for comparison for other pairs.
            else if (st.peek().endTime < pairs[i].startTime) {
                st.push(pairs[i]);
            }
            // this case handles the overlap, pick the max of end times of overlapped
            // intervals and update the top of stack's pair end time with it as the pairs we
            // are looping through is in sorted order with respect to start time and then
            // push the updated pair to stack for comparison for other pairs.
            else {
                p = st.pop();
                p.endTime = (int) (Math.max(pairs[i].endTime, p.endTime));
                st.push(p);
            }
        }
        // since the all the non-overlapping intervals in stack are in reverse order, so
        // un-reverse it.
        pairs = new Pair[st.size()];
        for (int index = pairs.length - 1; !st.empty(); index--) {
            pairs[index] = st.pop();
        }
        // print the non-overlapping intervals in-order.
        for (Pair pair : pairs) {
            System.out.println(pair.startTime + " " + pair.endTime);
        }
        return;
    }
}
