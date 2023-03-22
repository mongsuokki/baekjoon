import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[] item = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            item[i] = sc.nextInt();
        }
        int max = 0;
        int[][] way = new int[n+1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(way[i],1501);
            way[i][i]=0;
        }
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            if(way[a][b]>l){
                way[a][b] = l;
                way[b][a] = l;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                for(int k = 1; k <= n; k++){
                    if(i==k) continue;
                    if(way[j][k]>way[j][i]+way[i][k]){
                        way[j][k] = way[j][i]+way[i][k];
                    }
                }
            }
        }
        for(int i=1;i <= n; i++){
            int temp =0;
            for(int j = 1; j <= n; j++){
                if(way[i][j]<=m){
                    temp+=item[j];
                }
            }
            if(temp>max) max = temp;
        }
        System.out.println(max);
    }
}