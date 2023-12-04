package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class UniquePaths3 {
        static class Node{
            int x;
            int y;
            int count;
            Node(int x, int y, int count){
                this.x=x;
                this.y=y;
                this.count=count;
            }
        }
        static public int uniquePathsIII(int[][] grid) {
            Map<Integer,Integer> map=new HashMap<>(); // for storing count of boxes covered and no of
            //paths doing such
            int zeros=0;
            int sr=-1;
            int sc=-1;
            int tr=-1;
            int tc=-1;

            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==0)
                        zeros++;
                    if(grid[i][j]==2){
                        tr=i;
                        tc=j;
                    }
                    if(grid[i][j]==1){
                        sr=i;
                        sc=j;
                    }
                }
            }
            Queue<Node> q=new LinkedList<>();

            int[][] directions=new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
            q.add(new Node(sr,sc,1));

            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    Node node=q.poll();
                    if(node.x==tr && node.y==tc)
                        map.put(node.count,map.getOrDefault(node.count,0)+1);

                    for(int[] dir:directions){
                        int newx=node.x+dir[0];
                        int newy=node.y+dir[1];
                        if(newx<0 || newx>=grid.length || newy<0 || newy>=grid[0].length || grid[newx][newy]==-1 )
                            continue;
                        q.add(new Node(newx,newy,node.count+1));
                    }
                }
            }

            return map.get(zeros+2)!=null?map.get(zeros+2):-1;
        }

    public static void main(String[] args) {
        System.out.println(UniquePaths3.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
