package LeetCode;

public class SumPrefixScoreStrings {
    public static void main(String[] args) {
        int[] ans=sumPrefixScores(new String[]{"abc","ab","bc","b"});
        for (int n : ans)
            System.out.print(n+" ");
    }
        static class TrieNode{
            char c;
            int occ;
            boolean isEnd;
            TrieNode[] children;
            TrieNode(char c,int occ,boolean isEnd){
                this.c=c;
                this.occ=occ;
                this.isEnd=isEnd;
                this.children=new TrieNode[26];
            }
        }
       static TrieNode root=new TrieNode('#',0,false);
      static  public int[] sumPrefixScores(String[] words) {
            for(String word:words){
                TrieNode curr=root;
                for(int i=0;i<word.length();i++){
                    char ch=word.charAt(i);
                    if(curr.children[ch-'a']!=null){
                        curr=curr.children[ch-'a'];
                        curr.occ=curr.occ+1;

                    }else{
                        TrieNode node=new TrieNode(ch,1,false);
                        curr.children[ch-'a']=node; /// adding the node to the children of root;
                        curr=curr.children[ch-'a'];
                    }
                }
                curr.isEnd=true;
            }

            return countScore(words);
        }
       static private int[] countScore(String[] words){
            int n=words.length;
            int[] ans=new int[words.length];

            for(int i=0;i<words.length;i++){
                TrieNode curr=root;
                String word=words[i];
                int score=0;
                for(int j=0;j<word.length();j++){
                    char ch=word.charAt(j);
                    if(curr.children[ch-'a']!=null){
                        curr=curr.children[ch-'a'];
                        score+=curr.occ;
                    }
                }
                ans[i]=score;
            }
            return ans;
        }
}



/*
b-> c
1   1
1
a-> b-> c   d   e   f
1   1   1
1   1

    */
