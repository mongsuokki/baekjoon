import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[][] way = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(way[i], 10000000);
            way[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(way[a][b]>c){
            way[a][b] = c;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int k = 1; k <= n; k++) {
                    if (i == k) continue;
                    if (way[j][k] > way[j][i] + way[i][k]) {
                        way[j][k] = way[j][i] + way[i][k];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (way[i][j] == 10000000) {
                    sb.append(0+" ");
                }else{
                    sb.append(way[i][j]+" ");
                }
            }sb.append("\n");
        }
        System.out.println(sb);
    }
}