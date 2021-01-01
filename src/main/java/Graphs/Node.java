package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public int distanceFromRoot;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, int _distanceFromRoot) {
        val = _val;
        neighbors = new ArrayList<Node>();
        distanceFromRoot = _distanceFromRoot;
    }
    public Node(int _val, ArrayList<Node> _neighbors, int _distanceFromRoot) {
        val = _val;
        neighbors = _neighbors;
        distanceFromRoot = _distanceFromRoot;
    }
}
