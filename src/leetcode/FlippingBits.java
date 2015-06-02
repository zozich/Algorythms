package leetcode;

public class FlippingBits {

    public static void main(String[] args) {
        for (String s : args) {
            int value = Integer.parseInt(s);
            String s2 = Integer.toBinaryString(~value);
            //s2 = "0" + s2.substring(1, s2.length());
            int result = Integer.parseInt(s2, 2);
            System.out.println(result);
        }
    }
}
