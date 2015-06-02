package prometheus;

/**
 * Created by VisitorW on 3/17/15.
 */
public class NewPow {
    public static void main (String[] args) {
        System.out.println(startPow(2, 8));
    }

    public static long startPow(int num, int pow) {
        String stringPow = Integer.toBinaryString(pow);
        stringPow = new StringBuilder(stringPow).reverse().toString();
        long localPow = num;
        long result = 1;
        for (char c:stringPow.toCharArray()) {
            if (c=='1') {
                result *= localPow;
            }
            localPow *= localPow;
        }
        return result;
    }
}
