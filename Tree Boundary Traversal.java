import java.util.*;

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        if (node == null) return result; // Handle empty tree

        // Add root only once
        if (!isLeaf(node)) result.add(node.data);

        // Left Boundary (excluding leaf nodes)
        getLeftBoundary(node.left, result);

        // Leaf Nodes (from left to right)
        getLeafNodes(node, result);

        // Right Boundary (excluding leaf nodes)
        ArrayList<Integer> rightBoundary = new ArrayList<>();
        getRightBoundary(node.right, rightBoundary);
        Collections.reverse(rightBoundary); // Reverse before adding
        result.addAll(rightBoundary);

        return result;
    }

    // Collect left boundary (excluding leaf nodes)
    private void getLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Collect leaf nodes in left-to-right order
    private void getLeafNodes(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        getLeafNodes(node.left, result);
        getLeafNodes(node.right, result);
    }

    // Collect right boundary (excluding leaf nodes)
    private void getRightBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
    }

    // Check if a node is a leaf
    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}
