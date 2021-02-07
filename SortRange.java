import java.util.Arrays;

// Given a list of integers, return the bounds of the minimum range that must be sorted so that the whole list would be sorted.

// Example:
// Input: [1, 7, 9, 5, 7, 8, 10]
// Output: (1, 5)

//from the violator to the end, the second index would be identified by the element

public class SortRange {
    
    public static void main(String[] args) {
        int[] numbers = {1, 7, 9, 5, 7, 18, 8, 10,34,2};
        int[] range = getRange(numbers);
        System.out.println("Ranges required for sorting "+Arrays.toString(numbers)+" are "+Arrays.toString(range));
    }

    //assuming the requirement is to have numbers sorted in ascending order
    static int[] getRange(int[] numbers){
        int[] rangeIndices = {-1,-1};

        //1, 7, 9, 5, 7, 8, 10
        //find the first element that violates ordering
        //then the first index would be the index of the first element greater than the violating element
        //iterate from violator the the end of array, the last encountered element that is less than the largest element before the violator produces the second index

        int largestBeforeViolator = -1, indexOfViolator = 0;
        for (int i = 1; i < numbers.length - 1; i++) {
            if(numbers[i] < numbers[i-1]){
                indexOfViolator = i;
                largestBeforeViolator = numbers[0];//temp init
                
                //iterate for all elements preceeding the violator
                for (int j = 0; j < i; j++) {
                    if(rangeIndices[0] == -1 && numbers[j] > numbers[i]){//if we haven't noted first index in range and we've encountered a number greater than our violator
                        rangeIndices[0] = j;//note the first index in range
                    }
                
                    if(numbers[j] > largestBeforeViolator)//continually check and set largest
                        largestBeforeViolator = numbers[j];//element occuring before violator
                }
                break;
            }
        }
        //first index has been found and largest element greater than violator found

        //iterate from violator till end of array
        int maxAfterViolator = numbers[indexOfViolator];
        for (int i = indexOfViolator; i < numbers.length; i++) {
            //any element after the violator element that is less that the largest element before the violator
            //or that breaks naturan ordering would extend our range further to right
            if(numbers[i] < largestBeforeViolator || numbers[i] < maxAfterViolator)
                rangeIndices[1] = i;

            if(numbers[i] > maxAfterViolator)//keep track of biggest element after the violator
                maxAfterViolator = numbers[i];
        }

        return rangeIndices;
    }
}