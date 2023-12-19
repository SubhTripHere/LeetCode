package LeetCode;

public class ShortestLexicographicallyBeautifulSubarray {

    public static void main(String[] args) {
        System.out.println(shortestBeautifulSubstring("100011001",3));
    }
    public static String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        String ans = "";

        while (j < n) {
            if (s.charAt(j) == '1') {
                cnt++;
            }

            if (cnt == k) {
                while (i < n && cnt == k) {
                    String temp = s.substring(i, j + 1);
                    if (ans.isEmpty() || ans.length() > temp.length()) {
                        ans = temp;
                    } else if (ans.length() == temp.length()) {
                        ans = ans.compareTo(temp) < 0 ? ans : temp;
                    }

                    if (s.charAt(i) == '1') {
                        cnt--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
