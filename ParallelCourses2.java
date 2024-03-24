package LeetCode;

import java.util.*;

public class ParallelCourses2 {

    public static void main(String[] args) {
        System.out.println(minNumberOfSemesters(4,new int[][]{{2,4},{2,1}},2));

    }
        public static int minNumberOfSemesters(int n, int[][] relations, int k) {
            Map<Integer, List<Integer>> graph=new HashMap<>();
            for(int i=0;i<n;i++)
                graph.put(i,new ArrayList<>());
            int[] ind=new int[n];
            Arrays.fill(ind,0);
            Set<Integer> seen=new HashSet<>();
            for(int[] relation:relations){
                int prev=relation[0]-1;
                int curr=relation[1]-1;
                graph.get(curr).add(prev);
                ind[prev]++;
                seen.add(prev);
                seen.add(curr);
            }

            Queue<Integer> q=new LinkedList<>();

            for(int i=0;i<n;i++){
                if(ind[i]==0 && seen.contains(i))
                    q.add(i);
            }
            int sem=0;
            while(!q.isEmpty()){
                int size=q.size();
                sem+=size/k;
                sem+=(size%k==0)?0:1;
                for(int i=0;i<size;i++){
                    int node=q.poll();
                    for(int nei:graph.get(node)){
                        ind[nei]--;
                        if(ind[nei]==0)
                            q.add(nei);
                    }
                }
            }

            return sem;

        }

}
