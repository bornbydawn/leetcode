package Tree;

import javafx.util.Pair;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(11);
        root.left.left = new TreeNode(9);


        root.right = new TreeNode(1);

        root.right.left = new TreeNode(2);


        root.right.left.right = new TreeNode(3);

        root.right.left.right.right = new TreeNode(8);

        root.right.left.right.left = new TreeNode(4);

        root.right.left.right.left.left = new TreeNode(6);

        root.right.left.right.left.left.left = new TreeNode(7);



        VerticalOrderTraversal object = new VerticalOrderTraversal();
        List<List<Integer>> integerList = object.verticalTraversal(root);
        integerList.stream().forEachOrdered(list -> System.out.print(list));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> tempMap = new HashMap<>();
        List<List<Integer>> answer = new LinkedList<>();
        Map<Integer, List<Integer>> answerMap = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            tempMap.clear();
            while (size != 0) {
                Pair<TreeNode, Integer> currentNode = q.poll();
                if (tempMap.containsKey(currentNode.getValue())) {
                    tempMap.get(currentNode.getValue()).add(currentNode.getKey().val);
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(currentNode.getKey().val);
                    tempMap.put(currentNode.getValue(), list);
                }
                if (currentNode.getKey().left != null) {
                    q.add(new Pair<>(currentNode.getKey().left, currentNode.getValue() - 1));
                }
                if (currentNode.getKey().right != null) {
                    q.add(new Pair<>(currentNode.getKey().right, currentNode.getValue() + 1));
                }
                size--;
            }
            for (Map.Entry<Integer, List<Integer>> tempMapEntry : tempMap.entrySet()) {
                if(tempMapEntry.getValue().size() > 1) Collections.sort(tempMapEntry.getValue());
                if (answerMap.containsKey(tempMapEntry.getKey())) {
                    answerMap.get(tempMapEntry.getKey()).addAll(tempMapEntry.getValue());
                } else {
                    answerMap.put(tempMapEntry.getKey(), tempMapEntry.getValue());
                }
            }
        }
        answerMap.entrySet().stream().forEachOrdered(m -> answer.add(m.getValue()));
        return answer;
    }

}
