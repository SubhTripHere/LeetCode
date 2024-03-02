package LeetCode;

import java.util.Arrays;

public class SegmentTreeSolution {
    public static void main(String[] args) {
    SegmentTree segmentTree=new SegmentTree(6);
    segmentTree.build(new int[]{1,4,18,3,5,7},0,5,0);
        System.out.println(segmentTree.query(0,0,5,2,4));
    segmentTree.update(0,0,5,3,10);
        System.out.println(segmentTree.query(0,0,5,2,4));
    }

    static class SegmentTree{
        static int[] seg;

        SegmentTree(int n){
            seg=new int[4*n+1];
            Arrays.fill(seg,Integer.MAX_VALUE-1);
        }
        public  void build(int[] arr,int as,int ae,int si){
            if (as == ae) {
                seg[si] = arr[as];
                return;
            }

            // If there are more than one elements, then recur for left and
            // right subtrees and store the sum of values in this node
            int mid = (as+ae)/2;
            build(arr, as, mid, si * 2 + 1) ;
            build(arr, mid + 1, ae, si * 2 + 2);
            seg[si]=(seg[2*si+1]+seg[2*si+2]);
        }


        public  int query(int si,int ss,int se,int qs,int qe){
            //no overlap
            if (qs <= ss && qe >= se)
                return seg[si];

            // If segment of this node is outside the given range
            if (se < qs || ss > qe)
                return 0;

            // If a part of this segment overlaps with the given range
            int mid = (ss+ se)/2;
            return (query(2 * si + 1,ss, mid, qs, qe )+
                    query(2 * si + 2,mid + 1, se, qs, qe ));
        }

        public  void update(int si,int ss,int se,int i,int val){
            if(ss==se) {
                seg[si]=val;
                return;
            }
            int mid=(ss+se)/2;
            if(i<=mid)
                update(2*si+1,ss,mid,i,val);
            else
                update(2*si+2,mid+1,se,i,val);
            seg[si]=seg[2*si+1]+seg[2*si+2];
        }
    }
}
