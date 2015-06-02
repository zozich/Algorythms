package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestPalindrome {
    int maxLength = 1;
    int index = 0;
    int startChar = 0;
    int endChar = 1;
    char[] chars;
    TempValue[] tempValues = new TempValue[chars.length];

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        String s = "sososasds";
        System.out.println((new LongestPalindrome()).longestPalindrome(s));
    }

    //create matrix - check all variants with 2 and 3 values, then proceed expanding
    //the values where isPalindrom is true
    public String longestPalindrome(String s) {
        chars = s.toCharArray();
        tempValues[0] = new TempValue(0, 0, 1);
        for (int i = 0; i < chars.length; i++) {
            maxLength = checkPrevious(chars);
        }
        return null;
    }

    private int checkPrevious(char[] chars) {
        if (startChar > 0 && endChar < chars.length) {
            if (chars[startChar - 1] == chars[endChar + 1]) {
                startChar--;
                endChar++;
                tempValues[index] = new TempValue(index, startChar, endChar);
            }
        }
        return 0;
    }

    private class TempValue {
        int index;
        int startChar;
        int end;

        public TempValue(int index, int startChar, int end) {
            this.index = index;
            this.startChar = startChar;
            this.end = end;
        }
    }
}
