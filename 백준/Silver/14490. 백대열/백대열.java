import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.next().split(":");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		if (N > M) {
			System.out.println(N / cho(N, M) + ":" + M / cho(N, M));
		} else {
			System.out.println(N / cho(M, N) + ":" + M / cho(M, N));
		}

	}

	public static int cho(int A, int B) {
		if (A % B == 0) {
			return B;
		}
		return cho(B, A % B);
	}
}
