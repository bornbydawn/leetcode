package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    // No. of vertices 
    int V; 
  
    // An Array of List which contains 
    // references to the Adjacency List of 
    // each vertex 
    List<Integer> adj[]; 
    // Constructor 
    
    public Graph(int V) 
    { 
        this.V = V; 
        adj = new ArrayList[V]; 
        for (int i = 0; i < V; i++) 
            adj[i] = new ArrayList<Integer>(); 
    } 
  
    // Function to add an edge to graph 
    public void addEdge(int u, int v) 
    { 
        adj[u].add(v); 
    }
}
