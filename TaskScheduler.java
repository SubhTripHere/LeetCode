package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},3));
    }
        static class Node{
            int val;
            int occ;
            int time;
            Node(int val,int occ,int time){
                this.val=val;
                this.occ=occ;
                this.time=time;
            }
        }
       static public int leastInterval(char[] tasks, int n) {
            Queue<Node> pq=new PriorityQueue<>((a, b)->{
                if(a.occ!=b.occ)
                    return b.occ-a.occ;
                else
                    return a.time-b.time;
            });
            int[] freq=new int[26];
            for(int i=0;i<tasks.length;i++)
                freq[tasks[i]-'A']++;
            for(int i=0;i<26;i++){
                if(freq[i]>0)
                    pq.add(new Node(i,freq[i],0));
            }
            int ans=0;
            int last=-1;
            int t=0;
            while(!pq.isEmpty()){
                Node node=pq.poll();

                if((last==-1 || last!=node.val)){
                    if(node.time>t)
                        t=node.time;
                    pq.add(new Node(node.val,node.occ-1,t+n));
                    last=node.val;
                }else{
                    t=node.time;
                   // last=node.val;
                    pq.add(new Node(node.val,node.occ-1,t+n));
                }
                t++;
            }

            return t;
        }

}
