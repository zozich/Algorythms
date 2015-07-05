package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            addSubSetsToResult(result, nums[i]);
        }
        return result;
    }

    private void addSubSetsToResult(List<List<Integer>> result, int value) {
        if (result.isEmpty()) {
            List<Integer> list1 = new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(value);
            Collections.addAll(result, list1, list2);
        } else {
            int listSize = result.size();
            for (int i = 0; i < listSize; i++) {
                List<Integer> copyList = new ArrayList<Integer>(result.get(i));
                copyList.add(value);
                result.add(copyList);
            }
        }
    }
}
