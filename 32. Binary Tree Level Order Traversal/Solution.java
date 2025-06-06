class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;  // agar tree empty hai to return empty list

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // root node ko queue mein daala

        while (!queue.isEmpty()) {
            int size = queue.size();  // current level ke nodes count
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();  // queue se ek node nikala
                level.add(node.val);          // uska value level list mein daala

                if (node.left != null) queue.offer(node.left);   // left child add karo
                if (node.right != null) queue.offer(node.right); // right child add karo
            }

            result.add(level);  // current level complete, result mein daala
        }

        return result;
    }
}
