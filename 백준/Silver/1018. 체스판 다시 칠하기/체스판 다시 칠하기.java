import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = 64;
		int cnt;
		String[][] board = new String[N][];
		for (int i = 0; i < N; i++) {
			board[i] = sc.next().split("");
		}
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				// 88 체스판 시작지점
				cnt = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if ((k + l) % 2 == 0) {
							if (board[k][l].equals("B")) {
								cnt++;
							}
						} else {
							if (board[k][l].equals("W")) {
								cnt++;
							}
						}
					}
				}
				if (cnt > 32) {
					cnt = 64 - cnt;
				}
				if (cnt < min) {
					min = cnt;
				}
			}
		}
		System.out.println(min);
	}
}