package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class PhoneTypes {
    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
       static class Node{
            int val;
            int occ;
            Node(int val,int occ){
                this.val=val;
                this.occ=occ;
            }
        }
       static public int minimumPushes(String word) {
            Queue<Node> pq=new PriorityQueue<>((a, b)->b.occ-a.occ);
            int[] freq=new int[26];
            for(char c:word.toCharArray()){
                freq[c-'a']++;
            }
            for(int i=0;i<26;i++){
                if(freq[i]==0)
                    continue;
                Node n=new Node(i,freq[i]);
                pq.add(n);
            }
            int sum=0;
            int incr=1;
            while(!pq.isEmpty()){
                int size=pq.size();
                if(size>=8){
                    //if(we have more than 8 elements in the pq we will pop all top 8 freq elemnts )
                    for(int i=0;i<8;i++){
                        Node n=pq.poll();
                        sum+=incr*(n.occ);
                    }
                    incr++;
                }else{
                    for(int i=0;i<size;i++){
                        Node n=pq.poll();
                        sum+=incr*(n.occ);
                    }
                }
            }
            return sum;
        }
}
