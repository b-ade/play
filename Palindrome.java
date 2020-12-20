//  Hi, here's your problem today. This problem was recently asked by Twitter:

// A palindrome is a sequence of characters that reads the same backwards and forwards. Given a string, s, find the longest palindromic substring in s.

// Example: 
// Input: "banana"
// Output: "anana"

// Input: "million"
// Output: "illi"


public class Palindrome{
    public static void main(String[] args){
        for (String string : args) {
            System.out.println(string + " => " +getLongestSubStringPalindrome(string));
        }
    }
    
    /**
     * Iteratively compute substrings for a given string in left to right and tests whether or not each is a palindrome.
     * @param input
     * @return first largest largest palindrome that is a substring of the arguement
     */
    public static String getLongestSubStringPalindrome(String input){
        int requiredSize = input.length();//the size of the substring
        String currentSubString = null;//current substring that might be a palindrome
        while(true){
            if(requiredSize < 1)
                break;

            int possibleSubstringsForSize = input.length() - (--requiredSize);
            for (int i = 0 ; i < possibleSubstringsForSize; i++) {
                currentSubString = input.substring(i,i + requiredSize +1);
                if(isPalinDrome(currentSubString))
                    return currentSubString;
            }
        }
        return null;
    }

    /**
     * Check if a string is a palindrome
     * @param string
     * @return
     */
    public static boolean isPalinDrome(String string){
        for (int i = 0; i < string.length(); i++) {
            if(i > Math.round(5/2f))//no need to go past the middle index of the string
                break;
            if(string.charAt(i) != string.charAt(string.length() - 1 - i))
                return false;
        }
        return true;
    }
}