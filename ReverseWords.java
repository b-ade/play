// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:
// Input: "The cat in the hat"
// Output: "ehT tac ni eht tah"

public class ReverseWords{

    public static void main(String[] args) {
        String input = "The cat in the hat";
        System.out.println("Reversing\n"+input+"\nis\n"+reverseWords(input));
    }

    static String reverseWords(String string) {
        char[] trans = string.toCharArray();//mutable representation of the string
        int start = 0;//keep track of the start of a word

        for (int i = 0; i < trans.length; i++) {
            if(trans[i] == ' '){
                reverseChunk(trans,start,i-1);//define a chunk that is a word and reverse it
                start = i + 1;//continue keeping track of the start of a work
            }else if(i == trans.length - 1){
                //handle the word at the end of the string
                reverseChunk(trans,start,i);
            }
        }
        return new String(trans);
    }

    static void reverseChunk(char[] string,int startIndex,int stopIndex){
        int length = stopIndex - startIndex + 1;
        int middle =  stopIndex - (length / 2);// + (length % 2 == 0 ? 1 : 0);

        char temp;
        int oppIndex, counter = 0;

        //iterate through half
        for (int i = stopIndex; i > middle ; i--) {
            //swap with char at the other side of the chunk
            oppIndex = startIndex + (counter++);
            temp = string[i];
            string[i] = string[oppIndex];
            string[oppIndex] = temp;
        }

        //3  4  5  6  7  8
        //[] [] [] [] [] []
    }
}