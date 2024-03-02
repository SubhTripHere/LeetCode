package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://assets.leetcode.com/uploads/2023/04/18/graph.png

   -1    -1    -1     -1
2---->0---->3------>4----->1

    1    1      3      1
2---->0---->3------>4----->1


*/
public class ModifyGraphEdgeWeights {

    public static void main(String[] args) {
        int[][] graph=modifiedGraphEdges(5,new int[][]{{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}},0,1,5);
        for (int[] g:graph){
            for (int i = 0; i <g.length ; i++) {
                System.out.print(g[i]+" ");
            }
            System.out.println("");
        }
    }


        private static int dijkstra(List<List<int[]>> graph, int source, int destination, int n) {
            Queue<int[]> que = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            que.offer(new int[]{source, 0});
            boolean[] visited = new boolean[n];
            while(!que.isEmpty()) {
                int[] cur = que.poll();
                visited[cur[0]] = true;
                if(cur[0] == destination) return cur[1];
                for(int[] neighbor: graph.get(cur[0])) {
                    if(visited[neighbor[0]]) continue;
                    que.offer(new int[]{neighbor[0], neighbor[1] + cur[1]});
                }
            }
            return Integer.MAX_VALUE;
        }
        public static int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
            List<List<int[]>> graph = new ArrayList<>();
            for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
            for(int[] edge: edges) {
                if(edge[2] == -1) continue;
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
                graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
            }
            int a = dijkstra(graph, source, destination, n), walked = 0;
            if(a < target) return new int[][] { };
            if(a == target) {
                for(int e[]: edges) if(e[2] == -1) e[2] = 1000000000;
                return edges;
            }
            for(int[] edge: edges) {
                if(edge[2] == -1) {
                    graph.get(edge[0]).add(new int[]{edge[1], 1});
                    graph.get(edge[1]).add(new int[]{edge[0], 1});
                    int res = dijkstra(graph, source, destination, n);
                    if(res <= target) {
                        edge[2] = Math.max(target - res + 1, 1);
                        for(int[] e: edges) {
                            if(e[2] == -1) e[2] = 1000000000;
                        }
                        return edges;
                    } else {
                        edge[2] = 1;
                        walked ++;
                    }
                }
            }
            return new int[][] { };
        }

}
