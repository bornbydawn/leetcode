package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public static void main(String[] args) {
        int [][]graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};

        int graph2[][] = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        int graph3[][] = new int[][]{{4},{},{4},{4},{0,2,3}};
        int graph4[][] = new int[][]{{}};
        
        int graph5[][] = new int[][]{{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
        int graph6[][] = new int[][]{{1},{0},{4},{4},{2,3}};
        int graph7[][] = new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};

        System.out.println(new IsBipartite().isBipartite(graph7));

    }

    public boolean isBipartite(int[][] graph) {
        
        if(graph.length == 1 && graph[0].length == 0) return true;


        final int V = graph.length;
        
        int colorArray[] = new int[V];
        Arrays.fill(colorArray, -1);

       

        int start = -1;
        
        //get the starting point for bfs
        for(int i = 0; i < V; i++){
            if(graph[i].length > 0){
                start = i;
                break;
            }
        }

        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.add(start);

        //value 1 is color a, value 0 is color b
        colorArray[start] = 1;

        while(vertexQueue.size() != 0){
            int vertex = vertexQueue.poll();

            for(int v = 0; v < graph[vertex].length; v++){

                if(colorArray[graph[vertex][v]] == -1){
                    colorArray[graph[vertex][v]] = 1- colorArray[vertex];
                    vertexQueue.add(graph[vertex][v]);
                }
                else if(colorArray[vertex] == colorArray[graph[vertex][v]]){
                    return false;
                }
            }
            if(vertexQueue.size() == 0){
                for(int i = 0 ; i < V; i++){
                    if(graph[i].length > 0 && colorArray[i] == -1){
                        vertexQueue.add(i);
                        colorArray[i] = 1 - colorArray[vertex];
                        break;
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(colorArray));
        // for(int i = 0 ; i < V; i++){
        //     if(graph[i].length > 0 && colorArray[i] == -1){
        //         return false;
        //     }
        // }
        
        return true;
    }


}
