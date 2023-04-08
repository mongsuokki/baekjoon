import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),pick=1;
        double ans=0;
        star[] stars = new star[N];
        for(int i=0;i<N;i++) {
            stars[i] = new star(sc.nextDouble(),sc.nextDouble());
        }
        boolean[] visit = new boolean[N];
        double[][] map = new double[N][N];
        PriorityQueue<edge> que = new PriorityQueue<>(((o1, o2) -> (int)(o1.dist - o2.dist)));
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[j][i]==0) {
                    map[i][j] = Math.sqrt(Math.pow(Math.abs(stars[i].x-stars[j].x), 2)+Math.pow(Math.abs(stars[i].y-stars[j].y), 2));
                }else {
                    map[i][j] = map[j][i];
                }
            }
        }
        visit[0] = true;
            for(int i=1;i<N;i++){
                que.add(new edge(0,i,map[0][i]));
            }
        while(pick!=N){
            edge temp = que.poll();
            if(visit[temp.star2]) continue;
            ans+=temp.dist;
            for(int i=0;i<N;i++){
                if(visit[i]) continue;
                que.add(new edge(temp.star2,i,map[temp.star2][i]));
            }
            visit[temp.star2] = true;
            pick++;
        }
        System.out.println(ans);
    } static class star{
        double y;
        double x;
        star(double y, double x){
            this.y = y;
            this.x = x;
        }
    } static class edge{
        int star1;
        int star2;
        double dist;
        public edge(int star1, int star2, double dist) {
            this.star1 = star1;
            this.star2 = star2;
            this.dist = dist;
        }
    }
}