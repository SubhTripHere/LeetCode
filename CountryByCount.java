package LeetCode;

import java.util.*;

public class CountryByCount {
    public static void main(String[] args) {
        int n=10;
        List<List<String>> adj=new ArrayList<>();

            List<String> list=new ArrayList<>();
            adj.add(new ArrayList<>(Arrays.asList("-1","1")));
        adj.add(new ArrayList<>(Arrays.asList("China","0")));
        adj.add(new ArrayList<>(Arrays.asList("-1","1")));
        adj.add(new ArrayList<>(Arrays.asList("China","3")));
        adj.add(new ArrayList<>(Arrays.asList("Bermuda","2")));
        adj.add(new ArrayList<>(Arrays.asList("Cuba","1")));
        adj.add(new ArrayList<>(Arrays.asList("-1","1")));

        List<List<String>> output=solve(adj);
        for (List<String> li:output)
            System.out.println(li);
    }
    private static List<List<String>> solve(List<List<String>> adj){
        List<List<String>> ans=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<adj.size();i++){
            String country=adj.get(i).get(0);
            if(country.startsWith("-1"))
                continue;
            if(map.containsKey(country))
                map.put(country,map.get(country)+1);
            else
                map.put(country,1);
        }

        PriorityQueue<List<String>> pq=new PriorityQueue<>((a,b)-> a.get(0).compareTo(b.get(0)));

        for(Map.Entry<String,Integer> m: map.entrySet()){
            pq.add(new ArrayList<>(Arrays.asList(m.getKey(),m.getValue().toString())));
        }

        while (!pq.isEmpty())
            ans.add(new ArrayList<>(pq.poll()));

        return ans;

    }
}
