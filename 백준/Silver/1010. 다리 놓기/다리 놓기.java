import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int nmfac = 1;
			int mfac = 1;
			for (int i = N + 1, j = 1; i <= M; i++, j++) {
				mfac *= i;
				nmfac *= j;
				if (mfac % nmfac == 0) {
					mfac /= nmfac;
					nmfac = 1;
				}
			}
			System.out.println(mfac / nmfac);
		}
	}
}