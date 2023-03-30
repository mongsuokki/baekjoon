import java.util.*;

class Main {
    static ArrayList<int[]>[][] way;
    static int[][] map;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        for(int t=1;; t++){
            int N =sc.nextInt();
            if(N==0) break;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int ans = map[0][0];
            way = new ArrayList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    way[i][j] = new ArrayList<>();
                    if(i>0) way[i][j].add(new int[]{i-1,j,map[i-1][j]});
                    if(j<N-1) way[i][j].add(new int[]{i,j+1,map[i][j+1]});
                    if(i<N-1) way[i][j].add(new int[]{i+1,j,map[i+1][j]});
                    if(j>0) way[i][j].add(new int[]{i,j-1,map[i][j-1]});
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i],156250);
            }
            dijk();
            System.out.println("Problem "+t+": "+(ans+map[N-1][N-1]));
        }
    } static void dijk(){
        map[0][0] = 0;
        Queue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        que.add(new int[]{0,0,0});
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int nowY = arr[0];
            int nowX = arr[1];
            int cost = arr[2];
            if(map[nowY][nowX]<cost) continue;
            for(int i=0;i<way[nowY][nowX].size();i++){
                int nextY = way[nowY][nowX].get(i)[0];
                int nextX = way[nowY][nowX].get(i)[1];
                int nextcost = way[nowY][nowX].get(i)[2]+cost;
                if(nextcost<map[nextY][nextX]){
                    map[nextY][nextX] = nextcost;
                    que.add(new int[]{nextY,nextX,nextcost});
                }
            }
        }
    }
}