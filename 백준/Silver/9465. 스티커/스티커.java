import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] sticker;
        int[][] dp;
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            sticker = new int[2][N];
            dp = new int[2][N];
            for(int i = 0; i < N; i++){
                sticker[0][i] = sc.nextInt();
            }
            for(int i = 0; i < N; i++){
                sticker[1][i] = sc.nextInt();
            }
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if(N>1){
                dp[0][1] = dp[1][0]+sticker[0][1];
                dp[1][1] = dp[0][0]+sticker[1][1];
                for(int i = 2; i < N; i++){
                    dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+sticker[0][i];
                    dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2])+sticker[1][i];
                }
            }
            System.out.println(Math.max(dp[0][N-1],dp[1][N-1]));
        }
    }
}