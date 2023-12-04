package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class FrogJump {
    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
       static int last;
        static Set<Integer> set=new HashSet<>();
        public static boolean canCross(int[] stones) {
            last=stones[stones.length-1];
            for(int num:stones)
                set.add(num);
            return helper(0,1);
        }
        private static boolean helper(int pos, int jumpLength){
            if(pos==last){
                return true;
            }
            if(pos<0)
                return false;

            if(!set.contains(pos))
                return false;

            // if(set.contains(pos+jumpLength) || set.contains(pos+jumpLength+1) || set.contains(pos+jumpLength-1))
            return helper(pos+jumpLength,jumpLength) || helper(pos+jumpLength+1,jumpLength+1) || helper(pos+jumpLength-1,jumpLength-1);

             //return false;
        }

}
