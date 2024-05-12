package LeetCode;

import java.util.*;

public class Tests {
    public static void main(String[] args) {

        System.out.println(compareVersion("0.1","1.1"));
    }

    public static int compareVersion(String v1, String v2) {
        String[] arr1=v1.split("\\.");
        String[] arr2=v2.split("\\.");
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length) {
            int t1=Integer.parseInt(arr1[i++]);
            int t2=Integer.parseInt(arr2[j++]);
            if(t1==t2)
                continue;
            return t1>t2?1:-1;
        }
        if(i==arr1.length && j==arr2.length)
            return 0;
        while(i<arr1.length || j<arr2.length){
            if(i<arr1.length){
                if(Integer.parseInt(arr1[i++])>0)
                    return -1;
            }else{
                if(j<arr2.length){
                    if(Integer.parseInt(arr2[j++])>0)
                        return 1;
                }
            }
        }

        return 0;
    }

}
