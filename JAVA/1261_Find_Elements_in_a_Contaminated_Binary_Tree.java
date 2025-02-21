// Problem Number: 1261

// Problem Name: Find Elements in a Contaminated Binary Tree.

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
class FindElements {
  public FindElements(TreeNode root) {
    dfs(root, 0);
  }

  public boolean find(int target) {
    return vals.contains(target);
  }

  private Set<Integer> vals = new HashSet<>();

  private void dfs(TreeNode root, int val) {
    if (root == null)
      return;

    root.val = val;
    vals.add(val);
    dfs(root.left, val * 2 + 1);
    dfs(root.right, val * 2 + 2);
  }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
