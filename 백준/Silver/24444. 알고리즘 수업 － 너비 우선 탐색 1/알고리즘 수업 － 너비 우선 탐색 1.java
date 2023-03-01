import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static Queue<Integer> que;
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
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}

	static void dfs(int R) {
		visit[R] = true;
		que.add(R);
		for (int i = 1; !que.isEmpty(); i++) {
			int next = que.poll();
			arr[next] = i;
			Iterator<Integer> iter = tree[next].iterator();
			while (iter.hasNext()) {
				int num = iter.next();
				if (visit[num] == false) {
					visit[num] = true;
					que.add(num);
				}
			}
		}
	}
}