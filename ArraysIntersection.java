import java.util.Arrays;
import java.util.regex.Pattern;

// Given two arrays, write a function to compute their intersection - the intersection means the numbers that are in both arrays.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Note:
// Each element in the result must be unique.
// The result can be in any order.

public class ArraysIntersection {

   public static void main(String[] args) {
       int[][][] pairs = {
           {
               {1,2,2,1},
               {2,2}
           },
           {
               {4,9,5},
               {9,4,9,8,4}
           }
       };

       for (int[][] pair : pairs) {
           System.out.println("Intersection of "+Arrays.toString(pair[0])+" and "+Arrays.toString(pair[1])+" is \n"+Arrays.toString(getIntersection(pair[0],pair[1]))+"\n");
       }
   } 

   static int[] getIntersection(int[] A, int[] B){
       String intersection = "";//hold the intersection
       String notIntersected = "";//hold numbers that didn't intersect - memo
       boolean intersected = false;

       for (int i = 0; i < A.length; i++) {
           if(intersection.contains(A[i]+"") || notIntersected.contains(A[i]+""))//we do not need to check if we have determined that this element intersected already (uniqueness criteria)
               continue;//or it was previously determined the element didn't intersect

            intersected = false;
            for (int j = 0; j < B.length; j++) {
                //if the values at these indices of the arrays are the same, note it
                if(intersected = A[i] == B[j]){//confirm intersection
                    intersection += B[j]+",";//note the intersecting element
                    break;//no need continuing sub iteration
                }
            }

            if(!intersected){//sub iteration didn't produce an intersection
                notIntersected += A[i];//not the digit that didn't intersect
            }
        }


       //convert to integer array
       String[] use = ((String) intersection.subSequence(0, intersection.length() - 1)).split(Pattern.quote(","));
       int[] tr = new int[use.length];
       for (int i = 0; i < tr.length; i++) {
           tr[i] = Integer.parseInt(use[i]);
       }
       return tr;
   }
}