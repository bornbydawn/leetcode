package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PseudoPalindromicPathsInRootToLeaf {

    class NumWrapper {
        int answer = 0;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        NumWrapper numWrapper = new NumWrapper();
        Map<Integer, Integer> countMap = new HashMap<>();
        printPaths(root, countMap, numWrapper);
        return numWrapper.answer;
    }



    private void printPaths(TreeNode node, Map<Integer, Integer> countMap,
            NumWrapper numWrapper) {
        if (node == null)
            return;

        updateFrequency(countMap, node, false);
        if (node.left == null && node.right == null) {
            int oddCounts = 0;
            for (Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() % 2 != 0)
                    oddCounts++;
                if (oddCounts > 1)
                    break;
            }
            if (oddCounts <= 1) {
                numWrapper.answer++;
            }
            updateFrequency(countMap, node, true);
            return;
        }

        printPaths(node.left, countMap, numWrapper);
        printPaths(node.right, countMap, numWrapper);

        updateFrequency(countMap, node, true);

    }

    private void updateFrequency(Map<Integer, Integer> countMap, TreeNode node, boolean isRemove) {
        if (!isRemove) {
            countMap.put(node.val, countMap.getOrDefault(node.val, 0) + 1);
        } else {
            countMap.put(node.val, countMap.get(node.val) - 1);
        }
    }

    public static void main(String[] args) {
        PseudoPalindromicPathsInRootToLeaf printRootToLeafPaths = new PseudoPalindromicPathsInRootToLeaf();

        TreeNode root = new TreeNode(1);

         root.left = new TreeNode(1);
         root.left.left = new TreeNode(1);
         root.left.right = new TreeNode(1);

         root.right = new TreeNode(2);

         root.right.right = new TreeNode(1);

        System.out.println(printRootToLeafPaths.pseudoPalindromicPaths(root));
    }


        // private void printPaths(TreeNode node, List<TreeNode> stack, Map<Integer, Integer> countMap,
    //         NumWrapper numWrapper) {
    //     if (node == null)
    //         return;

    //     stack.add(node);
    //     updateFrequency(countMap, node, false);
    //     if (node.left == null && node.right == null) {
    //         int oddCounts = 0;
    //         for (Entry<Integer, Integer> entry : countMap.entrySet()) {
    //             if (entry.getValue() % 2 != 0)
    //                 oddCounts++;
    //             if (oddCounts > 1)
    //                 break;
    //         }
    //         if (oddCounts <= 1) {
    //             numWrapper.answer++;
    //         }
    //         stack.remove(node);
    //         updateFrequency(countMap, node, true);
    //         return;
    //     }

    //     printPaths(node.left, stack, countMap, numWrapper);
    //     printPaths(node.right, stack, countMap, numWrapper);

    //     stack.remove(node);
    //     updateFrequency(countMap, node, true);

    // }


    // public int pseudoPalindromicPaths(TreeNode root) {

    //     List<TreeNode> stack = new LinkedList<>();
    //     NumWrapper numWrapper = new NumWrapper();
    //     Map<Integer, Integer> countMap = new HashMap<>();
    //     printPaths(root, stack, countMap, numWrapper);
    //     return numWrapper.answer;
    // }

}
