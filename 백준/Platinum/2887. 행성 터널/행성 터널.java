import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), pick = 1, ans = 0;
        int[][] stars = new int[N][4];
        boolean[] visit = new boolean[N];
        ArrayList<int[]>[] list = new ArrayList[N];
        PriorityQueue<int[]> que = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = i;
            for (int j = 1; j < 4; j++) {
                stars[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < 4; i++) {
            int I = i;
            Arrays.sort(stars, (o1, o2) -> o1[I] - o2[I]);
            for (int j = 0; j < N - 1; j++) {
                list[stars[j][0]].add(new int[]{stars[j+1][0],Math.abs(stars[j][I] - stars[j+1][I])});
                list[stars[j+1][0]].add(new int[]{stars[j][0],Math.abs(stars[j][I] - stars[j+1][I])});
            }
        }
        visit[0] = true;
        que.addAll(list[0]);
        while (pick != N) {
            int[] temp = que.poll();
            if (visit[temp[0]]) continue;
            que.addAll(list[temp[0]]);
            visit[temp[0]] = true;
            ans += temp[1];
            pick++;
        }
        System.out.println(ans);
    }
}