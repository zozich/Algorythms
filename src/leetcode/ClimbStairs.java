package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

  public static void main(String[] args) {
    ClimbStairs climbStairs = new ClimbStairs();
    System.out.println(climbStairs.climbStairs(3));
  }

  public int climbStairs(int n) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
      {
        put(1, 1);
        put(2, 2);
      }
    };
    return find(n, n, map);
  }

  public int find(int n, int start, Map<Integer, Integer> map) {
    if (start <= 0) {
      return 0;
    }
    if (map.containsKey(start)) {
      return map.get(start);
    }
    Integer res = find(n, start - 1, map) + find(n, start - 2, map);
    map.put(start, res);
    return res;
  }
}
