import java.util.Arrays;

// You are given an array of integers. Return the smallest positive integer that is not present in the array. The array may contain duplicate entries.

// For example, the input [3, 4, -1, 1] should return 2 because it is the smallest positive integer that doesn't exist in the array.

// Your solution should run in linear time and use constant space.


public class FirstMissingPositiveInteger {
    public static void main(String[] args) {
        int[] input = {4,-1,1,2,5};
        System.out.println("First missing positive integer in "+Arrays.toString(input)+" is "+findMissingFirstPositive(input));
    }

    static int findMissingFirstPositive(int[] array){
        int missing = 1;//assume one is first positive missing

        //sort the array first 
        quickSort(array,0,array.length - 1);//quick sort because of complexity requirements

        //iterate through array, for every element equal to our guess, increment guess by one
        //creeping our guess helps find the smallest possible value
        for (int i = 0; i < array.length; i++) {
            if(array[i] == missing)
                missing++;
            if(array[i] > missing)//because array is sorted
                break;//no need to continue checking
        }
        return missing;
    }

    static void quickSort(int[] array, int start, int end){
        if(start >= end)//single element array
            return;//do nothing

        int pivot = end;
        int leftPointer = start-1, rightPointer = end;
        
        //move pivot element into place
        while(true){
            while(++leftPointer < end &&  array[leftPointer] <= array[pivot]){}
            while(--rightPointer > start && array[rightPointer] > array[pivot]){}
            
            if(leftPointer >= rightPointer){
                if(array[leftPointer] > array[pivot])
                    swap(array, leftPointer, pivot);
                break;
            }

            swap(array, leftPointer, rightPointer);
        }

        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }

    static void swap(int[] array,int a, int b){
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}