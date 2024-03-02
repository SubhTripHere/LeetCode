package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountMaxLenSubset {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{5,4,1,2,2}));
    }
      static   public int maximumLength(int[] nums) {
            Arrays.sort(nums);
            Map<Integer,Integer> map=new HashMap<>();
            for(int n:nums){
                map.put(n,map.getOrDefault(n,0)+1);
            }
            int last=0;
            int max=0;
            int pair=0;
            for(int i=0;i<nums.length;i++){
                if(last==nums[i])
                    continue;
                else{
                    if(nums[i]==last*last && map.get(nums[i])>1){
                        pair+=2;
                        last=nums[i];
                    }else{
                        if(map.get(nums[i])>1) {
                            last = nums[i];
                           // pair = ;
                        }
                    }
                }
                max=Math.max(pair,max);
            }

            return max;

        }
        private int findMaxLen(Map<Integer,Integer> map,int n){
            int len=0;
            while(true){
                Integer count=map.get(n);
                if(count==null)
                    return 1;
                else if(count==1)
                    return len+1;
                else if(count>1)
                    len+=2;
                n=n*n;
            }
        }

}
