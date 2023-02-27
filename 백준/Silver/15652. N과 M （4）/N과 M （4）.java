import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[M];
		dfs(N, M, 0);
		System.out.println(sb);

	}

	static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			max =0;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (i >= max) {
				max = i;
				arr[depth] = i+1;
				dfs(N,M,depth+1);
			} else {
				continue;
			}

		}
	}
}