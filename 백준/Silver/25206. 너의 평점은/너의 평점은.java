import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double ans = 0, sum = 0;
		for (int i = 0; i < 20; i++) {
			sc.next();
			double A = sc.nextDouble(), C = 0;
			sum += A;
			switch (sc.next()) {
			case "A+":C = 4.5;break;
			case "A0":C = 4.0;break;
			case "B+":C = 3.5;break;
			case "B0":C = 3.0;break;
			case "C+":C = 2.5;break;
			case "C0":C = 2.0;break;
			case "D+":C = 1.5;break;
			case "D0":C = 1.0;break;
			case "P":sum -= A;break;
			}
			ans += A * C;
		}
		System.out.println(ans / sum);
	}
}