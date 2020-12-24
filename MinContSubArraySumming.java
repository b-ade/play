// Hi, here's your problem today. This problem was recently asked by Amazon:

// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

// Example:
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2

public class MinContSubArraySumming {
    public static void main(String[] args) {
        System.out.println(findLengthMinContSubArray(new int[]{2,3,1,2,4,3}, 7))   ;
    }

    public static int findLengthMinContSubArray(int[] mainArray,int targetSum){
        int currentSize = 2;
        int iterationsForCurrentSize;
        while(currentSize < mainArray.length){
            iterationsForCurrentSize = mainArray.length - currentSize;
            
            //for each subarray of the current test size
            for(int i = 0; i <= iterationsForCurrentSize; i++){
                int sum = 0;//sum of elements in current subarray
                for (int j = i; j < i + currentSize; j++) {
                    sum += mainArray[j];
                    if(sum >= targetSum)
                        return currentSize;
                }

            }
            currentSize++;
        }
        return 0;
    }    
}