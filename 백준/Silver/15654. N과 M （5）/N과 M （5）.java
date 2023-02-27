import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static int[] arr2;
	public static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[M];
		arr2 = new int[N];
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr2);
		dfs(N, M, 0);
		System.out.println(sb);

	}

	static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]==false) {
				visit[i] = true;
				arr[depth] = arr2[i];
				dfs(N,M,depth+1);
				visit[i] = false;
			} else {
				continue;
			}

		}
	}
}