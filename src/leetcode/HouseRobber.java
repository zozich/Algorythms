package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HouseRobber {
  static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

  public static void main(String[] args) {
    int[] nums = new int[1000];
    Random random = new Random();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = random.nextInt(1000);
    }
    System.out.println((new HouseRobber()).rob(nums));
  }

  public int rob(int[] nums) {
    return find(nums, 0);
  }

  public int find(int[] nums, int start) {
    if (start >= nums.length) {
      return 0;
    }
    if (start == nums.length - 1) {
      map.put(start, nums[start]);
      return nums[start];
    }
    if (map.containsKey(start)) {
      return map.get(start);
    }
    int res1 = nums[start] + find(nums, start + 2);
    int res2 = find(nums, start + 1);
    int res = Math.max(res1, res2);
    map.put(start, res);
    return res;
  }
}
