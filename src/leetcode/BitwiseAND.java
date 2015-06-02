package leetcode;

public class BitwiseAND {

    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        System.out.println(new BitwiseAND().rangeBitwiseAnd(m, n));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            if ((m & mask) == (n & mask)) {
                if ((m & mask) != 0) {
                    result |= mask;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
