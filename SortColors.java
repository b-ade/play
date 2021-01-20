// Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note: You are not suppose to use the library’s sort function for this problem.

// Can you do this in a single pass?

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        System.out.println("Colors before sorting are "+Arrays.toString(colors));
        sortColors(colors);
        System.out.println("Colors after sorting are "+Arrays.toString(colors));
    }    

    static void sortColors(int[] colors){
        mergeSort(colors);
    }

    static void mergeSort(int[] array){
        if(array.length > 1){
            //split the array
            int middle = array.length/2;
            int[] left = Arrays.copyOfRange(array, 0, middle);
            int[] right = Arrays.copyOfRange(array, middle, array.length);
            mergeSort(left);
            mergeSort(right);

            //combine both
            int leftI = 0, rightI = 0;
            for (int i = 0; i < array.length; i++) {
                //handle potential overflows
                if(leftI >= left.length){//left sub array has been exhaustively inserter
                    array[i] = right[rightI++];
                    continue;
                }else if(rightI >= right.length){//right sub array has been exhaustively inserted
                    array[i] = left[leftI++];
                    continue;
                }

                if(left[leftI] < right[rightI])
                    array[i] = left[leftI++];
                else
                    array[i] = right[rightI++];
            }
        }
    }
}