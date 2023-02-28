import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> deq = new ArrayDeque<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			deq.add(i);
			arr[i] = sc.nextInt();
		}
		while (!deq.isEmpty()) {
			int temp = deq.pop();
			System.out.print((temp + 1) + " ");
			if (!deq.isEmpty()) {
				if (arr[temp] > 0) {
					for (int j = 0; j < (arr[temp] - 1) % N; j++) {
						deq.add(deq.pop());
					}
				} else {
					for (int j = 0; j < -arr[temp]; j++) {
						deq.push(deq.removeLast());
					}
				}
			}
		}
	}
}