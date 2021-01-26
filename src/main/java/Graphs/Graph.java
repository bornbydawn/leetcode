package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Graph<T> {
    Map<T, LinkedList<T>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public Map<T, LinkedList<T>> getAdjList() {
        return adjList;
    }

    public void addEdge(T u, T v) {
        if (!adjList.containsKey(u)) {
            LinkedList<T> linkedList = new LinkedList<>();
            adjList.put(u, linkedList);
        }
        adjList.get(u).addLast(v);

        if (!adjList.containsKey(v)) {
            LinkedList<T> linkedList = new LinkedList<>();
            adjList.put(v, linkedList);
        }

        adjList.get(v).addLast(u);
    }

    public void printGraph() {
        for (Entry<T, LinkedList<T>> entry : adjList.entrySet()) {
            System.out.println("\nAdjacency list of vertex" + entry.getKey());
            System.out.print("head");
            for (T adjacents : entry.getValue()) {
                System.out.print(" -> " + adjacents.toString());
            }
            System.out.println();
        }
    }
}
