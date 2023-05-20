import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();
            System.out.print(C/25+" ");
            C%=25;
            System.out.print(C/10+" ");
            C%=10;
            System.out.print(C/5+" ");
            C%=5;
            System.out.println(C);

        }
    }
}