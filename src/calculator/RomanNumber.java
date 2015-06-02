package calculator;

import java.lang.*;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrew on 10.03.2015.
 */

public class RomanNumber extends Number {

    private static LinkedHashMap<String, BigInteger> romanConversionMap = new LinkedHashMap<String, BigInteger>();

    static {
        romanConversionMap.put("M", new BigInteger("1000"));
        romanConversionMap.put("CM", new BigInteger("900"));
        romanConversionMap.put("D", new BigInteger("500"));
        romanConversionMap.put("CD", new BigInteger("400"));
        romanConversionMap.put("C", new BigInteger("100"));
        romanConversionMap.put("XC", new BigInteger("90"));
        romanConversionMap.put("L", new BigInteger("50"));
        romanConversionMap.put("XL", new BigInteger("40"));
        romanConversionMap.put("X", new BigInteger("10"));
        romanConversionMap.put("IX", new BigInteger("9"));
        romanConversionMap.put("V", new BigInteger("5"));
        romanConversionMap.put("IV", new BigInteger("4"));
        romanConversionMap.put("I", new BigInteger("1"));
    }

    public RomanNumber(String value) {
        this.value = value;
        this.scale = "r";
        checkNumber();
    }

    protected void checkNumber() {
        checkRomanNumber();
        checkRomanSequence();
    }

    private void checkRomanNumber() {
        char[] charsInValue = value.toCharArray();
        for (char c:charsInValue) {
            if (romanConversionMap.get(String.valueOf(c))==null)
                throw new IllegalArgumentException("Roman numeral " + value + " indicated incorrectly (illegal characters)");
        }
    }

    private void checkRomanSequence() {
        if (value.contains("VIV") || value.contains("LXL") || value.contains("DCD")) {
            incorrectRomanSequence();
        }
        char[] charsInValue = value.toCharArray();
        int i=0;

        OuterLoop:
        for (Map.Entry pair : romanConversionMap.entrySet()) {
            while (true) {
                if (i==charsInValue.length) {
                    break;
                }
                if (i < charsInValue.length - 1) {
                    String element = String.valueOf(charsInValue[i]) + charsInValue[i + 1];
                    if (element.equals(pair.getKey())) {
                        i += 2;
                        continue OuterLoop;
                    }
                }
                String element = String.valueOf(charsInValue[i]);
                if (element.equals(pair.getKey())) {
                    i++;
                    continue;
                } else {
                    break;
                }
            }
        }
        if (i<charsInValue.length) {
            incorrectRomanSequence();
        }
    }

    private void incorrectRomanSequence(){
        throw new IllegalArgumentException("The numbers in roman numeral " + value + " are represented in wrong sequence");
    }

    public String getScale10Value() {
        char[] charsInValue = value.toCharArray();
        BigInteger result = new BigInteger("0");
        for (int i=0;i<charsInValue.length;i++) {
            if (i<charsInValue.length-1) {
                String element = String.valueOf(charsInValue[i]) + charsInValue[i+1];
                BigInteger romanElement = romanConversionMap.get(element);
                if (romanElement!=null) {
                    result = result.add(romanElement);
                    i++;
                    continue;
                }
            }
            String element = String.valueOf(charsInValue[i]);
            BigInteger romanElement = romanConversionMap.get(element);
            result = result.add(romanElement);
        }
        return String.valueOf(result);
    }

    public String getConvertedValue(String expression) {
        BigInteger bigExpression = new BigInteger(expression);
        String result = "";
        for (Map.Entry pair : romanConversionMap.entrySet()) {
            BigInteger valueFromMap = (BigInteger)pair.getValue();
            while (bigExpression.compareTo(valueFromMap)>=0) {
                result += pair.getKey();
                bigExpression = bigExpression.subtract(valueFromMap);
            }
        }
        return result;
    }
}