package Tree;

import Graphs.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumTimeToBurnTreeStartingFromLeafNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        root.right.right = new TreeNode(12);
        root.right.right.right = new TreeNode(13);

        root.left.left.left = new TreeNode(8);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.left.right.left.left = new TreeNode(11);
        System.out.println(new MinimumTimeToBurnTreeStartingFromLeafNode().minCost(root, root.left.right.left.left));
    }

    public int minCost(TreeNode root, TreeNode leafNode) {

        Graph<TreeNode> graph = new Graph();
        populateAdjacencyList(root, graph);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(leafNode);
        Set<TreeNode> visited = new HashSet<>();

        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode treeNode = queue.poll();
                visited.add(treeNode);
                if (graph.getAdjList().containsKey(treeNode)) {
                    graph.getAdjList().get(treeNode).stream().filter(item -> !visited.contains(item)).forEach(node -> queue.add(node));
                }
            }
        }

        return distance;

    }

    void populateAdjacencyList(TreeNode root, Graph<TreeNode> graph) {
        if (root == null)
            return;

        if (root.left != null)
            graph.addEdge(root, root.left);

        if (root.right != null)
            graph.addEdge(root, root.right);

        populateAdjacencyList(root.left, graph);
        populateAdjacencyList(root.right, graph);
    }
}
