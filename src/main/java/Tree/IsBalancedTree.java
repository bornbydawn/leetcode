package Tree;

import java.util.HashMap;
import java.util.Map;

public class IsBalancedTree {

    class Height{
        int h = 0;
    }
    public static void main(String[] args) {
        IsBalancedTree isBalancedTree = new IsBalancedTree();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        root.right.right = new TreeNode(3);

//        root.right = new TreeNode(2);
//
//
//        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(3);
//
//
//        root.left.left.left = new TreeNode(4);
//
//        root.left.left.right = new TreeNode(4);


        System.out.println(isBalancedTree.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedUtil(root, new Height());
    }

    private boolean isBalancedUtil(TreeNode root, Height height) {

        if(root == null){
            height.h = 0;
            return true;
        }

        Height lh = new Height(); Height rh = new Height();
        boolean l = isBalancedUtil(root.left, lh);
        boolean r = isBalancedUtil(root.right, rh);

        int lheight = lh.h; int rheight = rh.h;

        height.h = 1 + Math.max(lheight, rheight);

        if(Math.abs(lheight - rheight) > 1) return false;
        else return l && r;
    }

}
