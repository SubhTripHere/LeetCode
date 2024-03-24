package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MiceaAndCheese {
    public static void main(String[] args) {
        System.out.println(miceAndCheese(new int[]{},new int[]{},2));
    }

       static public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            Queue<int[]> pq=new PriorityQueue<>((a, b)->b[0]-a[0]);
            int n=reward1.length;

            for(int i=0;i<n;i++){
                pq.add(new int[]{reward1[i]-reward2[i],i});
            }

            int ans=0;

            for(int i=0;i<k;i++){
                ans+=reward1[pq.poll()[1]];
            }

            int tar=n-(2*k);

            for(int i=0;i<tar;i++)
                pq.poll();

            for(int i=0;i<k;i++){
                ans+=reward2[pq.poll()[1]];
            }

            return ans;

        }

}
