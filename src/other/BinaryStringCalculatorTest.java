package other;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinaryStringCalculatorTest {

  @Test
  public void simpleString() {
    String s1 = "101";
    String s2 = "01";
    String expected = "110";
    assertEquals(expected, BinaryStringCalculator.add(s1, s2));
  }

  @Test
  public void mediumSizeString() {
    String s1 = "110010";
    String s2 = "111";
    String expected = "111001";
    assertEquals(expected, BinaryStringCalculator.add(s1, s2));
  }

  @Test
  public void needToIncreaseLength() {
    String s1 = "111";
    String s2 = "111";
    String expected = "1110";
    assertEquals(expected, BinaryStringCalculator.add(s1, s2));
  }

  @Test
  public void bigString() {
    String s1 = "1111111111111111111111111111111111111111111111111111111";
    String s2 = "1111111111111111111111111111111111111111111111111111111";
    String expected = "11111111111111111111111111111111111111111111111111111110";
    assertEquals(expected, BinaryStringCalculator.add(s1, s2));
  }

  @Test
  public void anotherBigString() {
    String s1 = "10101010101010101010101010";
    String s2 = "11111111111111111111111111";
    String expected = "110101010101010101010101001";
    assertEquals(expected, BinaryStringCalculator.add(s1, s2));
  }

  @Test
  public void emptyString() {
    String s1 = "101";
    String s2 = "";
    String expected = "101";
    assertEquals(expected, BinaryStringCalculator.add(s1, s2));
  }
}
