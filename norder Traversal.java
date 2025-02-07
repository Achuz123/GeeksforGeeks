class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result); // Visit left subtree
        result.add(node.data);            // Process current node
        inorderHelper(node.right, result); // Visit right subtree
    }
}
