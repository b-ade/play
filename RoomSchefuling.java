import java.util.Arrays;

// You are given an array of tuples (start, end) representing time intervals for lectures. The intervals may be overlapping. Return the number of rooms that are required.

// For example. [(30, 75), (0, 50), (60, 150)] should return 2.

public class RoomSchefuling {
    
    public static void main(String[] args) {
        int[][][] preSchedule = {
            {
                {30,75},{0,50},{60,150}
            }
        };
        for (int[][] is : preSchedule) {
            System.out.println("Rooms required for\n"+Arrays.deepToString(is)+"\nis "+getRoomCout(is));
        }
    }

    static int getRoomCout(int[][] original){
        int initial = original.length;
        for (int i = 0; i < original.length; i++) {
            if(original[i] == null)
                continue;
                for (int j = i + 1; j < original.length; j++) {
                    if(original[j] == null)
                        continue;
                    
                        if( (original[j][0] < original[i][0] && original[j][1] < original[i][0])
                        ||(original[i][1] < original[j][0])){//combining sessions into a room if they don't collide
                            original[j] = null;
                            initial--;
                        }
                }
        }
        return initial;
    }
}