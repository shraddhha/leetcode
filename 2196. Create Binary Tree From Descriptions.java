class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // Create nodes and establish parent-child relationships
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode parent = nodes.computeIfAbsent(parentVal, k -> new TreeNode(k));
            TreeNode child = nodes.computeIfAbsent(childVal, k -> new TreeNode(k));

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        // Find the root (a node that is never a child)
        TreeNode root = null;
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                root = nodes.get(desc[0]);
                break;
            }
        }

        return root;
    
        
    }
}
