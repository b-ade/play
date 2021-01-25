// You are given a stream of numbers. Compute the median for each new element .

// Eg. Given [2, 1, 4, 7, 2, 0, 5], the algorithm should output [2, 1.5, 2, 3.0, 2, 2, 2]

public class MedianStream{
    
    public static void main(String[] args) {
        int[] stream = {2,1,4,7,2,0,5};
        int[] sorted = {};
        String result = "";

        for (int i : stream) {
            //insert the next element into its sorted position
            sorted = insertIntoArray(sorted,i);

            int maxIndex = sorted.length -1;//use to determine how median would be extracted

            if(maxIndex % 2 == 0){
                result += sorted[(sorted.length - 1)/2] + "  ";
            }else{
                int firstIndex = (sorted.length - 1)/2;
                float first = sorted[firstIndex], second = sorted[firstIndex+1];
                result += (first+second)/2 + "  ";
            }
        }
        
        System.out.println("Stream is "+result);
    }

    static int[] insertIntoArray(int[] array, int newElement){
        if(array.length == 0)
            return new int[]{newElement};
    
        int[] tr = new int[array.length + 1];
        
        int switchIndicator = 0;//use to determine when new element is inserted, as well as ensure the right index in the original array is targeted
        int originalArrayIndex = 0;//use to get the right index in original array

        for (int i = 0; i < tr.length; i++) {
            originalArrayIndex = i + switchIndicator;

            //if we have parsed the original array, and new element isn't inserted still
            if(i == array.length && switchIndicator == 0){
                tr[i] = newElement;
                continue;
            }

            //element from original array is less than or equal to new element, straight insert
            //or if we have inserted the new element
            if(array[originalArrayIndex] <= newElement || switchIndicator < 0){
                tr[i] = array[originalArrayIndex];
                continue;
            }

            //first element from original array that is greater than new element
            //insert new element instead and set indicator variable
            if(array[originalArrayIndex] > newElement){
                tr[i] = newElement;
                switchIndicator--;
            }

        }
        return tr;
    }
}