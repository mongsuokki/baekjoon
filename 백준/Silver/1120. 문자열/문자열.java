import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] A = sc.next().split("");
		String[] B = sc.next().split("");
		int max = 0;
		for (int i = 0; i < B.length - A.length + 1; i++) {
			int cnt = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j].equals(B[j + i])) {
					cnt++;
				}
			}
			if (cnt > max) {
				max = cnt;
			}
		}
		System.out.println(A.length - max);
	}
}
