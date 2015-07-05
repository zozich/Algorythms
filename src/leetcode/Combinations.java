package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0) {
            return result;
        }
        for (int i = n; i > 0; i--) {
            if (k == 1) {
                List<Integer> firstValue = new ArrayList<Integer>();
                firstValue.add(i);
                result.add(firstValue);
            } else {
                List<List<Integer>> subresult = combine(i - 1, k - 1);
                for (List<Integer> list : subresult) {
                    list.add(i);
                }
                result.addAll(subresult);
            }
        }
        return result;
    }
}
