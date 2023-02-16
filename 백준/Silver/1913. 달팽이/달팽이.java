import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = 0;
		int Y = 0;
		int[][] arr = new int[N][N];
		int num = N * N;
		for (int snail = 0; num > 0; snail++) {
			// 밑으로
			for (int i = snail; i < N - snail; i++) {
				if (num == M) {
					X = i;
					Y = snail;
				}
				arr[i][snail] = num;
				num--;
			}
			// 오른쪽으로
			for (int i = snail + 1; i < N - snail; i++) {
				if (num == M) {
					X = N - 1 - snail;
					Y = i;
				}
				arr[N - 1 - snail][i] = num;
				num--;
			}
			// 위로
			for (int i = N - 2 - snail; i > snail - 1; i--) {
				if (num == M) {
					X = i;
					Y = N - 1 - snail;
				}
				arr[i][N - 1 - snail] = num;
				num--;
			}
			// 왼쪽으로
			for (int i = N - 2 - snail; i > snail; i--) {
				if (num == M) {
					X = snail;
					Y = i;
				}
				arr[snail][i] = num;
				num--;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.println((X + 1) + " " + (Y + 1));
	}
}