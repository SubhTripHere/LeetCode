package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Scanner sc=new Scanner(System.in);
        BufferedReader sc = new BufferedReader(
                new InputStreamReader(System.in));

        List<Integer> ans=new ArrayList<>();
        int tests=sc.read();
        while(tests-->0){
            int n=sc.read(); //voters
            String s=sc.readLine();
            String t=sc.readLine();
            String[] sarr=s.split(" ");
            String[] tarr=t.split(" ");
            //int[] arr=new int[tarr.length];
            Set<Integer> set=new HashSet();

            for(int i=0;i<tarr.length;i++){
                set.add(Integer.valueOf(tarr[i]));
            }
            for(int i=0;i<sarr.length;i++){
                if(set.add(Integer.valueOf(sarr[i])))
                    ans.add(Integer.valueOf(sarr[i]));
            }

        }

        for(int i=0;i<ans.size();i++)
            System.out.println(ans.get(i));
    }
}
