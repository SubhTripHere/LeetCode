package LeetCode;

public class CountLIS {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }
        static public int findNumberOfLIS(int[] nums) {
            int[] dp=new int[nums.length];
            int[] count=new int[nums.length+1];
            dp[0]=1;
            int omax=1;
            for(int i=1;i<nums.length;i++ ){
                int maxLen=0;
                int last=nums[i];
                for(int j=0;j<i;j++){
                    int pre=nums[j];
                    if(pre<last){
                        maxLen=Math.max(maxLen,dp[j]);
                    }
                }
                dp[i]=maxLen+1;
                count[maxLen]++;
                omax=Math.max(omax,dp[i]);
            }

            return count[omax];
        }

}
