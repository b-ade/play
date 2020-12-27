// Hi, here's your problem today. This problem was recently asked by Google:

// There are n people lined up, and each have a height represented as an integer. A murder has happened right in front of them, and only people who are taller than everyone in front of them are able to see what has happened. How many witnesses are there?

// Example:
// Input: [3, 6, 3, 4, 1]  
// Output: 3
// Explanation: Only [6, 4, 1] were able to see in front of them.
//  #
//  #
//  # #
// ####
// ####
// #####
// 36341                                 x (murder scene)

public class WitnessCount{
    public static void main(String[] args) {
        int[] individualHeights = {3,6,3,4,1};
        System.out.println("Number of witnesses: "+getWithnessCount(individualHeights));
    }

    static int getWithnessCount(int[] individualHeights){
        int WitnessCount = 1;//there will always be at least one witness

        //starting from the right, check frm the second person all the way to the last person
        for (int i = individualHeights.length - 2; i >= 0; i--) {
            boolean obstructed = false;
            for (int j = i+1; j < individualHeights.length; j++) {
                if(obstructed |= individualHeights[j] > individualHeights[i])
                    break;
            }
            if(!obstructed)
                WitnessCount++;
        }
        return WitnessCount;
    }
}