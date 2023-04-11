import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),max=0;
		int[][] arr = new int[N][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<N;j++) {
				arr[j][i] = sc.nextInt();
			}
		}
		int[] dp = new int[101];
		for(int i=0;i<N;i++) {
			for(int j=100;j>=arr[i][0];j--) {
				dp[j] = Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
				if(j!=100&&dp[j]>max) max = dp[j];
			}
		}
		System.out.println(max);
	}
}
