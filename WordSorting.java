// Given a list of words, and an arbitrary alphabetical order, verify that the words are in order of the alphabetical order.

// Example:
// Input:
// words = ["abcd", "efgh"], order="zyxwvutsrqponmlkjihgfedcba"

// Output: False
// Explanation: 'e' comes before 'a' so 'efgh' should come before 'abcd'

// Example 2:
// Input:
// words = ["zyx", "zyxw", "zyxwy"],
// order="zyxwvutsrqponmlkjihgfedcba"

// Output: True
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class WordSorting{
    public static void main(String[] args) {
        String[][] wordsPack = {
            {"abcd", "efgh"},
            {"zyx", "zyxw", "zyxwy"}
        };

        System.out.println("\nCustom ordering is ["+ordering+"]");
        for(String[] words: wordsPack){
            System.out.println("Are the words "+Arrays.toString(words)+" sorted according to custom ordering? "+isOrdered(words));
        }
    }

    static String ordering = "zyxwvutsrqponmlkjihgfedcba";
    static Comparator<String> comparator = new Comparator<>(){

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() <= o2.length()){
                char a,b;
                for (int i = 0; i < o1.length(); i++) {
                    //find the first pair of characters that are different between both strings and compare(according to the ordering)
                    a = o1.charAt(i);
                    b = o2.charAt(i);
                    if(a == b)
                        continue;
                    return Integer.compare(ordering.indexOf(a), ordering.indexOf(b));
                }
                
                //if both are of equal length, return 0 to indicate no swapping required, 
                //otherwise, return -1 to indicate that o1 is less than o2
                return o1.length() == o2.length()? 0 : -1;
            }else{
                //the left string is of greater length, so compare only as much as the right string.
                String cropped = o1.substring(0,o2.length());
                int croppedCompared = compare(cropped,o2);
                if(croppedCompared == 0){//if the left string is an extension of the right, 
                    //swap is required
                    return 1;
                }
                return croppedCompared;
            }
        }
    };

    static boolean isOrdered(String[] words){
        List<String> duplicateList = new ArrayList(Arrays.asList(words));
        duplicateList.sort(comparator);
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals(duplicateList.get(i)))
            return false;
        }
        return true;
    }
}