// Hi, here's your problem today. This problem was recently asked by AirBNB:

// Given a sorted array, A, with possibly duplicated elements, find the indices of the first and last occurrences of a target element, x. Return -1 if the target is not found.

// Example:
// Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
// Output: [6,8]

// Input: A = [100, 150, 150, 153], target = 150
// Output: [1,2]

// Input: A = [1,2,3,4,5,6,10], target = 9
// Output: [-1, -1]

public class FirstLastOccurence{

    public static void main(String[] args){
        //"Expecting input in form of strings formatter <array>,<target>"
        for(String a: args){
            String inputString = a.replace(" ","");
            int splitPoint = inputString.lastIndexOf(",");
            String arrayString = inputString.substring(0,splitPoint);
            int target = Integer.parseInt(inputString.substring(splitPoint+1,inputString.length()));
            
            int[] result = getFirstLast(getArray(arrayString), target);
            
            System.out.println(String.format("%1s\n => [%1d,%2d]\n",inputString,result[0],result[1]));
        }
    }

    public static int[] getFirstLast(int[] array,int target){
        int[] result = {-1,-1};
        for (int i =0; i < array.length; i++) {
            if(array[i] == target){
                result[1] = i;
                if(result[0] == -1)
                    result[0] = i;
            }
        }
        return result;
    }

    public static int[] getArray(String input){
        int size = 0;
        for(char a: input.toCharArray()){
            if(a == ',')
                size++;
        }
        if(size > 0)
            size++;
        int[] array = new int[size];
        int counter = 0;
        for(String a: input.replace("[", "").replace("]", "").split(",")){
            array[counter++] = Integer.parseInt(a);
        }
        return array;
    }
}