// Hi, here's your problem today. This problem was recently asked by Facebook:

// Given a list of numbers, where every number shows up twice except for one number, find that one number.

// Example:
// Input: [4, 3, 2, 4, 1, 3, 2]
// Output: 1
public class SingleNumber {

    public static void main(String[] args){
        int[] numbers = {4, 3, 2, 4, 1, 3, 2};    
        System.out.println("Single number is "+findSingle(numbers));
    }

    public static int findSingle(int[] numbers){
        int sum = 0;//will hold value of single number

        for (int i = 0; i < numbers.length; i++) {
            int cursorOn = numbers[i];
            sum += cursorOn;//positive increment if number is part of a pair
            for (int j = 0; j < numbers.length; j++) {
                if(i == j)
                    continue;
                else if(numbers[i] == numbers[j])
                    sum -= cursorOn;//negative - decrement if number is part of a pair
            }
        }
        return sum;
    }
}