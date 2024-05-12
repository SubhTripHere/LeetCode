package LeetCode;

import java.util.*;

public class MinCostAppleBuy {
    public static int n;
    public static void main(String[] args) {
        long[] x = minCost(4, new int[][]{{1, 2, 4}, {2, 3, 2}, {3, 4, 1}, {1, 3, 4}, {2, 4, 5}}, new int[]{56, 42, 102, 301}, 2);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }

       static public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
            Map<Integer, List<int[]>> g=new HashMap<>();
            for(int i=0;i<n;i++){
                g.put(i,new ArrayList());
            }
            for(int[] road:roads){
                int u=road[0]-1;
                int v=road[1]-1;
                int c=road[2];
                g.get(u).add(new int[]{v,c});
                g.get(v).add(new int[]{u,c});
            }

            long[] res=new long[n];

            for(int i=0;i<n;i++){
                res[i]=findMinCost(i,g,appleCost,k);
            }

            return res;
        }
       static private long findMinCost(int src,Map<Integer,List<int[]>> g,int[] nums,int k){
            int[] cost=new int[nums.length];
            Arrays.fill(cost,Integer.MAX_VALUE-1);
            cost[src]=0;
            Queue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{src,0});
            long ans=Integer.MAX_VALUE-1;
            while(!pq.isEmpty()){
                int[] node=pq.poll();
                int s=node[0];
                int c=node[1];
                ans=Math.min(ans,(c*k)+nums[s]);
                for(int[] ne:g.get(src)){
                    int nei=ne[0];
                    int nCost=ne[1];
                    if(nCost+c<=cost[nei]){
                        cost[nei]=(nCost+c);
                        pq.add(new int[]{nei,nCost+c});
                    }
                }
            }

            return ans;
        }

}
