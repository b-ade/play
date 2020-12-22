// Hi, here's your problem today. This problem was recently asked by Google:

// Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.

// Example 1:
// Input: [3, 3, 2, 1, 3, 2, 1]
// Output: [1, 1, 2, 2, 3, 3, 3]

public class UniqueListSort {
    public static void main(String[] args){
        for (String string : args) {
            //prepare input
            String[] arrayString = string.replace(" ", "")
                                        .replace("[", "")
                                        .replace("]", "")
                                        .split(",");
            int[] array = new int[arrayString.length];
            for(int i = 0; i < arrayString.length; i++){
                array[i] = Integer.parseInt(arrayString[i]);
            }

            //print input
            printIntArray(array);
            System.out.print(" => ");

            //sort
            sortList(array);
            
            //print result
            printIntArray(array);
            System.out.println();
        }
    }

    public static void sortList(int[] list){
        int[] numbers = {0,0,0};
        numbers[0] = list[0];
        boolean secondFound = false, thirdFound = false;
        int lowerNumberCount = 0, mediumNumberCount = 0;

        //determine unique numbers
        for (int i: list) {
            if(thirdFound)
                break;

            if(!secondFound){
                if(i != numbers[0]){
                    numbers[1] = i;
                    secondFound = true;
                }
            }

            if(!thirdFound){
                if(i != numbers[0] && i != numbers[1]){
                    numbers[2] = i;
                    thirdFound = true;
                }
            }
        }

        int swapper;
        //sort unique numbers using bubblesort
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if(numbers[j] > numbers[j+1]){
                    swapper = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = swapper;
                }
            }
        }
        
        //determine the counts of the unique numbers
        for (int i: list) {
            if(i == numbers[0])
                lowerNumberCount++;
            else if(i == numbers[1])
                mediumNumberCount++;
        }

        //rewrite the array using the order of unique numbers and their respective counts
        for (int i = 0; i < list.length; i++) {
            list[i] = i < lowerNumberCount ? numbers[0] : 
            i >= lowerNumberCount && i < (lowerNumberCount + mediumNumberCount) ? numbers[1] : numbers[2];
        }
    }

    /**
     * Print an int array on a single console line
     * @param array
     */
    private static void printIntArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i]+", ");
        }
        System.out.print(array[array.length - 1]+"]");
    }
}