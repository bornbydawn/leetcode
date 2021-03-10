package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(1);
//
//        root.right.left = new TreeNode(5);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.left = new TreeNode(4);

        AddOneRowToTree object = new AddOneRowToTree();
        TreeNode newRoot = object.addOneRow(root, 5, 4);
        TreeNode.print2D(newRoot);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int level = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size != 0) {
                    TreeNode currentNode = q.poll();
                    size--;
                    if (level == d - 1) {
                        if (currentNode.left != null) {
                            TreeNode newNode = new TreeNode(v);
                            TreeNode oldLeft = currentNode.left;
                            currentNode.left = newNode;
                            newNode.left = oldLeft;
                        } else {
                            currentNode.left = new TreeNode(v);
                        }
                        if (currentNode.right != null) {
                            TreeNode newNode = new TreeNode(v);
                            TreeNode oldRight = currentNode.right;
                            currentNode.right = newNode;
                            newNode.right = oldRight;
                        } else {
                            currentNode.right = new TreeNode(v);
                        }
                    }
                    if (currentNode.left != null) q.add(currentNode.left);
                    if (currentNode.right != null) q.add(currentNode.right);
                }
                if (level == d - 1) {
                    return root;
                }
                level++;
            }
        }
        return root;
    }

}
