import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<int[]>[] way = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            way[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            way[s].add(new int[]{e,c});
        }
        int[] ans = new int[N+1];
        Arrays.fill(ans,100000*1000);
        int start = sc.nextInt();
        int end = sc.nextInt();
        dijk(way,N,M,ans,start);
        System.out.println(ans[end]);
    } static void dijk(ArrayList<int[]>[] way, int N, int M, int[] ans, int start){
        ans[start] =0;
        PriorityQueue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        que.add(new int[]{start,0});
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int now = temp[0];
            int cost = temp[1];
            if(ans[now]<cost) {
                continue;
            }for(int i=0;i<way[now].size();i++){
                int next = way[now].get(i)[0];
                int nextcost = cost+way[now].get(i)[1];
                if(nextcost<ans[next]){
                    ans[next] = nextcost;
                    que.add(new int[]{next,nextcost});
                }
            }
        }
    }
}