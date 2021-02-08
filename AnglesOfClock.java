// Hi, here's your problem today. This problem was recently asked by Microsoft:

// Given a time in the format of hour and minute, calculate the angle of the hour and minute hand on a clock.


public class AnglesOfClock {

    public static void main(String[] args) {
        int[][] testHours = {
            {3,30},
            {12,30},
            {12,35},
            {12,0},
            {12,1},
            {12,5}
        };

        for (int[] time : testHours) {
            System.out.println("Angles of "+time[0]+":"+time[1]+" is "+getAngle(time[0], time[1]));
        }
    }

    //assuming the displacement of the hour hand between a given pair of hour marks is proportiona
    //the the displacement of the minute hand on the entire face of the clock
    static int getAngle(int hour,int min){
        int h = hour == 12 ? 0 : hour;
        int a = h * 5;
        a += ((min * 5)/60);

        int initialD = (min > a ? (min - a) :  (a - min) ) * 6;

        if(initialD > 180){
            initialD = 360 - initialD;
        }
        return initialD;
    }
}