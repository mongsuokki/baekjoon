import java.util.*;

class Main {
    static int[] ans;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        ans = new int[V + 1];
        Arrays.fill(ans, 10000*(V-1));
        ArrayList<int[]>[] way = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            way[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            way[u].add(new int[]{v, w});
        }
        dijk(way, V, start);
        for (int i = 1; i <= V; i++) {
            if (i == start) {
                System.out.println(0);
                continue;
            }
            if (ans[i] == 10000*(V-1)) {
                System.out.println("INF");
            } else {
                System.out.println(ans[i]);
            }
        }
    }

    static void dijk(List<int[]>[] way, int V, int start) {
        ans[start] = 0;
        Queue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        // 람다 함수
        que.add(new int[]{start, 0});
        // 시작지점에서 시작지점으로 가는 최단거리는 0
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int now = temp[0];
            // 이때까지 최단거리
            int distance = temp[1];
            // 최단 거리가 아닐 경우 넘어간다.
            if (ans[now] < distance) {
                continue;
            }
            for (int i = 0; i < way[now].size(); i++) {
                int next = way[now].get(i)[0];
                int nextDistance = distance + way[now].get(i)[1];
                if (nextDistance < ans[next]) {
                    ans[next] = nextDistance;
                    que.add(new int[]{next, nextDistance});
                }
            }
        }
    }
}