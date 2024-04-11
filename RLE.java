package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RLE {
    public static void main(String[] args) {
        RLEIterator rleIterator=new RLEIterator(new int[]{3,8,0,9,2,5});
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));
    }

    static class RLEIterator{
        List<Integer> list;
        public RLEIterator(int[] encoding) {
            list=new ArrayList<>();
            for(int i=0;i<encoding.length;i+=2){
                int c=encoding[i];
                int num=encoding[i+1];
                for(int j=0;j<c;j++)
                    list.add(num);
            }
        }

        public int next(int n) {
            if(list.size()==0)
                return -1;
            int temp=-1;
            while(n>0 && list.size()>0){
                if(temp==-1)
                    temp=list.get(0);
                n--;
                list.remove(list.get(0));
            }
            if(n>0)
                return -1;
            return temp;

        }
    }

}
