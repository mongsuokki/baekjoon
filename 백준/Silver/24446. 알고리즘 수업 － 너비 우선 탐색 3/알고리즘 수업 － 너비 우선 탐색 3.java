import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static Queue<int[]> que;
	static boolean[] visit;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String A = br.readLine();
		StringTokenizer st = new StringTokenizer(A);
		int N = Integer.parseInt(st.nextToken());
		que = new LinkedList<>();
		arr = new int[N + 1];
		visit = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
			arr[i] = -1;
		}
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			A = br.readLine();
			st = new StringTokenizer(A);
			int up = Integer.parseInt(st.nextToken());
			int down = Integer.parseInt(st.nextToken());
			tree[up].add(down);
			tree[down].add(up);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(tree[i]);
		}
		dfs(R);
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int R) {
		visit[R] = true;
		int[] depth = new int[2];
		depth[0] = R;
		depth[1] = 0;
		que.add(depth);
		arr[R] = depth[1];
		while (!que.isEmpty()) {
			int dep = que.peek()[1] + 1;
			int next = que.poll()[0];
			Iterator<Integer> iter = tree[next].iterator();
			while (iter.hasNext()) {
				int num = iter.next();
				if (visit[num] == false) {
					visit[num] = true;
					arr[num] = dep;
					int[] temp = new int[2];
					temp[0] = num;
					temp[1] = dep;
					que.add(temp);
				}
			}
		}
	}
}