package Tree;

import java.util.LinkedList;
import java.util.List;

public class PrintRootToLeafPaths {


    private void printPaths(TreeNode node, List<TreeNode> stack){
        if(node == null) return;
        if(node.left == null && node.right == null){
            stack.add(node);
            stack.stream().forEachOrdered(treeNode -> System.out.print(treeNode.val));
            stack.remove(node);
            System.out.println();
            return;
        }
        stack.add(node);

        printPaths(node.left, stack);
        printPaths(node.right, stack);

        stack.remove(node);

    }

    public static void main(String[] args) {
        PrintRootToLeafPaths printRootToLeafPaths = new PrintRootToLeafPaths();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(2);

        root.right.right = new TreeNode(3);
        List<TreeNode> stack = new LinkedList<>();
        printRootToLeafPaths.printPaths(root, stack);
    }

}

