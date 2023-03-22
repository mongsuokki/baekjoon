import java.util.*;

class Main {
    static int[] ans;
    static int[] item;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        item = new int[n + 1];
        ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            item[i] = sc.nextInt();
        }
        int max = 0;
        ArrayList<int[]>[] way = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            way[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            way[a].add(new int[]{b, l});
            way[b].add(new int[]{a, l});
        }
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijk(way, n, m, i));
        }
        System.out.println(max);
    }

    static int dijk(List<int[]>[] way, int n, int m, int start) {
        Arrays.fill(ans,100*30+1);
        boolean[] visit = new boolean[n + 1];
        Queue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        ans[start]=0;
        que.add(new int[]{start, 0});
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int now = temp[0];
            if (!visit[now]) {
                visit[now] = true;
                for (int i = 0; i < way[now].size(); i++) {
                    int next = way[now].get(i)[0];
                    int nextDistance = ans[now] + way[now].get(i)[1];
                    if (!visit[next] && nextDistance < ans[next]) {
                        ans[next] = nextDistance;
                        que.add(new int[]{next, nextDistance});
                    }
                }
            }
        }
        int get = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[i] <= m) {
                get += item[i];
            }
        }
        return get;
    }
}