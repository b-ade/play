// You are given a string s, and an integer k. Return the length of the longest substring in s that contains at most k distinct characters.

// For instance, given the string:
// aabcdefff and k = 3, then the longest substring with 3 distinct characters would be defff. The answer should be 5.


public class LongestSubWithUniqueChars {
    public static void main(String[] args) {
        String string = "aabcdefff";
        int k = 3;
        System.out.println("Length of longest substring with "+k+" unique characters is "+getSolution(string,k));
    }

    static int getSolution(String string, int ucl){
        int length = 0;

        int subStringCount = 0;
        for (int subStringLength = string.length() - 2; subStringLength >= 1; subStringLength--) {
            //number of substrings whose length is os the required
            subStringCount = string.length() - subStringLength + 1;
            boolean found = false;
            for (int i = 0; i < subStringCount; i++) {
                found |= check(string,i, i+subStringLength-1,ucl);
                if(found)
                    break;
            }
            if(found)
                return subStringLength;
        }

        return length;
    }

    static boolean check(String string, int start, int end, int ucl){
        String uniqueChars = "";
        for (int i = start; i <= end; i++) {
            if(!uniqueChars.contains(string.charAt(i)+""))
                uniqueChars += string.charAt(i);
            if(uniqueChars.length() > ucl)
                return false;
        }
        return uniqueChars.length() <= ucl;
    }
}