package calculator;

/**
 * Created by Andrew on 10.03.2015.
 */
public class NumberFactory {

  public static Number createNumber(String numberValue, String scale) {
    if (scale.equals("r")) {
      return new RomanNumber(numberValue.toUpperCase());
    } else {
      return new AlphaNumericNumber(numberValue.toUpperCase(), scale);
    }
  }
}
