import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String[] arr = sc.next().split("");
		int N = sc.nextInt();
		Deque<String> deq = new ArrayDeque<>();
		deq.add(" ");
		for (int i = 0; i < arr.length; i++) {
			deq.add(arr[i]);
		}
		for (int i = 0; i < N; i++) {
			String A = sc.next();
			if (A.equals("L")) {
				if (deq.peekLast().equals(" ")) {
					continue;
				}
				deq.push(deq.pollLast());
			} else if (A.equals("D")) {
				if (deq.peek().equals(" ")) {
					continue;
				}
				deq.add(deq.poll());
			} else if (A.equals("P")) {
				deq.add(sc.next());
			} else {
				if (deq.peekLast().equals(" ")) {
					continue;
				}
				deq.pollLast();
			}
		}
		while (!deq.getFirst().equals(" ")) {
			deq.add(deq.poll());
		}
		deq.poll();
		int M = deq.size();
		for (int i = 0; i < M; i++) {
			sb.append(deq.poll());
		}
		System.out.println(sb.toString());
	}
}