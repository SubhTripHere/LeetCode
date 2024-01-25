package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
    }
        static int rows;
        static int cols;
        static public int shortestBridge(int[][] grid) {
            int dist=0;
            rows=grid.length;
            cols=grid[0].length;
            int flag=1;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j]==1 && flag==1){
                        flag=2;
                        dfs(grid,i,j);
                    }
                    else if(grid[i][j]==1){
                        dist=bfs(grid,i,j);
                    }
                }
            }
            return dist;
        }
       static private void dfs(int[][] grid,int r,int c){
            if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]!=1)
                return;
            grid[r][c]=2;
            dfs(grid,r+1,c);
            dfs(grid,r-1,c);
            dfs(grid,r,c+1);
            dfs(grid,r,c-1);
        }
       static private int bfs(int[][] grid,int r,int c){
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{r,c});
            int dist=0;
            int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
            while(!q.isEmpty()){
                int size=q.size();
                dist++;
                for(int i=0;i<size;i++) {
                    int[] pos = q.poll();
                    for (int[] dir : directions) {
                        int nr = dir[0] + pos[0];
                        int nc = dir[1] + pos[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0) {
                            grid[pos[0]][pos[1]] = -1;
                            q.add(new int[]{nr, nc});
                        } else if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 2)
                            return dist-1;
                    }

                 }
                }

           return dist==0?-1:dist-1;
            }
}
