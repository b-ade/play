// Given a sorted list of numbers, return a list of strings that represent all of the consecutive numbers.

// Example:
// Input: [0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15]
// Output: ['0->2', '5->5', '7->11', '15->15']
// Assume that all numbers will be greater than or equal to 0, and each element can repeat.

import java.util.Arrays;
import java.util.regex.Pattern;

public class Compression{

    public static void main(String[] args) {
        int[] list = {0, 1, 2, 5, 7, 8, 9, 9, 10, 11, 15};
        System.out.println(Arrays.toString(list)+"\n\n\t|\n\tV\n\n"+Arrays.toString(compress(list)));
    }

    static String[] compress(int[] list) {
        int start = 0;
        String result = "";

        for (int i = 1; i < list.length; i++) {
            if(list[i] - list[i-1]  > 1){
                result += list[start] + "->" + list[i-1]  +  "|";
                start = i;
                
                //if list discontinued by the last
                if(i == list.length - 1){
                    result += list[i] + "->" + list[i]  +  "|";
                }
            }else if (i == list.length - 1){
                //consecutive continuation, but we are on the last element
                result += list[start] + "->" + list[i]  +  "|";
            }
        }
        return ((String) result.subSequence(0, result.length() - 1)).split(Pattern.quote("|"));
    }
}