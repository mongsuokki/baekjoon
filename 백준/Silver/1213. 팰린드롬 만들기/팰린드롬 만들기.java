import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		char[] arr = new char[26];
		String A = sc.next();
		for (int i = 0; i < A.length(); i++) {
			arr[A.charAt(i) - 'A']++;
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				cnt++;
				num = i;
			}
			if (cnt > 1) {
				System.out.println("I'm Sorry Hansoo");
				System.exit(0);
			}
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i] > 1) {
				for (int j = 0; j < arr[i] / 2; j++) {
					sb.append((char) (i + 'A'));
				}
			}
		}
		if (A.length() % 2 == 1) {
			sb.append((char) (num + 'A'));
		}
		for (int i = 25; i >= 0; i--) {
			if (arr[i] > 1) {
				for (int j = 0; j < arr[i] / 2; j++) {
					sb.append((char) (i + 'A'));
				}
			}
		}
		System.out.println(sb);
	}
}