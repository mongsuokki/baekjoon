import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = 0;
		int B = 0;
		int cnt = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = N - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				A = i - 1;
				break;
			} else
				cnt++;
		}
		if (cnt == N - 1) {
			System.out.println(-1);
		} else {
			for (int i = N - 1; i > A; i--) {
				if (arr[i] < arr[A]) {
					B = i;
					break;
				}
			}
			int arrA = arr[A];
			arr[A] = arr[B];
			arr[B] = arrA;
			for (int i = 0; i < (N - A - 1) / 2; i++) {
				int temp = arr[A + 1 + i];
				arr[A + 1 + i] = arr[N - 1 - i];
				arr[N - 1 - i] = temp;
			}
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
