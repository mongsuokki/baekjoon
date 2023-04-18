import java.util.*;

public class Main {
    static int[] R = { -1, 0, 1, 0 },C = { 0, 1, 0, -1 };
    static boolean[][] bool,can;
    static char[][] map;
    static int N,M,ans;
    static boolean chk;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ans=0;
        bool = new boolean[N][M];
        can = new boolean[N][M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                chk=false;
                dfs(i,j,0);
            }
        }
        System.out.println(ans);
    }

    static void dfs(int y, int x,int way) {
        if (bool[y][x]) return;
        bool[y][x] = true;
        int nway = way;
        switch (map[y][x]) {
            case ('U'):
                nway = 0;
                break;
            case ('R'):
                nway = 1;
                break;
            case ('D'):
                nway = 2;
                break;
            case ('L'):
                nway = 3;
                break;
        }
        int NR = y+R[nway];
        int NC = x+C[nway];
        if(NR>=N||NC>=M||NR<0||NC<0) {
            chk=true;
            ans++;
            can[y][x] = true;
            return;
        }
        if(can[NR][NC]){
            chk=true;
            ans++;
            can[y][x] = true;
            return;
        }
        dfs(NR,NC,nway);
        if(chk) {
            ans++;
            can[y][x] = true;
        }
        return;
    }
}