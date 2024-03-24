package LeetCode;

import java.util.Arrays;

public class FindTwoNonOverlappingSubarrays {


    public static void main(String[] args) {
        System.out.println(minSumOfLengths(new int[]{3,2,2,4,3},3));
    }
        public static int minSumOfLengths(int[] arr, int target) {
            int[] preBest=new int[arr.length];
            int[] suffBest=new int[arr.length];
            Arrays.fill(preBest,100000);
            Arrays.fill(suffBest,100000);

            int n=arr.length;
            int sum=0;
            int st=0;
            int end=0;
            while(end<n){
                sum+=arr[end];
                while(st<=end && sum>target){
                    sum-=arr[st++];
                }
                if(sum==target){
                    if(st==0)
                        preBest[st]=1;
                    else
                        preBest[end]=Math.min(preBest[end-1],end-st+1);
                }

                end++;
            }

            sum=0;
            end=arr.length-1;
            st=arr.length-1;
            while(end>=0){
                sum+=arr[end];
                while(st>=end && sum>target){
                    sum-=arr[st--];
                }
                if(sum==target){
                    suffBest[end]=Math.min(suffBest[end+1],st-end+1);
                }
                end--;
            }
            int ans=1000000;
            for(int i=0;i<n;i++){
                ans=Math.min(preBest[i]+suffBest[i],ans);
            }
            return ans;


        }

}
