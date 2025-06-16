class Solution {
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Inorder array ke har element ka index store kar rahe hain fast access ke liye
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Helper function se tree banana start kar rahe hain
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        // Agar left > right ho gaya toh null return karo (koi node nahi bachi)
        if (inStart > inEnd) return null;

        // Preorder se current root value lo
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Inorder array me us root ka index find karo
        int index = inorderMap.get(rootVal);

        // Left subtree banao (inStart se index - 1 tak)
        root.left = helper(preorder, inStart, index - 1);

        // Right subtree banao (index + 1 se inEnd tak)
        root.right = helper(preorder, index + 1, inEnd);

        return root;
    }
}
