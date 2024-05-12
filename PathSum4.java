package LeetCode;

import java.util.*;

public class PathSum4 {
    public static void main(String[] args) {
        System.out.println(pathSum(new int[]{113,215,221}));
    }
    public static int pathSum(int[] nums) {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        List<Integer> prev=new LinkedList<>();
        for(int level=1;level<=4;level++){
            prev=new LinkedList<>(q);
            q.clear();
            for(int n:nums){
                if(n/100==level){
                    for(int el:prev)
                        q.add(el+(n%10));
                }
            }
            System.out.println(prev.size());
            System.out.println(q.size());
        }
        int ans=0;
        while (!prev.isEmpty() ){
            ans += prev.get(prev.remove(prev.size()-1));
        }
        while (!q.isEmpty() ){
            ans += q.poll();
        }
        return ans;
    }
}
