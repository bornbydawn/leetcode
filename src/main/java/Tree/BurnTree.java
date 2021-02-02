package Tree;

import Graphs.MapGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BurnTree {
    public static void main(String[] args) {

        BurnTree object = new BurnTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        root.right.left.left = new TreeNode(21);
        root.right.left.right = new TreeNode(22);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(24);

        object.burnTree(root, root.right.left);
    }

    void burnTree(TreeNode root, TreeNode target) {

        MapGraph<TreeNode> graph = new MapGraph<>();
        populateAdjacencyList(root, graph);
        //Graph.printGraph(graph);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> burnt = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.val + " ");
                burnt.add(treeNode);
                if (graph.getAdjList().containsKey(treeNode)) {
                    graph.getAdjList().get(treeNode).stream().filter(item -> !burnt.contains(item)).forEach(node -> queue.add(node));
                }
            }
            System.out.println();
        }

    }

    void populateAdjacencyList(TreeNode root, MapGraph<TreeNode> graph) {
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
