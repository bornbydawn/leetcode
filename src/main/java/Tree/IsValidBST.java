package Tree;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);

        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        //TreeNode.print2D(root);
        IsValidBST object = new IsValidBST();
        System.out.println(object.isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doInorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void doInorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        doInorder(root.left, list);
        list.add(root.val);
        doInorder(root.right, list);

    }

}
