import java.util.Arrays;

// You are the manager of a number of employees who all sit in a row. The CEO would like to give bonuses to all of your employees, but since the company did not perform so well this year the CEO would like to keep the bonuses to a minimum.

// The rules of giving bonuses is that:
// - Each employee begins with a bonus factor of 1x.
// - For each employee, if they perform better than the person sitting next to them, the employee is given +1 higher bonus (and up to +2 if they perform better than both people to their sides).

// Given a list of employee's performance, find the bonuses each employee should get.

// Example:
// Input: [1, 2, 3, 2, 3, 5, 1]
// Output: [1, 2, 3, 1, 2, 3, 1]

public class Bonuses{

    public static void main(String[] args) {
        int[] performances = {1, 2, 3, 2, 3, 5, 1};
        int[] bonuses = getBonuses(performances);
        System.out.println("The bonuses from performance\n"+Arrays.toString(performances)+"\nare\n"+Arrays.toString(bonuses));
    }

    static int[] getBonuses(int[] performances){
        int[] bonuses = new int[performances.length];
        
        //initialize the terminating employees' bonuses
        bonuses[0] = bonuses[bonuses.length-1] = 1;
        if(performances[0] > performances[1])
            bonuses[0] = bonuses[0] + 1;
        if(performances[performances.length-1] > performances[performances.length-2])
            bonuses[bonuses.length-1] = bonuses[bonuses.length-1] + 1;

        //compute for every employee inbetween
        int bonusIncrement = 0;
        for (int i = 1; i < performances.length - 1; i++) {
            bonusIncrement = 1;//base bonux of 1x
            bonusIncrement += performances[i] > performances[i-1] ? 1 : 0;
            bonusIncrement += performances[i] > performances[i+1] ? 1 : 0;
            bonuses[i] = bonusIncrement;
        }

        return bonuses;
    }
}