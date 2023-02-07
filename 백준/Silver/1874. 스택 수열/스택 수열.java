import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stc = new Stack<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int i = 1;
		while (i <= N || !stc.isEmpty()) {
			if (M > i) {
				stc.push(i);
				i++;
				sb.append("+\n");
			} else if (M == i) {
				stc.push(i);
				i++;
				sb.append("+\n");
				stc.pop();
				sb.append("-\n");
				if (i>N && stc.isEmpty()) {
					break;
				}
				M = sc.nextInt();
			} else {
				int O = stc.peek();
				if (O == M) {
					stc.pop();
					sb.append("-\n");
				} else {
					while (O != M) {
						stc.pop();
						sb.append("-\n");
						if (O > M) {
							System.out.println("NO");
							System.exit(0);
						}
						if (stc.isEmpty()) {
							break;
						}
						O = stc.peek();
					}
				}
				if (i < N + 1) {
					M = sc.nextInt();
				}
			}
		}
		System.out.println(sb.toString());
	}
}
