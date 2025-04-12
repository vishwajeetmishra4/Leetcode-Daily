/*
 * Problem: 1028. Recover a Tree From Preorder Traversal
 * Link: https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 * 
 * You are given a string traversal representing a preorder traversal of a binary tree.
 * The string uses dashes '-' to indicate the depth of each node.
 * Return the root of the tree that was traversed.
 * 
 * Example:
 * Input: traversal = "1-2--3--4-5--6--7"
 * Output: Preorder traversal of recovered tree → 1 2 3 4 5 6 7
 * 
 * Approach: Use a stack to maintain the correct parent node at each depth.
 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;

            // Count dashes to determine depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Read the number (node value)
            int numStart = i;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                i++;
            }
            int value = Integer.parseInt(traversal.substring(numStart, i));

            TreeNode node = new TreeNode(value);

            // If stack size > depth, pop until stack has correct depth parent
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach to parent if exists
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            // Push current node to stack
            stack.push(node);
        }

        // Root node is the first node in stack
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }

    // Helper function to print tree in preorder
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String traversal = "1-2--3--4-5--6--7";
        TreeNode root = sol.recoverFromPreorder(traversal);

        System.out.println("Preorder Traversal of Recovered Tree:");
        preorder(root);
    }

    public boolean divideArray(int[] nums) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'divideArray'");
    }
}
