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
class Solution {
    public int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int root = preorder[preIndex];
        int partitionIndex = search(root, inorder);

        return recur(preorder, inorder, 0, inorder.length - 1);
    }
  
    public TreeNode recur(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int newRoot = preorder[preIndex++];

        if (start == end) {
            return new TreeNode(newRoot, null, null);
        }

        int searchIndex = search(newRoot, inorder);
        TreeNode left = recur(preorder, inorder, start, searchIndex - 1);
        TreeNode right = recur(preorder, inorder, searchIndex + 1, end);
        return new TreeNode(newRoot, left, right);
    }

    // returns index of searched val in arr
    public int search(int val, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (val ==  arr[i]) {
                return i;
            }
        }
        return 0;
    }
}