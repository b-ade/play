// You have a landscape, in which puddles can form. You are given an array of non-negative integers representing the elevation at each location. Return the amount of water that would accumulate if it rains.

// For example: [0,1,0,2,1,0,1,3,2,1,2,1] should return 6 because 6 units of water can get trapped here.
//        X               
//    X███XX█X              
//  X█XX█XXXXXX                   
// # [0,1,0,2,1,0,1,3,2,1,2,1]


public class TrappingWater {

    public static void main(String[] args) {
        int[] elevation = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getAmout(elevation));
    }

    static int getAmout(int[] e) {
        int amount = 0;

        for (int i = 0; i < e.length-1; i++) {
            if(e[i+1] < e[i]){//start a dip
                int level = -1;//potential leveling point
                for (int j = i+1; j < e.length; j++) {
                    if(e[j] >= e[i]){
                        level = j;
                        break;
                    }
                }
                if(level != -1){//if leveled count dip volume and add
                    for (int j = i+1; j < level; j++) {
                        amount += e[i] - e[j];
                    }
                    i = level-1;//move main pointer to end of last discovered dip
                }
            }
        }
        
        return amount;
    }
}