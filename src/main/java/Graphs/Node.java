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
    public Node(int _val) {
        val = _val;
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
    static void addEdge(ArrayList<ArrayList<Integer> > adj, 
                        int u, int v) 
    { 
        adj.get(u).add(v); 
        adj.get(v).add(u); 
    }
    // A utility function to print the adjacency list 
    // representation of graph 
    static void printGraph(ArrayList<ArrayList<Integer> > adj) 
    { 
        for (int i = 0; i < adj.size(); i++) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            System.out.print("head"); 
            for (int j = 0; j < adj.get(i).size(); j++) { 
                System.out.print(" -> "+adj.get(i).get(j)); 
            } 
            System.out.println(); 
        } 
    }
    
}
