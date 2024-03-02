package LeetCode;

import java.util.*;

public class CompleteSubstrings {

    public static void main(String[] args) {
        System.out.println(countCompleteSubstrings("aaabbbccc",3));
    }

    public static int countCompleteSubstrings(String word, int k) {
        int count = 0;
        int uniqueChars = new HashSet<>(Arrays.asList(word.split(""))).size();

        for (int subLen = 1; subLen <= uniqueChars; ++subLen) {
            int windowSize = subLen * k;

            Map<Character, Integer> charFreq = new HashMap<>();
            int start = 0;
            int end = start + windowSize - 1;

            for (int i = start; i <= Math.min(end, word.length() - 1); ++i) {
                charFreq.put(word.charAt(i), charFreq.getOrDefault(word.charAt(i), 0) + 1);
            }

            while (end < word.length()) {
                if (hasEqualFrequency(charFreq, k) && hasAdjacentDifferenceAtMostTwo(word, start, end)) {
                    count++;
                }

                charFreq.put(word.charAt(start), charFreq.get(word.charAt(start)) - 1);
                start++;
                end++;

                if (end<word.length() && windowSize < word.length()) {
                    charFreq.put(word.charAt(end), charFreq.getOrDefault(word.charAt(end), 0) + 1);
                }
            }
        }

        return count;
    }

    private static boolean hasEqualFrequency(Map<Character, Integer> charFreq, int k) {
        for (int value : charFreq.values()) {
            if (value != k && value != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasAdjacentDifferenceAtMostTwo(String word, int start, int end) {
        for (int i = start + 1; i <= end; ++i) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
                return false;
            }
        }
        return true;
    }
    /*
    1. we calculate the unique characters count
    2. if unique character =2 we need to search for length==2*k=6
        if unique character =3 we need to search just for lengths 3*k=9
        if unique character =1 we need to search just for lengths 1*k=3
    3. we build an initial map with the start till end for the window length and then for next other characters we just
       add and remove from map correspondingly
    4. keep the count for valid substrings updated whenver we have the valid substring


    */

}
