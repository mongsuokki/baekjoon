import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static ArrayList<Integer>[] tree;
	static Stack<Integer> stc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String A = br.readLine();
		StringTokenizer st = new StringTokenizer(A);
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		visit = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		stc = new Stack<>();
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
		bfs(R, 0);
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int R, int depth) {
		visit[R] = true;
		stc.add(R);
		arr[R] = depth++;
		Iterator<Integer> iter = tree[stc.pop()].iterator();
		while (iter.hasNext()) {
			int next = iter.next();
			if (visit[next] == false) {
				visit[next] = true;
				bfs(next, depth);
			}
		}
	}
}