class Solution {
    private int maxDiameter = 0; // global variable to track max diameter

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);              // call dfs to calculate heights and update diameter
        return maxDiameter;     // return the final diameter found
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;   // base case: empty node ki height 0 hoti hai

        int leftHeight = dfs(node.left);    // left subtree ki height nikalte hain
        int rightHeight = dfs(node.right);  // right subtree ki height nikalte hain

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        // yahan max diameter update karte hain; diameter = leftHeight + rightHeight

        return 1 + Math.max(leftHeight, rightHeight); 
        // current node ki height = 1 + max(left, right) height
    }
}
