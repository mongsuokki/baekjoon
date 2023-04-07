import java.util.*;
import java.io.*;
public class Main {
    static class Point{
        int row, col, cost, length;
        public Point(int row, int col, int cost, int length) {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.length = length;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][][] visit;
    static int min = INF;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i=0; i<N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        visit = new boolean[N][M][2];
        bfs(new Point(0,0,1,1));
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    
    static void bfs(Point p) {
        Queue<Point> pq = new LinkedList<>();
        visit[p.row][p.col][1] = true;
        visit[p.row][p.col][0] = true;
        pq.offer(p);
        while(!pq.isEmpty()) {
            Point now = pq.poll();
            if(now.row == N-1 && now.col == M-1) {
                min = Math.min(min, now.length);
                return;
            }
            for(int i=0; i<4; i++) {
                int dRow = now.row + dr[i];
                int dCol = now.col + dc[i];
                if(dRow >= N || dCol >= M || dRow <0 || dCol < 0 || visit[dRow][dCol][now.cost]) continue;
                if(visit[dRow][dCol][1] && arr[dRow][dCol] == '1') continue;
                else if(arr[dRow][dCol] == '1' && now.cost == 1) {
                    visit[dRow][dCol][now.cost] = true;
                    pq.offer(new Point(dRow, dCol, 0, now.length + 1));
                }
                else if(arr[dRow][dCol] == '0') {
                    if(now.cost == 1) visit[dRow][dCol][0] = true;
                    visit[dRow][dCol][now.cost] = true;
                    pq.offer(new Point(dRow, dCol, now.cost, now.length + 1));
                }
            }
        }
    }
}