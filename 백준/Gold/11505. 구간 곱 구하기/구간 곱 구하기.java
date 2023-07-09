import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long[] tree, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		tree = new long[4 * N];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		set(1, 1, N);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				change(1, 1, N, b, c);
				arr[b] = c;
			} else {
				int c = Integer.parseInt(st.nextToken());
				sb.append(multiply(1, 1, N, b, c) + "\n");
			}
		}
		System.out.println(sb);
	}

	static long set(int node, int start, int end) {
		int mid = (start + end) / 2;
		if (start == end) {
			tree[node] = arr[start];
			return tree[node];
		}
		tree[node] = set(node * 2, start, mid) * set(node * 2 + 1, mid + 1, end) % 1000000007;
		return tree[node];
	}

	static long multiply(int node, int start, int end, int left, int right) {
		int mid = (start + end) / 2;
		if (end < left || right < start) return 1;
		else if (left <= start && end <= right) return tree[node];
		else
			return multiply(node * 2, start, mid, left, right) * multiply(node * 2 + 1, mid + 1, end, left, right) % 1000000007;
	}

	static long change(int node, int start, int end, int index, long c) {
		int mid = (start + end) / 2;
		if (index < start || index > end) return tree[node];
		if (start == end) return tree[node] = c;
		return tree[node] = change(node * 2, start, mid, index, c) * change(node * 2 + 1, mid + 1, end, index, c) % 1000000007;
	}
}
