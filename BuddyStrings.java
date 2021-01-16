// Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

// Example 1:
// Input: A = "ab", B = "ba"
// Output: true


// Example 2:
// Input: A = "ab", B = "ab"
// Output: false

// Example 3:
// Input: A = "aa", B = "aa"
// Output: true

// Example 4:
// Input: A = "aaaaaaabc", B = "aaaaaaacb"
// Output: true

// Example 5:
// Input: A = "", B = "aa"
// Output: false


public class BuddyStrings {
    public static void main(String[] args) {
        String[] ex1 = {"ab","ba"};
        String[] ex2 = {"ab","ab"};
        String[] ex3 = {"aa","aa"};
        String[] ex4 = {"aaaaaaabc","aaaaaaacb"};
        String[] ex5 = {"","aa"};
        check(new String[][]{
            ex1,ex2,ex3,ex4,ex5
        });
    }    
    
    static void check(String[][] examples){
        for(String[] pair: examples){
            System.out.println("["+pair[0]+"] and ["+pair[1]+"] are buddy strings: "+areBuddies(pair[0],pair[1]));
        }
    }

    static boolean areBuddies(String a, String b){
        int aLength = a.length(), blength = b.length();
        if(aLength < 2 || blength < 2 || aLength != blength)
            return false;

        //there must be EXACTLY two characters difference between them
        //and the difference must be swappable
        //per ex: 3

        StringBuilder difference = new StringBuilder();
        for (int i = 0; i < aLength; i++) {
            if(a.charAt(i) != b.charAt(i)){//difference in chars
                //note diff
                difference.append(a.charAt(i)).append(b.charAt(i));

                if(difference.length() > 4)//criteria for buddy string broken
                    return false;
            }
        }

        //Special case in example 3; the strings are the same
        //meaning there is no difference in the strings
        //it means there is at least one double character in a, on which swapping would do nothing
        //confirm by gathering distinct characters, confirmed if length of distinct is less than length of original
        if(difference.length() == 0){
            String check = "";
            for (int i = 0; i < a.length(); i++) {
                if(!check.contains(a.charAt(i)+""))
                    check += a.charAt(i);
            }
            return check.length() < a.length();
        }
        
        //check that the two differences are swappable using the order of insertion into 'difference' string

        return difference.length() == 4 
            && difference.charAt(0) == difference.charAt(3)
            && difference.charAt(1) == difference.charAt(2);
    }
}