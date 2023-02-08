import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> deq = new ArrayDeque<>();
		deq.add(N);
		for (int i = 1; i < N; i++) {
			deq.push(N - i);
			for (int j = i; j < N; j++) {
				deq.push(deq.removeLast());
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(deq.pop() + " ");
		}
	}
}
