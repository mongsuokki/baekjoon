import java.io.*;
import java.util.*;

public class Main {
	static long[] arr;
	static Queue<long[]> que;
	static boolean[] visit;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		String A = br.readLine();
		StringTokenizer st = new StringTokenizer(A);
		int N = Integer.parseInt(st.nextToken());
		que = new LinkedList<>();
		arr = new long[N + 1];
		visit = new boolean[N + 1];
		tree = new ArrayList[N + 1];
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
		dfs(R);
		for (int i = 1; i <= N; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

	static void dfs(int R) {
		visit[R] = true;
		long[] depth = new long[2];
		depth[0] = R;
		depth[1] = 0;
		que.add(depth);
		arr[R] = depth[1];
		for (long i = 1; !que.isEmpty(); i++) {
			long dep = que.peek()[1] + 1;
			int next = (int)que.poll()[0];
			arr[next] = (dep - 1) * i;
			Iterator<Integer> iter = tree[next].iterator();
			while (iter.hasNext()) {
				int num = iter.next();
				if (visit[num] == false) {
					visit[num] = true;
					long[] temp = new long[2];
					temp[0] = num;
					temp[1] = dep;
					que.add(temp);
				}
			}
		}
	}
}