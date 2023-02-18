import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			int num = 1;
			int i;
			for (i = 1; num != 0 && N != 1; i++) {
				num = num * 10 + 1;
				num %= N;
			}
			System.out.println(i);
		}
	}
}