package Tree;

import Strings.ValidParenthesis;

public class TrimBST {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // root.right = new TreeNode(4);
        // root.right.left = new TreeNode(3);
        // root.right.right = new TreeNode(5);
        // root.left = new TreeNode(-3);
        // root.left.left = new TreeNode(-6);
        // root.left.right = new TreeNode(-1);
        // root.left.right.left = new TreeNode(-2);
        // TrimBST trimBST = new TrimBST();
        // TreeNode newRoot = trimBST.trimBST(root, 2, 5);
        // TreeNode.print2D(newRoot);




        // TreeNode root = new TreeNode(3);
        // root.right = new TreeNode(4);
        // root.left = new TreeNode(1);
        // root.left.right = new TreeNode(2);
        // TrimBST trimBST = new TrimBST();
        // TreeNode newRoot = trimBST.trimBST(root, 3, 4);
        // TreeNode.print2D(newRoot);




        // TreeNode root = new TreeNode(3);
        // root.right = new TreeNode(4);
        // root.right.right = new TreeNode(5);
        // root.right.right.right = new TreeNode(6);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(1);
        // TrimBST trimBST = new TrimBST();
        // TreeNode newRoot = trimBST.trimBST(root, 5, 5);
        // TreeNode.print2D(newRoot);


        // TreeNode root = new TreeNode(3);
        // root.right = new TreeNode(4);
        // root.left = new TreeNode(2);
        // root.left.left = new TreeNode(1);
        // TrimBST trimBST = new TrimBST();
        // TreeNode newRoot = trimBST.trimBST(root, 1, 1);
        // TreeNode.print2D(newRoot);

        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);
        TrimBST trimBST = new TrimBST();
        TreeNode newRoot = trimBST.trimBST(root, 1, 3);
        TreeNode.print2D(newRoot);

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
       return trimBSTUtil(root, low, high);
    }

    private TreeNode trimBSTUtil(TreeNode root, int low, int high) {
        if(root == null) return null;

        //first recur left
        root.left = trimBSTUtil(root.left, low, high);

        //then recur right
        root.right = trimBSTUtil(root.right, low, high);


        //if at any point roots val is lower than low
        //return back the right and nullify the root itself to remove it from tree
        if(root.val < low){
            TreeNode right = root.right;
            root = null;
            return right;
        }

        //if at any point roots val is higer than high
        //return back the left and nullify the root itself to remove it from tree
        if(root.val > high){
            TreeNode left = root.left;
            root = null;
            return left;
        }
        //root is in range
        return root;
    }

    // public TreeNode trimBST(TreeNode root, int low, int high) {
    //     TreeNode tempRoot = new TreeNode();
    //     trimBST(root, low, high, true, tempRoot);

    //     tempRoot = tempRoot.left;

    //     while (tempRoot != null && (tempRoot.val < low || tempRoot.val > high)) {
    //         if(tempRoot.left == null)
    //         tempRoot = tempRoot.right;
    //         else
    //         tempRoot = tempRoot.left;
    //     }

    //     return tempRoot != null ? tempRoot : root;
    // }

    // private void trimBST(TreeNode root, int low, int high, boolean isLeft, TreeNode parent) {
    //     if (root == null)
    //         return;
    //     if (root.val < low) {
    //         if (isLeft) {
    //             parent.left = root.right;
    //         } else {
    //             parent.right = root.right;
    //         }
    //     } else if (root.val > high) {
    //         if (isLeft) {
    //             parent.left = root.left;
    //         } else {
    //             parent.right = root.left;
    //         }
    //     } else if (root.val == low) {

    //         root.left = null;
    //         if (isLeft) {
    //             parent.left = root;
    //         } else {
    //             parent.right = root;
    //         }
    //     } else if (root.val == high) {
    //         root.right = null;
    //         if (isLeft) {
    //             parent.left = root;
    //         } else {
    //             parent.right = root;
    //         }
    //     }
    //     trimBST(root.left, low, high, true, root);
    //     trimBST(root.right, low, high, false, root);
    //     return;
    // }
}
