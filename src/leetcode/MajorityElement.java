package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

  public static void main(String[] args) {
    int[] array = {9, 6, 4, 3, 9, 3, 2, 9, 9, 1, 9, 9, 9};
    System.out.println(new MajorityElement().majorityElement(array));
  }

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      Integer arrayElement = nums[i];
      if (map.containsKey(arrayElement)) {
        map.put(arrayElement, map.get(arrayElement) + 1);
      } else {
        map.put(arrayElement, 1);
      }
    }
    Integer requiredLength = nums.length / 2 + 1;
    for (Integer value : map.keySet()) {
      if (map.get(value) >= requiredLength) {
        return value;
      }
    }
    return 0;
  }
}
