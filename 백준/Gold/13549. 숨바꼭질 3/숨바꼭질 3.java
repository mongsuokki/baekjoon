import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        Queue<time> que = new LinkedList<>();
        int[] arr = new int[200001];
        que.add(new time(N, 0));
        while (que.peek().now != K) {
            time temp = que.poll();
            int now = temp.now;
            if (now <= K + 1 / 2 && (arr[2 * now] == 0 || arr[2 * now] > temp.ans)) {
                que.add(new time(2 * now, temp.ans));
                arr[2 * now] = temp.ans;
            }
            if (now > 0 && arr[now - 1] == 0) {
                que.add(new time(now - 1, temp.ans + 1));
                arr[now - 1] = temp.ans + 1;
            }
            if (now < K && arr[now + 1] == 0) {
                que.add(new time(now + 1, temp.ans + 1));
                arr[now + 1] = temp.ans + 1;
            }
        }
        System.out.print(que.poll().ans);
    }

    static class time {
        int now;
        int ans;

        public time(int now, int ans) {
            this.now = now;
            this.ans = ans;
        }
    }
}