package leetcode;

import java.util.*;

public class RepeatedDNA {

  public static void main(String[] args) {
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    System.out.println(new RepeatedDNA().findRepeatedDnaSequences(s));
  }

  private Map<Character, Integer> charMap = new HashMap<Character, Integer>() {
    {
      put('A', 1);
      put('C', 2);
      put('G', 3);
      put('T', 4);
    }
  };

  public List<String> findRepeatedDnaSequences(String s) {
    Set<Long> all = new HashSet<Long>();
    Set<Long> repeated = new HashSet<Long>();
    for (int i = 0; i < s.length() - 9; i++) {
      String newString = s.substring(i, i + 10);
      Long longValue = getLongValue(newString);
      if (all.contains(longValue)) {
        repeated.add(longValue);
      } else {
        all.add(longValue);
      }
    }
    return getRepeatedStrings(repeated);
  }

  private List<String> getRepeatedStrings(Set<Long> repeated) {
    List<String> result = new ArrayList<String>();
    for (Long value : repeated) {
      result.add(getStringValue(value));
    }
    return result;
  }

  private String getStringValue(Long value) {
    String result = String.valueOf(value);
    result = result.replaceAll("1", "A");
    result = result.replaceAll("2", "C");
    result = result.replaceAll("3", "G");
    result = result.replaceAll("4", "T");
    return result;
  }

  private long getLongValue(String newString) {
    long result = 0;
    for (int i = 0; i < 10; i++) {
      result += (long) (charMap.get(newString.charAt(i)) * Math.pow(10, 10 - i - 1));
    }
    return result;
  }
}
