package LeetCode;

import java.util.*;

public class GraphConnectivityWithThreshold {

    public static void main(String[] args) {
        List<Boolean> ans=areConnected(5,1,new int[][]{{4,5},{4,5},{3,2},{2,3},{3,4}});
        for (int i = 0; i <ans.size() ; i++) {
            System.out.print(ans.get(i));
        }
    }
        public static List<Boolean> areConnected(int n, int threshold, int[][] queries) {
            Map<Integer, Set<Integer>> num2Divisors=new HashMap<>();
            for(int i=1;i<=n;i++){
                helper(i,num2Divisors,threshold);
            }
            List<Boolean> ans=new ArrayList<>();
            int ind=0;
            for(int[] query:queries){
                int min=Math.min(query[0],query[1]);

                for(int i=threshold+1;i<=min;i++){
                    Set<Integer> set=num2Divisors.get(i);
                    if(set==null)
                        continue;
                    if(set.contains(query[0]) && set.contains(query[1]))
                        ans.add(true);
                }
                ans.add(false);
            }

            return ans;
        }
        private static void helper(int n,Map<Integer,Set<Integer>> map,int k){
            Set<Integer> temp=new HashSet<>();
            for(int i=k+1;i<=n;i++){
                if(n%i==0){
                    if(!map.containsKey(i))
                        map.put(i,new HashSet<Integer>());
                    map.get(i).add(n);
                }
            }

            return;
        }

}
