package LeetCode;

import java.util.*;

public class ConnectingCities {
    public static void main(String[] args) {
        System.out.println(minimumCost(3,new int[][]{{1,2,5},{1,3,6},{2,3,1}}));
    }
    static public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] connection:connections){
            int u=connection[0]-1;
            int v=connection[1]-1;
            int cost=connection[2];
            map.get(u).add(new int[]{v,cost});
            map.get(v).add(new int[]{u,cost});

        }

        int total=0;
        int[] mst=new int[n];

        Queue<int[]> q=new PriorityQueue<>((a, b)->a[1]-b[1]);
        q.add(new int[]{0,0}); //src,cost

        while(!q.isEmpty()){
            int[] node=q.poll();
            if(mst[node[0]]!=0)
                continue;

            total+=node[1];
            mst[node[0]]=1;

            if(node[2]!=-1)
                mst[node[2]]=1;

            for(int[] nei:map.get(node[0])){
                if(mst[nei[0]]!=0)
                    continue;
                q.add(new int[]{nei[0],node[1]+nei[1]});
            }
        }

        return total;

    }
}
