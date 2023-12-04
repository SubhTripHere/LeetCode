package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FindSwapCountSolution {
    // Function to calculate the minimum number of swaps
    static int minSwaps(String s1, String s2) {
        int n = s1.length();
        int swaps = 0;

        Map<Character, Integer> positionMap = new HashMap<>();

        // Populate the positionMap with the positions of characters in s1
        for (int i = 0; i < n; i++) {
            positionMap.put(s1.charAt(i), i);
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // Swap characters at positions i and the correct position in s1
                int correctPosition = positionMap.get(s1.charAt(i));

                // Update the positionMap
                positionMap.put(s1.charAt(i), i);
                positionMap.put(s1.charAt(correctPosition), correctPosition);

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        String s1 = "1234890756";
        String s2 = "1234876590";

        // Calculate the minimum number of swaps
        int minSwaps = minSwaps(s1, s2);

        System.out.println("Minimum number of swaps needed: " + minSwaps);
    }
}
