import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<forest> que = new PriorityQueue<>((o1,o2)->o1.num-o2.num);
        int N = sc.nextInt(),max=0;
        int[] R = { -1, 0, 1, 0 };
        int[] C = { 0, 1, 0, -1 };
        int[][] map = new int[N][N], dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                que.add(new forest(i, j, num));
                map[i][j] = num;
            }
        }
        while (!que.isEmpty()) {
            forest temfo = que.poll();
            for (int i = 0; i < 4; i++) {
                int NR = temfo.y + R[i], NC = temfo.x + C[i];
                if (NR >= 0 && NC >= 0 && NR < N && NC < N && map[NR][NC] < temfo.num
                        && dp[temfo.y][temfo.x] <= dp[NR][NC])
                    dp[temfo.y][temfo.x] = dp[NR][NC] + 1;
                if(dp[temfo.y][temfo.x]>max) max = dp[temfo.y][temfo.x];
            }
        }
        System.out.println(max+1);
    }

    static class forest {
        int x;
        int y;
        int num;
        public forest(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }
}