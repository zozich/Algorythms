package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        //root.right = new TreeNode(2);
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode previous = root;
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();
            if (isVisited(currentNode, previous, stack)) {
                stack.poll();
                previous = currentNode;
                list.add(currentNode.val);
            } else {
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            }
        }
        return list;
    }

    private boolean isVisited(TreeNode currentNode, TreeNode previous, Deque<TreeNode> stack) {
        if (currentNode.right == previous) {
            return true;
        } else if (currentNode.right == null) {
            if (currentNode.left == previous) {
                return true;
            } else if (currentNode.left == null) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
