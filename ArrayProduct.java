import java.util.Arrays;

// You are given an array of integers. Return an array of the same size where the element at each index is the product of all the elements in the original array except for the element at that index.

// For example, an input of [1, 2, 3, 4, 5] should return [120, 60, 40, 30, 24].

// You cannot use division in this problem.

public class ArrayProduct {
   
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(array)+" => "+Arrays.toString(get(array)));
    }

    //modify ofiginal 
    static int[] get(int[] array) {
        int[] result = new int[array.length];
        int product = 1,zeroCount = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0)
                product *= array[i];
            else if(++zeroCount > 1)//having more than one zeros would guarantee all elements are 0
                return result;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){//current element is 0
                if(zeroCount > 1){//if there are more than one 0's in the array
                    result[i] = 0;//we would still have zero
                } else {//there was only one 0 in the array
                    result[i] = product;//result of product without factoring element at index is product
                }
            }else{
                if(zeroCount > 0){//there was a zero
                    result[i] = 0; // actual product should be zero
                } else {
                    result[i] = product / array[i];
                }
            }
        }
        return result;
    }
}