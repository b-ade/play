// Given a list of words, group the words that are anagrams of each other. (An anagram are words made up of the same letters).

// Example:

// Input: ['abc', 'bcd', 'cba', 'cbd', 'efg']
// Output: [['abc', 'cba'], ['bcd', 'cbd'], ['efg']]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupWords {

    public static void main(String[] args) {
        String[] words = { "abc", "bcd", "cba", "cbd", "efg" };
        System.out.print("Grouped anagrams of \n"+Arrays.toString(words)+"\nare\n"); 
        String[][] groups = groupWords(words);
        System.out.println(Arrays.deepToString(groups));
    }

    static String[][] groupWords(String[] words) {
        List<Group> groups = new ArrayList<>();
        Group current;
        for (int i = 0; i < words.length; i++) {
            if(words[i] == null)//because word might have been grouped with another already as an anagram
                continue;
            
            current = new Group(words[i]);
            for (int j = i+1; j < words.length; j++) {
                if(words[j] == null)//because word might have been grouped with another already as an anagram
                    continue;
                if(isAnagram(words[i], words[j])){//if is an anagram, add to group and remove it from list of words being grouped
                    current.add(words[j]);
                    words[j] = null;
                }
            }
            groups.add(current);//commit current group
        }
        
        //translate groups to string arrays
        String[][] tr = new String[groups.size()][];
        for (int i = 0; i < tr.length; i++) {
            tr[i] = groups.get(i).group();
        }
        return tr;
    }

    static class Group{
        String first;
        List<String> anagrams = new ArrayList<>();
        public Group(String first){
            this.first = first;
        }

        public void add(String word){
            this.anagrams.add(word);
        }

        String[] group(){
            String[] tr = new String[anagrams.size()+1];
            tr[0] = first;
            System.arraycopy(anagrams.toArray(), 0, tr, 1, anagrams.size());
            return tr;
        }
    }

    static boolean isAnagram(String word,String other){
        if(word.length() != other.length())//anagrams are of equal length
            return false;
        
        int sum = 0;//if they are the same, value shouldn't change after the loop
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
            sum -= other.charAt(i);
        }
        
        return sum == 0;
    }
}