import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println(nazi(new Scanner(System.in).nextLong()));
	}

	static Long nazi(Long N) {
		if (N == 0) {
			return 0L;
		} else if (N == 1) {
			return 1L;
		} else if (N == 2) {
			return 1L;
		} else if (N == 3) {
			return 2L;
		} else if (N == 4) {
			return 3L;
		} else if (N == 5) {
			return 5L;
		} else if (N == 6) {
			return 8L;
		} else if (N == 7) {
			return 13L;
		} else {
			return 7 * nazi(N - 4) - nazi(N - 8);
		}
	}
}