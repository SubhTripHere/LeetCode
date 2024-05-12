package LeetCode;

import java.util.*;

public class Example {
    public static void main(String[] args) {

        System.out.println(minimumAddedInteger(new int[]{10,2,8,7,5,6,7,10},new int[]{5,8,5,3,8,4}));
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        int n=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min=Integer.MAX_VALUE-1;
        int steps=nums1.length-n;
        for(int i=0;i<= steps;i++){
            int tmp[]=new int[n];
            for(int j=0;j<n;j++){
                tmp[j]=nums1[i+j];
            }
            int d=nums2[0]-tmp[0];
            boolean flag=false;
            for(int k=0;k<n;k++){
                if(nums2[k]-tmp[k]!=d){
                    flag=true;
                    break;
                }
            }
            if(!flag)
                min=Math.min(min,d);
        }
        return min;

    }
}
