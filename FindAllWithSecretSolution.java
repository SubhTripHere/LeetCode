package LeetCode;

import java.util.*;

/*
You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.

Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.

The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.

Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.



Example 1:

Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
Output: [0,1,2,3,5]
Explanation:
At time 0, person 0 shares the secret with person 1.
At time 5, person 1 shares the secret with person 2.
At time 8, person 2 shares the secret with person 3.
At time 10, person 1 shares the secret with person 5.​​​​
Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
Example 2:

Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
Output: [0,1,3]
Explanation:
At time 0, person 0 shares the secret with person 3.
At time 2, neither person 1 nor person 2 know the secret.
At time 3, person 3 shares the secret with person 0 and person 1.
Thus, people 0, 1, and 3 know the secret after all the meetings.
Example 3:

Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
Output: [0,1,2,3,4]
Explanation:
At time 0, person 0 shares the secret with person 1.
At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
Note that person 2 can share the secret at the same time as receiving it.
At time 2, person 3 shares the secret with person 4.
Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.


Constraints:

2 <= n <= 105
1 <= meetings.length <= 105
meetings[i].length == 3
0 <= xi, yi <= n - 1
xi != yi
1 <= timei <= 105
1 <= firstPerson <= n - 1

 */
public class FindAllWithSecretSolution {
    /*
    steps :-
    1. we need to see which all people with whom we can share the secret given the time we are on
    2. we also need to know the meetings which can take place in the time frame for that
    3. if we create a PR to store the meetings  and each time we are passed the time we can pull out the elements
    4. and as these are sorted in the time way so now we can know how many people and time for them to know the secret
    5.
     */
    public static void main(String[] args) {
        int n=5;
        int[][] meetings={{3,4,2},{1,2,1},{2,3,1}};
        int fitstPerson =1;

        System.out.println(findOrder(n,meetings,fitstPerson));

    }
    private static List<Integer> findOrder(int n,int[][] meetings,int firstPerson){
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //build the graph adj
        for(int i=0;i<meetings.length;i++){
            int[] meeting=meetings[i];
            int x1=meeting[0];
            int y1=meeting[1];
            int cost=meeting[2];
            adj.get(x1).add(new int[]{y1,cost});
        }

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {firstPerson,1});
        Set<Integer> ans=new HashSet<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] node=q.poll();
                int time=node[1];
                int point=node[0];
                for(int j=0;j<adj.get(point).size();j++){
                    int[] nei=adj.get(point).get(j);
                    if(nei[1]<=time){
                        q.add(new int[]{});
                        ans.add(nei[0]);
                    }
                }
            }
        }

        return ans.stream().toList();
    }
}
//
//class Solution {
//    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        // For every person, we store the meeting time and label of the person met.
//        Map<Integer, List<int[]>> graph = new HashMap<>();
//        for (int[] meeting : meetings) {
//            int x = meeting[0], y = meeting[1], t = meeting[2];
//            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
//            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
//        }
//
//        // Earliest time at which a person learned the secret
//        // as per current state of knowledge. If due to some new information,
//        // the earliest time of knowing the secret changes, we will update it
//        // and again process all the people whom he/she meets after the time
//        // at which he/she learned the secret.
//        int[] earliest = new int[n];
//        Arrays.fill(earliest, Integer.MAX_VALUE);
//        earliest[0] = 0;
//        earliest[firstPerson] = 0;
//
//        // Queue for BFS. It will store (person, time of knowing the secret)
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{0, 0});
//        q.offer(new int[]{firstPerson, 0});
//
//        // Do BFS
//        while (!q.isEmpty()) {
//            int[] personTime = q.poll();
//            int person = personTime[0], time = personTime[1];
//            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
//                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
//                if (t >= time && earliest[nextPerson] > t) {
//                    earliest[nextPerson] = t;
//                    q.offer(new int[]{nextPerson, t});
//                }
//            }
//        }
//
//        // Since we visited only those people who know the secret,
//        // we need to return indices of all visited people.
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < n; ++i) {
//            if (earliest[i] != Integer.MAX_VALUE) {
//                ans.add(i);
//            }
//        }
//        return ans;
//    }
//}
