package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScientificCalculatorTest {

  @Test
  public void simpleString() {
    String expression = "123+345";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "468";
    assertEquals(expected, actual);
  }

  @Test
  public void stringWithSpaces() {
    String expression = "123 + 345";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "468";
    assertEquals(expected, actual);
  }

  @Test
  public void simpleRomanNumber() {
    String expression = "IV(r)+VI(r)";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "X(r)";
    assertEquals(expected, actual);
  }

  @Test
  public void simpleBinaryStrings() {
    String expression = "1010(2)+101(2)";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "1111(2)";
    assertEquals(expected, actual);
  }

  @Test
  public void HexAndDecimalStrings() {
    String expression = "AB34(16)+1234";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "B006(16)";
    assertEquals(expected, actual);
  }

  @Test
  public void RomanAndDecimalStrings() {
    String expression = "IV(r)+12";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "XVI(r)";
    assertEquals(expected, actual);
  }

  @Test
  public void bigNumberWith36Radix() {
    String expression = "FFFFFFFFFFFFFFFFFFFFF(16)+ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ(36)";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "4F2A04BCC8C649DA825DD6321D65BB5B464FFFFFFFFFFFFFFFFFFFFE(16)";
    assertEquals(expected, actual);
  }

  @Test
  public void romanNumberWithIncorrectLetterSequence() {
    String expression = "CCDMVII(r)+1";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "The numbers in roman numeral CCDMVII are represented in wrong sequence";
    assertEquals(expected, actual);
  }

  @Test
  public void incorrectScaleSystemIndication() {
    String expression = "FF(15)+12";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "Number FF cannot be represented in scale system 15";
    assertEquals(expected, actual);
  }

  @Test
  public void unsupportedOperation() {
    String expression = "123==12";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "Calculator does not support this operation yet";
    assertEquals(expected, actual);
  }

  @Test
  public void mistakeInExpression() {
    String expression = "12";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "Mistake in entered expression";
    assertEquals(expected, actual);
  }

  @Test
  public void romanNumberWithIllegalCharacters() {
    String expression = "VIJ(r)+123";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "Roman numeral VIJ indicated incorrectly (illegal characters)";
    assertEquals(expected, actual);
  }

  @Test
  public void nonexistentScaleSystemIndication() {
    String expression = "AF12(40)+10(2)";
    String actual = ScientificCalculator.readExpression(expression);
    String expected = "Incorrect scale indication (40)";
    assertEquals(expected, actual);
  }
}