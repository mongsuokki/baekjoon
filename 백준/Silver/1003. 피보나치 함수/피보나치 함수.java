import java.util.*;

public class Main {
	static int[] arr = new int[41];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		fibo(40);
		fibo(39);
		fibo(38);
		fibo(37);
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			if (N == 0) {
				System.out.println(1 + " " + 0);
			} else {
				System.out.println(arr[N - 1] + " " + arr[N]);
			}
		}
	}

	static int fibo(int N) {
		if (N == 0) {
			arr[N] = 0;
			return 0;
		} else if (N == 1) {
			arr[N] = 1;
			return 1;
		} else if (N == 2) {
			arr[N] = 1;
			return arr[N];
		} else if (N == 3) {
			arr[N] = 2;
			return arr[N];
		} else if (N == 4) {
			arr[N] = 3;
			return arr[N];
		} else if (N == 5) {
			arr[N] = 5;
			return arr[N];
		} else if (N == 6) {
			arr[N] = 8;
			return arr[N];
		} else if (N == 7) {
			arr[N] = 13;
			return arr[N];
		} else {
			arr[N] = 7 * fibo(N - 4) - fibo(N - 8);
			return arr[N];
		}
	}
}