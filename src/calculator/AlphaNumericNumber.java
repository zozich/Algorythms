package calculator;

import java.lang.*;
import java.math.BigInteger;
import java.util.HashMap;

public class AlphaNumericNumber extends Number {

  private static HashMap<String, Integer> conversion10Map = new HashMap<String, Integer>();
  private static HashMap<Integer, String> reverseConversion10Map = new HashMap<Integer, String>();

  static {
    for (int i = 0; i < 36; i++) {
      if (i < 10) {
        conversion10Map.put(String.valueOf(i), i);
        reverseConversion10Map.put(i, String.valueOf(i));
      } else {
        conversion10Map.put(String.valueOf((char) (i + 55)), i);
        reverseConversion10Map.put(i, String.valueOf((char) (i + 55)));
      }
    }
  }

  public AlphaNumericNumber(String value, String scale) {
    this.value = value;
    this.scale = scale;
    if (scale.equals("")) {
      this.scale = "10";
    }
    checkNumber();
  }

  protected void checkNumber() {
    checkScale();
    checkAlphaNumericNumber();
  }

  private void checkScale() {
    int intScale = 0;
    try {
      intScale = Integer.parseInt(scale);
    } catch (NumberFormatException e) {
      incorrectScale();
    }
    if (!(intScale > 1 && intScale <= 36)) {
      incorrectScale();
    }
  }

  private void incorrectScale() {
    throw new IllegalArgumentException("Incorrect scale indication (" + scale + ")");
  }

  private void checkAlphaNumericNumber() {
    int max = 0;
    char[] charsInValue = value.toCharArray();
    for (char c : charsInValue) {
      int valueOfChar = conversion10Map.get(String.valueOf(c));
      max = valueOfChar > max ? valueOfChar : max;
    }
    if (max > Integer.parseInt(scale) - 1)
      throw new IllegalArgumentException("Number " + value + " cannot be represented in scale system " + scale);
  }

  public String getScale10Value() {
    if (scale.equals("10")) {
      return value;
    }
    BigInteger sum = new BigInteger("0");
    char[] charsInValue = value.toCharArray();
    for (int i = 0; i < charsInValue.length; i++) {
      int scale10ValueOfChar = conversion10Map.get(String.valueOf(charsInValue[i]));
      BigInteger temp1 = BigInteger.valueOf(scale10ValueOfChar);
      BigInteger temp2 = new BigInteger(scale);
      temp2 = temp2.pow(charsInValue.length - i - 1);
      sum = sum.add(temp1.multiply(temp2));
    }
    return String.valueOf(sum);
  }

  public String getConvertedValue(String expression) {
    if (scale.equals("10")) {
      return expression;
    }
    BigInteger bigExpression = new BigInteger(expression);
    BigInteger bigScale = new BigInteger(scale);
    if (bigExpression.compareTo(bigScale) < 0) {
      return reverseConversion10Map.get(Integer.parseInt(expression));
    }
    BigInteger[] division = bigExpression.divideAndRemainder(bigScale);
    String result = reverseConversion10Map.get(division[1].intValue());
    result = getConvertedValue(String.valueOf(division[0])) + result;
    return result;
  }
}
