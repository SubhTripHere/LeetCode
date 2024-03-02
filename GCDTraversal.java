package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCDTraversal {

    public static void main(String[] args) {
        System.out.println(canTraverseAllPairs(new int[]{2,3,6}));
    }

        public static boolean canTraverseAllPairs(int[] nums) {
            int n=nums.length;
            Map<Integer,Integer> map=new HashMap<>();
            Map<Integer,List<Integer>> graph=new HashMap<>();

            for(int i=0;i<nums.length;i++){
                List<Integer> pf=findPrimeFactors(nums[i]);
                for(int f:pf){
                    if(map.containsKey(f)){
                        addEdge(graph,map.get(f),i);
                    }else{
                        map.put(f,i);
                    }
                }
            }
            boolean[] vis=new boolean[n];

            dfs(0,vis,graph);
            for(boolean v:vis){
                if(!v)
                    return false;
            }

            return true;
        }

        private static void addEdge(Map<Integer,List<Integer>> graph,int a,int b){
            if(graph.containsKey(a)){
                graph.get(a).add(b);
            }else{
                graph.put(a,new ArrayList<>());
                graph.get(a).add(b);
            }

            if(graph.containsKey(b)){
                graph.get(b).add(a);
            }else{
                graph.put(b,new ArrayList<>());
                graph.get(b).add(a);
            }
        }

        private static void dfs(int node, boolean[] vis, Map<Integer,List<Integer>> graph){
            vis[node]=true;
            if(graph.get(node)==null)
                return ;
            for(int nei:graph.get(node)){
                if(!vis[nei]){
                    dfs(nei,vis,graph);
                }
            }
            return;
        }

        private static List<Integer> findPrimeFactors(int x){
            List<Integer> primeFactors = new ArrayList<>();
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    primeFactors.add(i);
                    while (x % i == 0) {
                        x /= i;
                    }
                }
            }
            if (x != 1) {
                primeFactors.add(x);
            }
            return primeFactors;
        }
}
