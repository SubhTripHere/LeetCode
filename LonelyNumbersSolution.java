package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyNumbersSolution {
    public static void main(String[] args) {
        System.out.println(findLonely(new int[]{1,3,5,3}));
    }
        public static List<Integer> findLonely(int[] nums) {
            Map<Integer,Integer> map=new HashMap<>();
            for(int i:nums)
                map.put(i,map.getOrDefault(i,0)+1);
            List<Integer> ans=new ArrayList<>();
            for(int i:nums){
                if(map.containsKey(i-1) || map.containsKey(i+1) || (map.containsKey(i) && map.get(i)>1))
                {
                    continue;
                }
                ans.add(i);
            }
            return ans;
        }

}
