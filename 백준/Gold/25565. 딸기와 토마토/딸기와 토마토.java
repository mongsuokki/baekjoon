import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        boolean[][] map = new boolean[N][M];
        int[][] chk = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sc.nextInt() == 1) map[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == true) {
                    boolean Xchk = true;
                    boolean Ychk = true;
                    if (N - i >= K) {
                        for (int k = 0; k < K; k++) {
                            if (map[i + k][j] == false) {
                                Ychk = false;
                                break;
                            }
                        }
                        if (Ychk) {
                            for (int k = 0; k < K; k++) {
                                chk[i + k][j]++;
                            }
                            cnt++;
                        }
                    }
                    if (M - j >= K) {
                        for (int k = 0; k < K; k++) {
                            if (map[i][j + k] == false) {
                                Xchk = false;
                            }
                        }
                        if (Xchk) {
                            for (int k = 0; k < K; k++) {
                                chk[i][j + k]++;
                            }
                            cnt++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chk[i][j] == cnt) {
                    ans++;
                    sb.append((i + 1) + " " + (j + 1) + "\n");
                }
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }
}