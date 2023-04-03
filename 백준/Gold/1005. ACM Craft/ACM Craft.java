import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N + 1];
            int[] time = new int[N + 1];
            int[] ans = new int[N + 1];
            ArrayList<Integer>[] map = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                time[i] = sc.nextInt();
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                int st1 = sc.nextInt();
                int st2 = sc.nextInt();
                map[st1].add(st2);
                arr[st2]++;
            }
            int W = sc.nextInt();
            Queue<Integer> que = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (arr[i] == 0) {
                    que.add(i);
                    ans[i] = time[i];
                }

            }
            while (arr[W] != 0) {
                int num = que.poll();
                for (int temp : map[num]) {
                    arr[temp]--;
                    if (arr[temp] == 0) {
                        que.add(temp);
                    }
                    ans[temp] = Math.max(ans[temp], ans[num] + time[temp]);
                }
            }
            System.out.println(ans[W]);
        }
    }
}