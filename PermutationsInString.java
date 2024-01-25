package LeetCode;

public class PermutationsInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaeao"));
    }
        public static boolean checkInclusion(String s1, String s2) {
            // we create a window of length s1;
            // we then create start and end pointer, start=0, end=s1.length()
            // we traverse till end<s.length();
            //we increase the window and compare if the freq map of both the window string of s2 and s1 are equal


            int[] freqS1=new int[26];
            for(char ch: s1.toCharArray())
                freqS1[ch-'a']++;

            int start=0;
            int end=0;
            int[] freqW=new int[26];
            for(;end<s1.length();end++)
                freqW[s2.charAt(end)-'a']++;
            if(isSame(freqW,freqS1))
                return true;
            while(end<s2.length()){
                char ch=s2.charAt(end++);
                freqW[ch-'a']++;
                freqW[s2.charAt(start++)-'a']--;
                if(isSame(freqW,freqS1))
                    return true;
            }

            return false;
        }
        private static boolean isSame(int[] f2,int[] f1){
            for(int i=0;i<26;i++){
                if(f1[i]!=f2[i])
                    return false;
            }
            return true;
        }

}
