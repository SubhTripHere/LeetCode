package LeetCode;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));

    }

        static class Node{
            String curr;
            int dist;
            Node(String curr,int dist){
                this.curr=curr;
                this.dist=dist;
            }
        }
        static public int ladderLength(String begin, String end, List<String> wordList) {
            if(begin.length()!=end.length())
                return 0;
            int shortest=0;
            Set<String> seen=new HashSet<>();
            for(String s:wordList)
                seen.add(s);
            Queue<Node> q=new LinkedList<>();
            q.add(new Node(begin,0));
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    Node node=q.poll();
                    String str=node.curr;
                    int len=node.dist;
                    if(str==end){
                        return shortest;
                    }
                    for(int j=0;j<str.length();j++){
                        String p1=str.substring(0,j);
                        String p2=str.substring(j+1);
                        for(char c='a'; c<='z';c++){
                            String combined=p1+""+c+""+p2;
                            if(seen.contains(combined)){
                                q.add(new Node(combined,len+1));
                                seen.remove(combined);
                            }
                        }
                    }
                }
                shortest++;
            }

            return 0;
        }
}
