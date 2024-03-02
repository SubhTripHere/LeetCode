package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class SolutionLongestParan {

    /*


    Given a string consisting of characters ‘(‘ and ‘),’ find the longest valid i.e. well-formed parentheses subsequence.
For example:
INPUT : s= “(()”
OUTPUT:  ()
The longest valid substring will be “()” from index 1 to 2.
INPUT : s= “)()(()()” open:
                    st: 1
OUTPUT:  ()()
     */
    public static void main(String[] args) {
        String s=")(()())";
        TreeSet<Integer> set=new TreeSet<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                if(ch=='(')
                    st.push(i);
                else continue;
            }else{
                if(ch=='('){
                    st.push(i);
                }else{
                    set.add(st.pop());
                    set.add(i);
                }
            }
        }
        for(int i:set){
            System.out.print(s.charAt(i));
        }
    }

    /*
    List<int[]> pairs=2,3 4,5  1,6
    1 2 3
     */

}
