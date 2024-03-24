package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordDeletion {

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea",new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"))));
    }

        public static String findLongestWord(String s, List<String> dictionary) {
            String ans="}";
            int maxLen=0;
            Collections.sort(dictionary);
            for(String str:dictionary){
                if(isMatch(s,str,s.length()-1,str.length()-1)){
                    if(str.length()>=maxLen){
                        maxLen=str.length();
                        if(ans.length()==str.length() && str.compareTo(ans)<0)
                            ans=str;
                    }
                }
            }
            return ans;
        }
        private static boolean isMatch(String s1,String s2,int i,int j){
            while(i>=0)
            {
                while(i>=0 && j>=0 && s1.charAt(i)!=s2.charAt(j)){
                    i--;
                }
                i--;
                j--;
            }
            return j<=0;
        }

}
