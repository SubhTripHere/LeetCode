package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumHapiness {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{7,50,3},3));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        Queue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int n:happiness)
            pq.add(n);
        long score=0;
        int tar=pq.peek();
        int times=0;
        while(!pq.isEmpty() && k>0 && tar>0){
            score+=tar;
            pq.poll();
            times++;
            if(pq.size()>0)
                tar=pq.peek()-(times);
            k--;
        }


        return score;

    }
}
