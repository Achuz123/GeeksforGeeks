class Solution {
    private static int preIndex = 0;
    
    public static Node buildTree(int[] inorder, int[] preorder) {
        preIndex = 0;
        return construct(preorder, inorder, 0, inorder.length - 1);
    }
    
    private static Node construct(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);
        
        int inorderIndex = start;
        while (inorder[inorderIndex] != rootVal) {
            inorderIndex++;
        }
        
        root.left = construct(preorder, inorder, start, inorderIndex - 1);
        root.right = construct(preorder, inorder, inorderIndex + 1, end);
        
        return root;
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        
        Node root = buildTree(inorder, preorder);
        
        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root);
    }
    
    private static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
