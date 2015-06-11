package leetcode;

public class SortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return null;
    }
    return findNextNode(nums, 0, nums.length - 1);
  }

  private TreeNode findNextNode(int[] nums, int start, int end) {
    int rootIndex;
    if (end == start) {
      rootIndex = start;
    } else {
      rootIndex = (end - start + 1) / 2 + start;
    }
    TreeNode localRoot = new TreeNode(nums[rootIndex]);
    if (rootIndex > start) {
      localRoot.left = findNextNode(nums, start, rootIndex - 1);
    }
    if (rootIndex < end) {
      localRoot.right = findNextNode(nums, rootIndex + 1, end);
    }
    return localRoot;
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
