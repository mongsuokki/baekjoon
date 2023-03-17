import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i < 2 * N ; i++) {
            for (int j = 0; j < Math.abs(N - i); j++) {
                System.out.print(" ");
            }
            if (i > N) {
                for (int j = 2*i; j <4*N-1; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < 2*i-1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}