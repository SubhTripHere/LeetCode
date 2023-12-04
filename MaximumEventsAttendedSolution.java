package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumEventsAttendedSolution {
        public static int maxEvents(int[][] events) {
            Arrays.sort(events,(a, b)->a[0]-b[0]);
            PriorityQueue<int[]> pq=new PriorityQueue<>();
            int count=0;
            int[] event;
            for(int i=0;i<events.length;i++){
                 event=events[i];
                if(pq.isEmpty()){
                    pq.offer(event);
                    count++;
                    //count++;
                }else{
                    while(!pq.isEmpty() && event[0]>=pq.peek()[0])
                        pq.poll();
                    while(event[0]<=pq.peek()[0]){
                        count++;
                        pq.add(event);
                    }
                }
            }
            return count;

        }

    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][]{{1,2},{2,3},{3,4}}));
    }

}
