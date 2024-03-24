package LeetCode;

public class CountFertilePyramids {

    public static void main(String[] args) {
        System.out.println(countPyramids(new int[][]{
                {1,1,1,1,0},{1,1,1,1,1},{1,1,1,1,1},{0,1,0,0,1}
        }));
    }
        public static int countPyramids(int[][] grid) {
            int rows=grid.length;
            int cols=grid[0].length;
            int[][] dp=new int[rows][cols];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(i==0){
                        dp[i][j]=grid[i][j];
                    }else{
                        if(grid[i][j]==1)
                            dp[i][j]=dp[i-1][j]+1;
                        else
                            dp[i][j]=0;
                    }
                }
            }
            int countUp=0;
            for(int i=0;i<rows-1;i++){
                for(int j=1;j<cols-1;j++){
                    if(dp[i][j]>=1){
                        

                            countUp++;
                    }
                }
            }

            System.out.println(countUp);
            //

            for(int i=rows-1;i>=0;i--){
                for(int j=cols-1;j>=0;j--){
                    if(i==rows-1){
                        dp[i][j]=grid[i][j];
                    }else{
                        if(grid[i][j]==1){
                            dp[i][j]=dp[i+1][j]+1;
                        }else{
                            dp[i][j]=0;
                        }
                    }
                }
            }

            int countDown=0;
            for(int i=rows-2;i>=0;i--){
                for(int j=1;j<cols-1;j++){
                    if(dp[i][j]>1){
                        int tar=dp[i][j]-1;
                        if(dp[i+1][j]==tar && dp[i+1][j]==dp[i+1][j-1] && dp[i+1][j-1]==dp[i+1][j+1] )
                            countDown++;
                    }
                }
            }

            return countUp+countDown;

        }

}
