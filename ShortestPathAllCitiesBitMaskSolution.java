package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
/*
https://assets.leetcode.com/uploads/2021/05/12/shortest2-graph.jpg
 */
public class ShortestPathAllCitiesBitMaskSolution {

    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}));
    }

        public static int shortestPathLength(int[][] graph) {
            int n=graph.length;
            Queue<int[] > q=new LinkedList<>();
            for(int i=0;i<n;i++){
                q.add(new int[]{i,1<<i});
            }
            int allVis=(1<<n)-1;
            boolean[][] vis=new boolean[n][allVis+1];
            for(int i=0;i<n;i++){
                vis[i][1<<i]=true;
            }
            int pathLen=0;
            while(!q.isEmpty()){
                int size=q.size();
                while(size>0){
                    int[] node=q.poll();
                    int u=node[0];
                    int bitMask=node[1];
                    if(bitMask==allVis){
                        return pathLen;
                    }
                    for(int nei:graph[u]){
                        int next=bitMask|(1<<nei);
                        if(vis[nei][next])
                            continue;
                        if(next==allVis)
                            return pathLen+1;
                        q.add(new int[]{nei,next});
                        vis[nei][next]=true;
                    }
                    size--;
                }
                pathLen++;
            }

            return -1;
        }

}
