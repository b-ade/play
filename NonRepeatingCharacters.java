// Hi, here's your problem today. This problem was recently asked by Microsoft:

// Given a string, find the length of the longest substring without repeating characters.

// Here is an example solution in Python language. (Any language is OK to use in an interview, though we'd recommend Python as a generalist language utilized by companies like Google, Facebook, Netflix, Dropbox, Pinterest, Uber, etc.,)

public class NonRepeatingCharacters{

    public static void main(String[] args){
        String sample = args[0];//abrkaabcdefghijjxxx
        int maxLength = 0,currentLenght = 1;
        int cursorPosition = 0;

        while(++cursorPosition <= sample.length() - 1){
            if(sample.charAt(cursorPosition) == sample.charAt(cursorPosition - 1)){
                if(currentLenght > maxLength)
                    maxLength = currentLenght;
                currentLenght = 1;
            }else{
                currentLenght++;
            }
        }
        System.out.println("Longest non-repeating substring is: "+maxLength);
    }
}