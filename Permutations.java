import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// You are given an array of integers. Return all the permutations of this array.

// def permute(nums):
//   # Fill this in.

// print permute([1, 2, 3])
// # [[1, 2, 3], [2, 1, 3], [2, 3, 1], [1, 3, 2], [3, 1, 2], [3, 2, 1]]


public class Permutations{

    public static void main(String[] args) {
        List<List<Integer>> result = getPermutations(Arrays.asList(1, 2, 3));
        System.out.println(result);
    }

    public static <T> List<List<T>> getPermutations(List<T> elements){
        ArrayList<List<T>> result = new ArrayList<List<T>>();
        if(elements.size() == 1)
            result.add(elements);
        else if(elements.size() == 2){
            result.add(elements);//add the elements as is

            //swap tuple and add
            ArrayList<T> other = new ArrayList<T>(elements);
            T temp = other.remove(0);
            other.add(temp);
            result.add(other);
        }else{   
            for (int i = 0; i < elements.size(); i++) {
                T current = elements.get(i);
                List<List<T>> sub = getPermutations(cloneWhileIgnoring(elements, i));
                for(List<T> a : sub) {
                    a.add(0,current);
                    result.add(a);
                }
            }    
        }
        return result;
    }

    public static <T> List<T> cloneWhileIgnoring(List<T> list,int ignoreIndex){
        List<T> result = new ArrayList<T>();
        result.addAll(list);
        result.remove(ignoreIndex);
        return result;
    }
} 