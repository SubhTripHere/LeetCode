package LeetCode;

import java.util.*;

public class DiceUniqueCombinationSolution {
//    public static void main(String[] args) {
//        Set<List<Integer>>  set=findUniqueCounts(3);
//        for (List<Integer> al: set){
//            System.out.print(al);
//        }
//        System.out.println(set.size());
//    }
//    public static Set<List<Integer>> findUniqueCounts(int dices){
//        Set<List<Integer>> set=new HashSet<>();
//        helper(dices,set, new ArrayList<Integer>());
//        return set;
//    }
//    public static void helper(int dices,Set<List<Integer>> set,List<Integer> curr){
//        if(dices==0){
//            set.add(new ArrayList<>(curr));
//            return;
//        }
//        for(int i=1;i<=6;i++){
//            curr.add(i);
//            helper(dices-1,set,curr);
//            curr.remove(curr.size()-1);
//        }
//    }
static void printCombinations(int M) {
    int[] result = new int[M];
    generateCombinations(M, result, 0, 1);
}

    // Helper function to generate combinations recursively
    static void generateCombinations(int M, int[] result, int index, int start) {
        // Base case: if all dice rolls are done, print the combination
        if (index == M) {
            System.out.println(Arrays.toString(result));
            return;
        }

        // Roll each face of the dice, ensuring that the value is greater than or equal to the previous values
        for (int face = start; face <= 6; face++) {
            result[index] = face;
            generateCombinations(M, result, index + 1, face);
        }
    }

    public static void main(String[] args) {
        // Specify the number of dice rolls (M)
        int M = 2; // Change this value as needed

        // Print all distinct combinations of 'M' dice rolls
        printCombinations(M);
    }
}
