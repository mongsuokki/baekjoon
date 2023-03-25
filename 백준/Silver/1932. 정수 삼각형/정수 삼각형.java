import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max =0;
        int[][] num = new int[N][];
        int[][] dp = new int[N][];
        for(int i=0;i < N; i++){
            num[i] = new int[i+1];
            dp[i] = new int[i+1];
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = num[0][0];
        for(int i = 1; i < N; i++){
            dp[i][0] = dp[i-1][0]+num[i][0];
            for(int j = 1; j <num[i].length-1; j++){
            dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+num[i][j];
            }
            dp[i][num[i].length-1] = dp[i-1][num[i-1].length-1]+num[i][num[i].length-1];
        }
        for(int i = 0; i <N; i++){
            if(dp[N-1][i]>max){
                max = dp[N-1][i];
            }
        }
        System.out.println(max);
    }
}