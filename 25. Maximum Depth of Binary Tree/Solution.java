class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;           // base case: agar node null hai, depth 0
        int leftDepth = maxDepth(root.left);  // left subtree ki depth nikalte hain
        int rightDepth = maxDepth(root.right);// right subtree ki depth nikalte hain
        return 1 + Math.max(leftDepth, rightDepth);  // current node ki depth = 1 + max(left, right)
    }
}