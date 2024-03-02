package LeetCode;

public class JustOneEdit {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("acbbcda","abbdad"));
    }
        public static boolean isOneEditDistance(String s, String t) {
            Boolean[][][] dp=new Boolean[s.length()+1][t.length()+1][2];
            return canEdit(s,s.length()-1,t,t.length()-1,1,dp);
        }
        private static boolean canEdit(String w1,int i,String w2,int j,int k,Boolean[][][] dp){
            if(i==0 && j==0)
            {
                if(k==0)
                    return w1.charAt(i)==w2.charAt(j);
                return w1.charAt(i) != w2.charAt(j);

            }

            if(i<0){
                if(k==j+1)
                    return true;
                return false;
            }
            if(j<0){
                if(k==i+1)
                    return true;
                return false;
            }
            if(dp[i][j][k]!=null)
                return dp[i][j][k];
            char c1=w1.charAt(i);
            char c2=w2.charAt(j);

            if((c1==c2))
                return dp[i][j][k]=canEdit(w1,i-1,w2,j-1,k,dp);

            boolean op1=canEdit(w1,i,w2,j-1,k-1,dp);//insert
            //delete
            boolean op2=canEdit(w1,i-1,w2,j,k-1,dp);
            //replace
            boolean op3=canEdit(w1,i-1,w2,j-1,k-1,dp);
            return dp[i][j][k]= op1 || op2|| op3;

        }

}
