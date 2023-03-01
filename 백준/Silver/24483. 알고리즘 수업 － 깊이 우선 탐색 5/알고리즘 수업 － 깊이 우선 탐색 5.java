import java.io.*;
import java.util.*;

public class Main {
	static long[] arr;
	static boolean[] visit;
	static ArrayList<Integer>[] tree;
	static Stack<Integer> stc;
	static long cnt =1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		long sum =0;
		StringTokenizer st = new StringTokenizer(A);
		int N = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		visit = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		stc = new Stack<>();
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
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
			sum+=arr[i];
		}
		System.out.println(sum);
	}

	static void bfs(int R, long depth) {
		visit[R] = true;
		stc.add(R);
		arr[R] = depth++*cnt++;
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