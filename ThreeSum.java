// Given an array, nums, of n integers, find all unique triplets (three numbers, a, b, & c) in nums such that a + b + c = 0. Note that there may not be any triplets that sum to zero in nums, and that the triplets must not be duplicates.

// Example:
// Input: nums = [0, -1, 2, -3, 1]
// Output: [0, -1, 1], [2, -3, 1]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] numbers = {0, -1, 2, -3, 1};
        List<int[]> trplets = get(numbers);
        System.out.println(Arrays.deepToString(trplets.toArray()));
    }

    static List<int[]> get(int[] numbers) {
        List<int[]> tr = new ArrayList<>();
        for (int a = 0; a < numbers.length - 2; a++) {
            for (int b = a + 1; b < numbers.length - 1; b++) {
                for (int c = b + 1; c < numbers.length; c++) {
                    if(numbers[a] + numbers[b]  + numbers[c] == 0){
                        int[] ti = {numbers[a] , numbers[b]  , numbers[c]};
                        
                        //since values sum up to zero, use magnitude in either polarity to check existence before inserting
                        int posMag = 0,negMag = 0;

                        for (int i = 0; i < ti.length; i++) {
                            if(ti[i] > 0)
                                posMag += ti[i];
                            else if(ti[i] < 0)
                                negMag -= ti[i];
                        }
                        boolean newEntry = true;

                        for (int[] is : tr) {
                            int currentPosMag = 0,currentNegMag = 0;
                            for (int i = 0; i < is.length; i++) {
                                if(is[i] > 0)
                                    currentPosMag += is[i];
                                else if(is[i] < 0)
                                    currentNegMag -= is[i];
                            }

                            newEntry &= (currentPosMag != posMag && currentNegMag != negMag);
                            if(!newEntry)//if magnitude already exists,
                                break;//do not insert
                        }

                        if(newEntry)
                            tr.add(ti);
                    }
                }
            }
        }
        return tr;
    }
}