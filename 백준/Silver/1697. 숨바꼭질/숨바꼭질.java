import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans = 0;
		Queue<Integer> que = new LinkedList<>();
		boolean[] arr = new boolean[200001];
		que.add(N);
		arr[N] = true;
		que.add(-1);
		while (que.peek() != K) {
			int now = que.poll();
			if (now == -1) {
				ans++;
				que.add(-1);
			} else {
				if (now > 0 && arr[now - 1] == false) {
					que.add(now - 1);
					arr[now - 1] = true;
				}
				if (now < K && arr[now + 1] == false) {
					que.add(now + 1);
					arr[now + 1] = true;
				}
				if (now <= K+1 / 2 && arr[2 * now] == false) {
					que.add(2 * now);
					arr[2 * now] = true;
				}
			}
		}
		System.out.print(ans);
	}
}