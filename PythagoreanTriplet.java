// Hi, here's your problem today. This problem was recently asked by Uber:

// Given a list of numbers, find if there exists a pythagorean triplet in that list. A pythagorean triplet is 3 variables a, b, c where a2 + b2 = c2

// Example:
// Input: [3, 5, 12, 5, 13]
// Output: True
// Here, 5^2 + 12^2 = 13^2.
public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 12, 5, 13};

        System.out.println(hasTriplet(numbers));
    }

    static boolean hasTriplet(int[] numbers){
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j <= numbers.length - 2; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if(Math.pow(numbers[i], 2) + Math.pow(numbers[j], 2) == Math.pow(numbers[k], 2))
                        return true;
                }
            }
        }
        return false;
    }
}