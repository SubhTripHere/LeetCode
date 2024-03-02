package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
        public static int totalFruit(int[] fruits) {
            Map<Integer,Integer> map=new HashMap<>();
            int end=0;
            int n=fruits.length;
            int start=0;
            int picks=0;
            while(end<n){
                map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
                while(start<=end && map.size()>2){
                    if(map.get(fruits[start])==1)
                        map.remove(fruits[start]);
                    else
                        map.put(fruits[start],map.get(fruits[start])-1);
                    start++;
                }
                picks=Math.max(picks,end-start+1);
                end++;
            }
            return picks;
        }

}
