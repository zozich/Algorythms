package leetcode;

import java.util.*;

public class Permutation {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> notUsedIndexes = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            notUsedIndexes.add(i);
        }
        updateResult(nums, notUsedIndexes, new ArrayList<Integer>());
        return result;
    }

    private void updateResult(int[] nums, Set<Integer> notUsedIndexes, List<Integer> resultList) {
        for (int index : notUsedIndexes) {
            Set<Integer> updatedUnusedIndexes = new HashSet<Integer>(notUsedIndexes);
            updatedUnusedIndexes.remove(index);
            List<Integer> subResult = new ArrayList<Integer>(resultList);
            subResult.add(nums[index]);
            updateResult(nums, updatedUnusedIndexes, subResult);
        }
        if (notUsedIndexes.size() == 0) {
            result.add(resultList);
        }
    }
}
