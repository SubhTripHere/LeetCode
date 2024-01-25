package LeetCode;

public class LongestSubarrayWithAbsDiffLessK {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8,2,4,7},4));
    }
        public static int longestSubarray(int[] nums, int limit) {
            // create wMax=nums[0]+limit and wMin=nums[0]-limit
            //iterate one by one through the entire array
            //for each num, we check if this is in the range of wMax and wMin
            //  if in range we update wMax=Math.min(Math.abs(num+limit),wMax) and
            // wMin=Math.max(wMin,Math.abs(num-limit));
            // if curr num is not in range we rest the wMin and wMax and set start to end
            int max=1;
            int wMax=nums[0]+limit;
            int wMin=nums[0]-limit;
            int start=0;
            for(int i=1;i<nums.length;i++){
                int num=nums[i];
                if(Math.abs(num)>=wMin && Math.abs(num)<=wMax ){
                    wMin=Math.max(wMin,num-limit);
                    wMax=Math.min(wMax,num+limit);
                }else{
                    int tMin=num-limit;
                    int tMax=num+limit;
                    while(start<i && !(nums[start]>=tMin && nums[start]<=tMax)){
                        start++;
                    }
                    wMin=tMin;
                    wMax=tMax;
                }
                max=Math.max(max,i-start+1);
            }
            return max;

        }

}
