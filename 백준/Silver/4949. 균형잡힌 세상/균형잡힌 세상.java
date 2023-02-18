import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x: while (sc.hasNext()) {
			String A = sc.nextLine();
			if (A.equals(".")) {
				break;
			}
			String[] arr = A.split("");
			Stack<String> stc = new Stack<>();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals("(")) {
					stc.push("(");
				} else if (arr[j].equals("[")) {
					stc.push("[");
				} else if (arr[j].equals(")")) {
					if (stc.isEmpty() || !stc.pop().equals("(")) {
						System.out.println("no");
						continue x;
					}
				} else if (arr[j].equals("]")) {
					if (stc.isEmpty() || !stc.pop().equals("[")) {
						System.out.println("no");
						continue x;
					}
				}
			}
			if (stc.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}