import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 4; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			if (y1 > q2 || p1 < x2 || q1 < y2 || x1 > p2) {
				System.out.println("d");
			} else if (x1 == x2 && y1 == y2) {
				System.out.println("a");
			} else if (p1 == x2 || q1 == y2 || p2 == x1 || q2 == y1) {
				if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || (p1 == x2 && y1 == q2)
						|| (x1 == p2 && y1 == q2)) {
					System.out.println("c");
				} else {
					System.out.println("b");
				}
			} else {
				System.out.println("a");
			}
		}
	}
}
