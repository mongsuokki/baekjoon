import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), pick = 1, ans = 0;
        boolean[] univ = new boolean[N], visit = new boolean[N];
        ArrayList<int[]>[] map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            if (sc.next().equals("W")) univ[i] = true;
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt()-1, v = sc.nextInt()-1, d = sc.nextInt();
            map[u].add(new int[]{u, v, d});
            map[v].add(new int[]{v, u, d});
        }
        PriorityQueue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        que.addAll(map[0]);
        visit[0] = true;
        while (pick != N && !que.isEmpty()) {
            int[] temp = que.poll();
            if (visit[temp[1]] || univ[temp[0]] == univ[temp[1]]) continue;
            ans += temp[2];
            que.addAll(map[temp[1]]);
            visit[temp[1]] = true;
            pick++;
        }
        if (pick == N) System.out.println(ans);
        else System.out.println(-1);
    }
}