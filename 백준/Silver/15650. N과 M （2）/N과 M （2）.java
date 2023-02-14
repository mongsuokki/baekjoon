import java.util.*;

public class Main {
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visit = new boolean[N];
		arr = new int[M];
		dfs(N, M, 0);
		System.out.println(sb);
	}

	public static void dfs(int N, int M, int depth) {

		if (depth == M) {
			for (int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i] == false) {
				if (depth == 0 || (depth > 0 && arr[depth - 1] <= i)) {
					visit[i] = true;
					arr[depth] = i + 1;
					dfs(N, M, depth + 1);
					visit[i] = false;
				}
			}
		}
	}
}