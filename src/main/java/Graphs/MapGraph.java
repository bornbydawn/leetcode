package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class MapGraph<T> {
    Map<T, LinkedList<T>> adjList;

    public MapGraph() {
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

    /***
     * Please also be aware that there is absolutely no relationship between the class-level type variable I and the static method type variable U.
     * use a different variable name when declaring generic methods, static or otherwise, inside generic classes.
     * @param graph
     * @param <U>
     */
    public static <U> void printGraph(MapGraph<U> graph) {
        for (Entry<U, LinkedList<U>> entry : graph.getAdjList().entrySet()) {
            System.out.println("\nAdjacency list of vertex" + entry.getKey());
            System.out.print("head");
            for (U adjacent : entry.getValue()) {
                System.out.print(" -> " + adjacent.toString());
            }
            System.out.println();
        }
    }
}
