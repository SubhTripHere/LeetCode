package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MinLenAnagramConcate {
    public static void main(String[] args) {
        System.out.println(minAnagramLength("aabbabab"));
    }
    public static int minAnagramLength(String s) {
        int n=s.length();
        Set<Integer> factors=new HashSet<>();
        for(int i=1;i<=n/2;i++){
            int k=n/i;
            if(n%i==0){
                factors.add(n/i);
                factors.add(i);
            }
        }
        List<Integer> fact=factors.stream().sorted().collect(Collectors.toList());
        for(int i=1;i<fact.size();i++){
            int len=i;
            int[] ar=new int[26];
            for(int k=0;k<len;k++){
                ar[s.charAt(k)-'a']++;
            }
            int count=0;
            for(int j=0;j<=n-len;j+=len){
                String tmp=s.substring(j,j+len);
                int freq[]=new int[26];
                for(int k=0;k<tmp.length();k++){
                    freq[tmp.charAt(k)-'a']++;
                }
                if(!equal(freq,ar))
                    break;
                else
                    count++;
            }
            if(count==n/len)
                return len;
        }
        return -1;
    }
    private static boolean equal(int[] ar1,int[] ar2){
        if(ar1.length!=ar2.length)
            return false;
        for(int i=0;i<26;i++){
            if(ar1[i]!=ar2[i])
                return false;
        }
        return true;
    }
}
