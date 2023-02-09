import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		x: for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			char[] charr = sc.next().toCharArray();
			int M = sc.nextInt();
			String str = sc.next().replace("[", "").replace("]", "");
			String[] arr = str.split(",");
			int R = 0;
			int cnt = M;
			Deque<String> dec = new LinkedList<>();
			for (int j = 0; j < M; j++) {
				dec.add(arr[j]);
			}
			for (int l = 0; l < charr.length; l++) {
				if (charr[l] == 'R') {
					R = 1 - R;
				} else {
					cnt--;
					if (cnt < 0) {
						System.out.println("error");
						continue x;
					} else if (R == 0) {
						dec.poll();
					} else {
						dec.pollLast();
					}
				}
			}
			sb.append("[");
			int O = dec.size() - 1;
			if (O == -1) {
				System.out.println("[]");
				continue x;
			}
			if (R == 0) {
				for (int j = 0; j < O; j++) {
					sb.append(dec.poll() + ",");
				}
				sb.append(dec.poll());
			} else {
				for (int j = 0; j < O; j++) {
					sb.append(dec.pollLast() + ",");
				}
				sb.append(dec.pollLast());
			}
			sb.append("]");
			System.out.println(sb);
		}
	}
}
