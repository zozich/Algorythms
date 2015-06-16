package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

  public static void main(String[] args) {

  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if (root == null) {
      return list;
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode currentNode = stack.peek();
      if (currentNode.left != null) {
        stack.push(currentNode.left);
      }
      if (currentNode.right != null) {

      }
    }
    list.add(root.val);

    return list;
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
