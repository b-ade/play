// You are given an array of integers. Find the maximum sum of all possible contiguous subarrays of the array.

// Example:

// [34, -50, 42, 14, -5, 86]

// Given this input array, the output should be 137. The contiguous subarray with the largest sum is [42, 14, -5, 86].

// Your solution should run in linear time.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxContiguousSubArraySum {

    public static void main(String[] args) {
        int[] testArray = {34, -50, 42, 14, -5, 86};
        int[] result = getResult(testArray);
        System.out.println("Contiguous array of "+Arrays.toString(testArray)+"\nproducing max sum ranges in index from "+result[0]+" -> "+result[1]+"\nas "+Arrays.toString(Arrays.copyOfRange(testArray, result[0], result[1] + 1))+"\nsum is "+result[2]);
    }   

    //return the start and end index of the contiguous subarray with the max sum
    static int[] getResult(int[] array){
        int subArraysCount = 0;
        int subArrayEnd = 0, sum = 0; 

        int[] result = { -1, -1 , 0};//subarray-start,subarray-end,max

        Map<String,Integer> memo = new HashMap<>();
        
        for (int subArraySize = array.length - 1 ; subArraySize >= 0 ; subArraySize--) {
            subArraysCount = array.length - subArraySize + 1;
            for (int subArrayStart = 0; subArrayStart < subArraysCount; subArrayStart++) {
                subArrayEnd = subArrayStart + subArraySize - 1;
                sum = subArraySum(array,subArrayStart, subArrayEnd,memo);
                if(sum > result[2]){
                    result = new int[]{ subArrayStart, subArrayEnd, sum};
                }
            }
        }
        return result;
    }
    
    static int subArraySum(int[] array, int startIndex,int endIndex, Map<String, Integer> memo) {
        int sum = 0;
        int subArrayLength = endIndex - startIndex + 1;
        String subArrayKey = startIndex + "-"+subArrayLength;
        if(startIndex < (endIndex - 1)){//start memoing from two elements upwards
            if(memo.containsKey(subArrayKey))
                return memo.get(subArrayKey);
            else{
                sum = array[startIndex] + subArraySum(array,startIndex + 1, endIndex,memo);
                memo.put(subArrayKey, sum);
                return sum;
            }
        }

        for (int i = startIndex; i <= endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
}