import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			long N = sc.nextLong();
			if (N==0||N==1) {
				System.out.println(1 + " " + 0);
			} else {
				System.out.println(0 + " "+ 1);
			}
		}
	}
}