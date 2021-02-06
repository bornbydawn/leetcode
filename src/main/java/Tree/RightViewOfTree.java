package Tree;

import javafx.util.Pair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        //root.left = new TreeNode(5);
//        root.left.right = new TreeNode(11);
//        root.left.left = new TreeNode(9);
//
//
//        root.right = new TreeNode(1);
//
//        root.right.left = new TreeNode(2);
//
//
//        root.right.left.right = new TreeNode(3);
//
//        root.right.left.right.right = new TreeNode(8);
//
//        root.right.left.right.left = new TreeNode(4);
//
//        root.right.left.right.left.left = new TreeNode(6);
//
//        root.right.left.right.left.left.left = new TreeNode(7);


        RightViewOfTree object = new RightViewOfTree();
        List<Integer> integerList = object.rightSideView(root);
        integerList.stream().forEachOrdered(System.out::print);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> answer = new LinkedList<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int valueFromThisLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                Pair<TreeNode, Integer> currentNode = q.poll();
                valueFromThisLevel = currentNode.getKey().val;
                if (currentNode.getKey().left != null) {
                    q.add(new Pair<>(currentNode.getKey().left, currentNode.getValue() - 1));
                }
                if (currentNode.getKey().right != null) {
                    q.add(new Pair<>(currentNode.getKey().right, currentNode.getValue() + 1));
                }
                size--;
            }
            answer.add(valueFromThisLevel);
        }
        return answer;
    }

}
