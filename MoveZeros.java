// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

import java.util.Arrays;

public class MoveZeros{

    public static void main(String[] args) {
        int[][] arrays = {
            {0,1,0,3,12},
            {0,1,0,0,3,12},
            {0,0,0,0,0,0,0,1,0,0,3,12},
            {0,0,98,0,0,0,0,1,0,0,3,0,0,0,34,0,0,123,0,0,023,0,0,12}
        };

        for (int[] array : arrays) {
            System.out.println("Would move zeros on "+Arrays.toString(array));
            moveZeros(array);
            System.out.println("Result: "+Arrays.toString(array)+"\n");            
        }
    }

    static void moveZeros(int[] array){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                //get how many contiguous zeros
                int j = i,zeroCounts = 1;
                while(++j < array.length && array[j] == 0){
                    zeroCounts++;
                }

                int indexHondingZero = i;//zeros where the next non-zeros would move to
                int counter = 0;//guard so we move only as many non zeros as there are zeros

                //iteration for the move
                for (int k = i + zeroCounts; k < array.length; k++) { 
                    if(array[k] == 0){//we aren't moving zeros
                       zeroCounts++;//but we need to adjust the number of zeros to be moved
                        continue;
                    }
                    array[indexHondingZero++] = array[k];
                    array[k] = 0;
                    if(++counter >= zeroCounts)
                        break;
                }

                i += zeroCounts - 1;//advance over non-zeros moved left to the index where zeros now start
            }
        }
    }
}