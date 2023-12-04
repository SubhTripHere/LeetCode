package LeetCode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestPathSolution {
    static class Node{
        int x;
        int y;
        String psf;
        Node(int x,int y,String psf){
            this.x=x;
            this.y=y;
            this.psf=psf;
        }
    }
    public static String kthSmallestPath(int[] dest, int k) {
        Queue<Node> q=new LinkedList<>();
        int rows=dest[0];
        int cols=dest[1];
        boolean[][] vis=new boolean[rows+1][cols+1];

        Queue<String> results=new PriorityQueue<>((a, b)->(a).compareTo(b));
        q.add(new Node(0,0,""));
        // vis[0][0]=true;
        //int[][] directions=new int[][]{{1,0},{-1,0}};

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                int x=node.x;
                int y=node.y;
                String psf=node.psf;

                if(node.x==rows && node.y==cols)
                    results.add(node.psf);

//                if(vis[node.x][node.y]==true)
//                    continue;

               // vis[x][y]=true;

                int newx=x+1;
                int newy=y+1;

                if(newx<rows+1)
                q.add(new Node(newx,y,psf+"V"+""));
                if(newy<cols+1)
                q.add(new Node(x,newy,psf+"H"+""));

            }
        }
        String ans="";
        while(k-->0){
            ans=results.poll();
        }
        //ans+=results.peek();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(KthSmallestPathSolution.kthSmallestPath(new int[]{2,3},1));
    }
}