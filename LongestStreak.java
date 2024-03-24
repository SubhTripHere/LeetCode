package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStreak {
    public static void main(String[] args) {
        System.out.println(longestSquareStreak(new int[]{2,3,5,6,7}));
    }
    static public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=nums.length-1; i>=0; i--)
            map.put(nums[i], map.getOrDefault(nums[i]*nums[i], 0) +1);
        int max = 0;
        for(int val : map.values())
            max = Math.max(max, val);
        return max == 1 ? -1 : max;
    }
}
