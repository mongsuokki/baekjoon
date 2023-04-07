import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] monR = { -1, 0, 1, 0 }, monC = { 0, 1, 0, -1 }, horR = { -2, -1, 1, 2, 2, 1, -1, -2 },
				horC = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int K = sc.nextInt(), W = sc.nextInt(), H = sc.nextInt(), min = 40000;
		int[][] map = new int[H][W];
		boolean[][][] visit = new boolean[K+1][H][W];
		Queue<now> que = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		que.add(new now(0, 0, 0, K));
		while (!que.isEmpty()) {
			now temp = que.poll();
			int X = temp.x, Y = temp.y, score = temp.score, jump = temp.jump;
			if (X == W - 1 && Y == H - 1) {
				if (score < min)
					min = score;
				continue;
			}
			if (visit[jump][Y][X])
				continue;
			else
				visit[jump][Y][X] = true;
			for (int i = 0; i < 4; i++) {
				int NC = X + monC[i], NR = Y + monR[i];
				if (NC < W && NR < H && NC >= 0 & NR >= 0 && map[NR][NC] != 1) {
					que.add(new now(NC, NR, score + 1, jump));
				}
			}
			if (jump != 0) {
				for (int i = 0; i < 8; i++) {
					int NC = X + horC[i], NR = Y + horR[i];
					if (NC < W && NR < H && NC >= 0 & NR >= 0 && map[NR][NC] != 1) {
						que.add(new now(NC, NR, score + 1, jump - 1));
					}
				}
			}
		}
		if (min == 40000)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	static class now {
		int x, y, score, jump;

		public now(int x, int y, int score, int jump) {
			this.x = x;
			this.y = y;
			this.score = score;
			this.jump = jump;
		}
	}
}
