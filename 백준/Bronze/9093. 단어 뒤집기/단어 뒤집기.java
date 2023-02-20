import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		Stack<String> stc = new Stack<>();
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String[] arr = sc.nextLine().split("");
			for (int j = 0; j < arr.length; j++) {
				if (" ".equals(arr[j])) {
					while (!stc.isEmpty()) {
						stb.append(stc.pop());
					}
					stb.append(" ");
					continue;
				}
				stc.push(arr[j]);
			}
			while (!stc.isEmpty()) {
				stb.append(stc.pop());
			}
			System.out.print(stb);
			System.out.println();
			stb.setLength(0);
		}
	}
}