import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int Ey = 1;
		int S = sc.nextInt();
		int Sy = 1;
		int M = sc.nextInt();
		int My = 1;
		int ans = 1;
		for (; E != Ey || S != Sy || M != My; ans++) {
			Ey++;
			Sy++;
			My++;
			if (Ey > 15) {
				Ey = 1;
			}
			if (Sy > 28) {
				Sy = 1;
			}
			if (My > 19) {
				My = 1;
			}
		}
		System.out.println(ans);
	}
}