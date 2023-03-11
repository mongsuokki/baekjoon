import java.util.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }
        check(0, N, 0, N);
        System.out.println(sb);
    }

    static void check(int x1, int x2, int y1, int y2) {
        int start = arr[y1][x1] - '0';
        boolean cnt = true;
        x: for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                if (arr[i][j] - '0' != start) {
                    cnt = false;
                    sb.append("(");
                    check(x1, (x1+x2) / 2, y1, (y1+y2) / 2);
                    check((x1+x2) / 2, x2, y1, (y1+y2) / 2);
                    check(x1, (x1+x2) / 2, (y1+y2) / 2, y2);
                    check((x1+x2) / 2, x2, (y1+y2) / 2, y2);
                    sb.append(")");
                    return;
                }
            }
        }
        if (cnt == true) {
            sb.append(start);
        }
    }
}