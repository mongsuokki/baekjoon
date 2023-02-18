import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int line;
		if (N > M) {
			line = M / 2;
		} else {
			line = N / 2;
		}
		Queue<Integer> que = new LinkedList<>();
		int A = 2 * (N + M - 2)+8;
		for (int t = 0; t < line; t++) {
			A -= 8;
			for (int i = t; i < N - t; i++) {
				que.offer(arr[i][t]);
			}
			for (int i = t + 1; i < M - t; i++) {
				que.offer(arr[N - 1 - t][i]);
			}
			for (int i = N - 2 - t; i >= t; i--) {
				que.offer(arr[i][M - 1 - t]);
			}
			for (int i = M - 2 - t; i > t; i--) {
				que.offer(arr[t][i]);
			}
			for (int i = 0; i < A - (R % A); i++) {
				que.offer(que.poll());
			}
			for (int i = t; i < N - t; i++) {
				arr[i][t] = que.poll();
			}
			for (int i = t + 1; i < M - t; i++) {
				arr[N - 1 - t][i] = que.poll();
			}
			for (int i = N - 2 - t; i >= t; i--) {
				arr[i][M - 1 - t] = que.poll();
			}
			for (int i = M - 2 - t; i > t; i--) {
				arr[t][i] = que.poll();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
