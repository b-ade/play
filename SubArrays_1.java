// given an array, write a function to print all the subsets of that array. 

// For Example :

// input: [1,2,3,4]
// output: 
// 1 
// 1,2
// 1,3
// 1,4
// 1,2,3
// 1,2,4
// 1,2,3,4
// 2,
// 2,3
// 2,4
// 2,3,4
// 3,
// 3,4
// 4

/**
 * Same implementation as {@link SubArrays} but with O(n) space
 */
public class SubArrays_1{
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        printSubArrays(array);
    }
    
    static void printSubArrays(int[] array){
        for (int i = 0; i < array.length; i++) {            
            printSubArray(array,i,i);
            System.out.println();

            //length of a conceptual sub array (level 1)which would be further broken down
            int subArrayL1Length = array.length - i;

            //pretend expand a subarray of the subarray at level 1 -> level 2
            for (int j = 0; j <= subArrayL1Length; j++) {
                int outtersCount = subArrayL1Length - 1 - j;
                for (int k = 1; k <= outtersCount; k++) {//iterate through the elements left in level 2 after this pretend expansion

                    printSubArray(array,i,i+j);//actual print the expanded level 2
                    System.out.println(","+array[i+j+k]);//pad it with the element from the current iteration of remanding elements in level 2
                }
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