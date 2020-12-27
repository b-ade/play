// Hi, here's your problem today. This problem was recently asked by AirBNB:

// Given two strings, determine the edit distance between them. The edit distance is defined as the minimum number of edits (insertion, deletion, or substitution) needed to change one string to the other.

// For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a t).

// Here's the signature:
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(getDistance("biting","sitting"));
    }

    static int getDistance(String first,String second){
        //eliminate any similar sequence of characters between both strings   
        String[] words = {first,second};
        eliminateSimilarSequences(words);
    
        int insertDelete = - (words[0].length() - words[1].length()); //negative value indicates deletion
        
        int charChangesRequired = insertDelete == 0 ? words[0].length() : //if no deletion or insertion, then all will be changed
        //otherwise, changes will be difference between length of both strings.
        Math.max(words[0].length(), words[1].length()) - Math.abs(insertDelete) ;

        return Math.abs(insertDelete) + charChangesRequired;
    }

    /**
     * Eliminate common sequence of characters between two strings
     * @param words operands, using array as parameter to maintain reference for recursive action
     */
    static void eliminateSimilarSequences(String[] words){
        int subStringCountForSize = 0;
        for(int subSize = words[0].length(); subSize > 0; subSize--){
            subStringCountForSize = words[0].length() - subSize + 1;

            boolean eliminatedSome = false;

            for(int subStringStartIndex = 0; subStringStartIndex < subStringCountForSize; subStringStartIndex++){
                int subStringEndIndex = subStringStartIndex + subSize;
                String currentSubString = words[0].substring(subStringStartIndex,subStringEndIndex);
                if(eliminatedSome = words[1].contains(currentSubString)){
                    words[1] = words[1].replaceFirst(currentSubString, "");
                    words[0] = words[0].replaceFirst(currentSubString, "");
                    break;
                }
            }

            if(words[0].length() < 1 || words[1].length() < 1)
                break;

            if(eliminatedSome){//if a common sequence of characters was eliminated
                eliminateSimilarSequences(words);//act on the resultant strings instead
                break;
            }
        }
    }
}