// Hi, here's your problem today. This problem was recently asked by Facebook:

// You are given a list of numbers, and a target number k. Return whether or not there are two numbers in the list that add up to k.

// Example:
// Given [4, 7, 1 , -3, 2] and k = 5, 
// return true since 4 + 1 = 5.
public class SubCheck {
    
    /**
     * Assuming each imput is entered as <list>,<target>
     */
    public static void main(String[] args){
        for(String a: args){
            int splitPoint = a.lastIndexOf(",");
            String list = a.substring(0,splitPoint);
            String[] arrayString = list.replace(" ","").replace("[","")
                                                        .replace("]","")
                                                        .split(",");
            
            int[] numbers = new int[arrayString.length];
            for(int i  = 0; i < numbers.length; i++){
                numbers[i] = Integer.parseInt(arrayString[i]);
            }

            int number = Integer.parseInt(a.substring(splitPoint+1,a.length()));

            System.out.println(String.format("Does %1s contain numbers that add up to %1d? %1b", list,number,containsAdditionFactors(numbers,number)));
        }
    }

    public static boolean containsAdditionFactors(int[] numbers,int target){
        for (int i = 0; i < numbers.length; i++) {
            //only interested in numbers less than the target
            if(numbers[i] > target)
                continue;
            
            //check remaining numbers to see if any adds up with the current number to make the target sum
            if (i < numbers.length - 1){
                for(int j = i+1; j <= numbers.length-1; j++){
                    if(numbers[j] > (target - numbers[i]))
                        continue;
                    if(numbers[i]+numbers[j] == target)
                        return true;
                }
            }
        }
        return false;
    }
    
}