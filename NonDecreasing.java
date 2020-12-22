// Hi, here's your problem today. This problem was recently asked by Microsoft:

// You are given an array of integers in an arbitrary order. Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.

// We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

// Example:

// [13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.

// [13, 4, 1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.
public class NonDecreasing {

    public static void main(String[] args){
        for(String list: args){
            String[] arrayString = list.replace(" ","").replace("[","")
                                                        .replace("]","")
                                                        .split(",");
            
            int[] numbers = new int[arrayString.length];
            for(int i  = 0; i < numbers.length; i++){
                numbers[i] = Integer.parseInt(arrayString[i]);
            }

            printIntArray(numbers);
            System.out.println(String.format(" => %1b",isNonDecreasing(numbers)));
        }
    }

    public static boolean isNonDecreasing(int[] numbers) {
        int changes = 0;

        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i] > numbers[i+1]){//a decrease was reached
                if(++changes > 1)
                    return false;
            }
        }
        return true;
    }
    
    /**
     * Print an int array on a single console line
     * @param array
     */
    private static void printIntArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i]+", ");
        }
        System.out.print(array[array.length - 1]+"]");
    }
}