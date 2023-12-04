package LeetCode;

import java.util.Arrays;

public class VideoStiching {
    public static void main(String[] args) {
        System.out.println(videoStitching(new int[][]{ {0,2},{4,6},{8,10},{1,9},{1,5},{5,9} },10));
    }

        public static int videoStitching(int[][] clips, int time) {
            int[] maxReach = new int[time + 1];
            for (int[] c : clips) {
                int start = c[0];
                if (start > time) continue;
                int end = Math.min(c[1], time);
                maxReach[start] = Math.max(maxReach[start], end);
            }
            int count = 0;
            int curEnd = 0;
            int nextEnd = 0;
            for (int i = 0; i <= time; i++) {
                if (curEnd < i) {
                    if (nextEnd < i) return -1;
                    count++;
                    curEnd = nextEnd;
                }
                nextEnd = Math.max(nextEnd, maxReach[i]);
            }
            return count;
        }

}
