import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] R = {-1, 0, 1, 0}, C = {0, 1, 0, -1};
        int N = sc.nextInt(), M = sc.nextInt(), min = 1000000;
        int[][] map = new int[N][M];
        boolean[][][] visit = new boolean[2][N][M];
        Queue<now> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String A = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = A.charAt(j) - '0';
            }
        }
        que.add(new now(0, 0, 3, 0));
        while (!que.isEmpty()) {
            now temp = que.poll();
            int nowx = temp.x, nowy = temp.y, nowscore = temp.score, nowbrk = temp.brk;
            if (nowx == M - 1 && nowy == N - 1) {
                if (nowscore < min) min = nowscore;
                continue;
            }
            if (visit[nowbrk][nowy][nowx]) continue;
            else visit[nowbrk][nowy][nowx] = true;
            for (int i = 0; i < 4; i++) {
                int nextx = nowx + C[i], nexty = nowy + R[i];
                if (nextx < M && nexty < N && nextx >= 0 & nexty >= 0) {
                    if (map[nexty][nextx] == 1 && nowbrk == 0) {
                        que.add(new now(nextx, nexty, nowscore + 1, 1));
                    } else if (map[nexty][nextx] == 0) {
                        que.add(new now(nextx, nexty, nowscore + 1, nowbrk));
                    }
                }
            }
        }
        if (min == 1000000) System.out.println(-1);
        else System.out.println(min - 2);
    }
    static class now {
        int x,y,score,brk;
        public now(int x, int y, int score, int brk) {
            this.x = x;
            this.y = y;
            this.score = score;
            this.brk = brk;
        }
    }
}
