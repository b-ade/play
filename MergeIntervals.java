import java.util.Arrays;

// You are given an array of intervals - that is, an array of tuples (start, end). The array may not be sorted, and could contain overlapping intervals. Return another array where the overlapping intervals are merged.

// For example:
// [(1, 3), (5, 8), (4, 10), (20, 25)]

// This input should return [(1, 3), (4, 10), (20, 25)] since (5, 8) and (4, 10) can be merged into (4, 10).

public class MergeIntervals {
    static class Interval{
        int a, b;

        public Interval(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return String.format("(%1d, %2d)", a,b);
        }
    }
    public static void main(String[] args) {
        Interval[] intervals = {
            new Interval(1, 3), new Interval(5, 8), new Interval(4, 10), new Interval(20, 25)
        };
        System.out.println("Collapsed intervals are "+Arrays.toString(getCollapsed(intervals)));
    }

    static Interval[] getCollapsed(Interval[] intervals){
        int invalidated = 0;
        Interval[] temp = Arrays.copyOf(intervals, intervals.length);
        for (int i = 0; i < temp.length; i++) {
            for (Interval interval : temp) {
                if(temp[i] == null || interval == null || interval == temp[i])
                    continue;

                if(interval.a <= temp[i].a && temp[i].b <= interval.b){
                    temp[i] = null;
                    invalidated ++;
                }
            }   
        }
        Interval[] tr = new Interval[intervals.length - invalidated];
        int i = 0;
        for (Interval interval : temp) {
            if(interval != null)
                tr[i++] = interval;
        }
        return tr;
    }
}