package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CourseSchedule4 {
    public  static  Stack<Integer> st=new Stack<>();
    public static void main(String[] args) {
        int[][] arr=new int[][]{{2,3},{2,1},{0,3},{0,1}};
        int[][] queries=new int[][]{{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}};
        List<Boolean> ans=checkIfPrerequisite(4,arr,queries);
        for (Boolean a:ans){
            System.out.println(a);
        }
    }
        public static List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
            Boolean vis[]=new Boolean[n];
            List<Boolean> ans=new ArrayList<>();
            List<List<Integer>> adj=new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int[] p:pre){
                adj.get(p[1]).add(p[0]);
            }



            for(int i=0;i<n;i++){
                if(vis[i]==null){
                    dfs(adj,i,vis,st);
                }
            }
            List<Integer> res=new ArrayList<>();
            while(!st.isEmpty()){
                res.add(st.pop());
            }
            Collections.reverse(res);

            for(int[] query:queries){
                if(isPrereq(query[0],query[1],res))
                    ans.add(true);
                else
                    ans.add(false);
            }
            return ans;

        }
        private static void dfs(List<List<Integer>> adj,int src,Boolean[] vis,Stack<Integer> st){
            if(vis[src]!=null && vis[src])
                return;
            vis[src]=true;
            for(int i=0;i<adj.get(src).size();i++){
                if(vis[adj.get(src).get(i)]!=null && vis[adj.get(src).get(i)])
                    continue;
                dfs(adj,adj.get(src).get(i),vis,st);
            }
            st.push(src);

            return;
        }
        private static boolean isPrereq(int a,int b,List<Integer> li){
            int p1=0;
            int p2=0;
            for(int i=0;i<li.size();i++){
                if(li.get(i)==a)
                    p1=i;
                else if(li.get(i)==b)
                    p2=i;
            }
            return p1<p2;
        }
}

