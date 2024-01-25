package LeetCode;

public class ContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{65,66,67,66,66,65,64,65,65,64}));
    }
    public static long continuousSubarrays(int[] nums) {
        int wMin=nums[0]-2;
        int wMax=nums[0]+2;
        //Queue<Integer> q=new Deque<>();
        //q.add(nums[0]);
        int total=1;
        int start=0;
        int end=1;
        int count=1;
        int minsf=nums[0];
        int maxsf=nums[0];

        while(end<nums.length){
            int n=nums[end];
            if(n<=wMax && n>=wMin){
                minsf=Math.min(minsf,n);
                maxsf=Math.max(maxsf,n);
                wMax=Math.min(maxsf+2,wMax);
                wMin=Math.max(minsf,wMin);
            }else{
                int tL=n;
                int tU=n+2;
                while(start<=end && (nums[start]<tL || nums[start]>tU)){
                    start++;
                }
                minsf=Math.min(minsf,n);
                maxsf=Math.max(maxsf,n);
                wMax=maxsf+2;
                wMin=minsf;
            }
            total+=end-start+1;
            end++;
        }
        return total;
    }
}
