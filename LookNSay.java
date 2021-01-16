import java.util.Arrays;

public class LookNSay {
    public static void main(String[] args) {
        int k = 5;
        System.out.println("Nth term in sequence when n is "+k+" is\n"+Arrays.toString(
            getNthTermInSequence(k)
        ));
    }

    static int[] getNthTermInSequence(int n){
        int[] nth = new int[0];
        for (int i = 0; i < n; i++) {
            nth = getNextInSequence(nth);
        }
        return nth;
    }

    static int[] getNextInSequence(int[] current) {
        if(current.length > 1){
            int lastDigit = 'b', lastDigitCount = 0;
            String next = "";
            for (int i = 0; i < current.length; i++) {
                if(lastDigit == 'b'){//first element in array
                    lastDigit = current[i];
                    lastDigitCount = 1;
                    continue;
                }

                if(current[i] == lastDigit)
                    lastDigitCount++;
                else{//digit has changed; commit old, start new
                    next += lastDigitCount + "" + lastDigit;
                    lastDigit = current[i];
                    lastDigitCount = 1;
                }
            }
            next += lastDigitCount + "" +lastDigit;//commit the last count into next

            //return next as int array
            int[] tr = new int[next.length()];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = Integer.parseInt(next.charAt(i)+"");
            }
            return tr;
        }else if(current.length == 1){
            return new int[]{1,current[0]};
        }else{
            return new int[]{1};
        }
    }
}