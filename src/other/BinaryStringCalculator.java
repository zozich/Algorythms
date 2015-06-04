package other;

public class BinaryStringCalculator {


  public static String add(String s1, String s2) {
    int maxLength = s1.length() > s2.length() ? s1.length() : s2.length();
    int remainder = 0;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < maxLength; i++) {
      int currentCount = getIntValue(s1, s1.length() - i - 1) + getIntValue(s2, s2.length() - i - 1) + remainder;
      switch (currentCount) {
        case 3: {
          result.append(1);
          remainder = 1;
          continue;
        }
        case 2: {
          result.append(0);
          remainder = 1;
          continue;
        }
        case 1: {
          result.append(1);
          remainder = 0;
          continue;
        }
        case 0: {
          result.append(0);
          remainder = 0;
        }
      }

    }
    if (remainder == 1) {
      result.append(1);
    }
    return result.reverse().toString();
  }

  private static int getIntValue(String string, int index) {
    if (index < 0) {
      return 0;
    } else {
      return string.charAt(index) == '1' ? 1 : 0;
    }
  }
}
