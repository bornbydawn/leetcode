package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        //List<Integer> answer = new TopologicalSort().topologicalSort(g);
        List<Integer> answer = new TopologicalSort().topologicalSortKahns(g);
        System.out.println(answer);
    }

    public List<Integer> topologicalSort(Graph g) {

        int V = g.V;

        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(g, i, visited, stack);
            }
        }

        List<Integer> answer = new ArrayList<>(V);
        while(!stack.empty()) answer.add(stack.pop());
        return answer;
    }

    public void topologicalSortUtil(Graph g, int v, boolean[] visited, Stack<Integer> stack) {

        visited[v] = true;

        Iterator<Integer> iterator = g.adj[v].iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (!visited[i]) {
                topologicalSortUtil(g, i, visited, stack);
            }
        }
        stack.push(v);
    }

    public List<Integer> topologicalSortKahns(Graph g) {

        int V = g.V;
        int indegree[] = new int[g.V];
        
        for(int i = 0; i < g.V; i++){
            for(Integer v : g.adj[i]){
                ++indegree[v];
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        List<Integer> answer = new ArrayList<>(V);

        while(!q.isEmpty()){
            int u = q.poll();
            answer.add(u);

            for(int neighbor : g.adj[u]){
                if(--indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
            count++;
        }

        if(count != V){
            return null;
        }
        return answer;

    }

}
