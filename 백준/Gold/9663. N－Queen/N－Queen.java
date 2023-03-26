import java.util.*;

class Main {
	static int[] arr;
	static int N;
	static int max;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		max = 0;
		queen(0);
		System.out.println(max);
	}

	static void queen(int depth) {
		if (depth == N) {
			++max;
			return;
		}
		for (int i = 0; i < N; ++i) {
			arr[depth] = i;
			if (isPossible(depth)) {
				queen(depth + 1);
			}
		}
	}

	static boolean isPossible(int R) {
		for (int i = 0; i < R; ++i) {
			if (arr[i] == arr[R] || Math.abs(i - R) == Math.abs(arr[i] - arr[R])) {
				return false;
			}
		}
		return true;
	}
}