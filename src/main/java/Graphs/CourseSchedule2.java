package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    int V;
    List<Integer> adj[];


    // Function to add an edge to graph
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        V = numCourses;

        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<Integer>();


        for(int i = 0; i < prerequisites.length; i++){
            addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for(Integer v : adj[i]){
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
        int[] answer = new int[V];

        while(!q.isEmpty()){
            int u = q.poll();
            answer[count] = u;

            for(int neighbor : adj[u]){
                if(--indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
            count++;
        }
        
        if(count != V){
            return new int[0];
        }

        return answer;
    }

    public static void main(String args[]) {       
        int numCourses = 2;
        //int[][] prerequisites = new int[][]{{1,0}};
        int[][] prerequisites = new int[][]{{1,0},{0, 1}};
        int[] answer = new CourseSchedule2().findOrder(numCourses, prerequisites);

        for(int i : answer){
            System.out.println(i);
        }
    }
}
