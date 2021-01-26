package Tree;

import Graphs.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        root.right.left.left = new TreeNode(21);
        root.right.left.right = new TreeNode(22);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(24);

        AllNodesDistanceKInBinaryTree object = new AllNodesDistanceKInBinaryTree();
        System.out.println(object.distanceK(root, root.right, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        Graph<TreeNode> graph = new Graph();
        populateAdjacencyList(root, graph);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> distanceKNodesList = Collections.EMPTY_LIST;

        boolean toBreak = false;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                if (distance == K) {
                    distanceKNodesList = queue.stream().map(t -> t.val).collect(Collectors.toList());
                    toBreak = true;
                    break;
                }
                size--;
                TreeNode treeNode = queue.poll();
                visited.add(treeNode);
                if (graph.getAdjList().containsKey(treeNode)) {
                    graph.getAdjList().get(treeNode).stream().filter(item -> !visited.contains(item)).forEach(node -> queue.add(node));
                }
            }
            if (toBreak) break;
            distance++;
        }

        return distanceKNodesList;

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
