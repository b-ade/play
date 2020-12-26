// given an array, write a function to print all the subsets of that array. 

// For Example :

// input: [1,2,3,4]
// output: 
// 1 
// 1,2
// 1,3
// 1,4
// 1,2,3
//appears 1,2,4 should be here
// 1,2,3,4
// 2,
// 2,3
// 2,4
// 2,3,4
// 3,
// 3,4
// 4


public class SubArrays{
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        printSubArrays(array);
    }
    
    static void printSubArrays(int[] array){
        for (int i = 0; i < array.length; i++) {
            int subArrayLength = array.length - i;

            //create sub array and send it down the pipe
            int[] aSub = new int[subArrayLength];
            for(int j = 0; j < subArrayLength; j++){
                aSub[j] = array[i + j];
            }
            printSubArrays2(aSub);
        }
    }
    
    static void printSubArrays2(int[] array){
        printSubArray(array,0,0);
        System.out.println();

        //pretend expand a subarray of array
        for (int i = 0; i <= array.length; i++) {
            int outtersCount = array.length - 1 - i;
            for (int j = 1; j <= outtersCount; j++) {//iterate through the elements left in array after this pretend expansion

                printSubArray(array,0,i);//actual print the expanded subarray of array
                System.out.println(","+array[i+j]);//pad it with the current element from the current iteration of remanding elements in array
            }
        }
    }
    
    /**
     * Print elements of 
     * @param array a given array
     * @param startIndex starting index
     * @param endIndex ending (inclusive) index
     */
    static void printSubArray(int[] array,int startIndex, int endIndex){
        String string = "";
        for(int i = startIndex; i < endIndex; i++){
            string += array[i]+",";
        }
        string += array[endIndex];
        System.out.print(string);
    }
}