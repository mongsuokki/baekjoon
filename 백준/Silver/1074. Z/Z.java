import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int ans = c + 2 * r;
        for (int i = 1; i < N; i++) {
            ans += (c / (int) Math.pow(2, i)) * (int) Math.pow(2, 2 * i - 1) + (r / (int) Math.pow(2, i)) * (int) Math.pow(2, 2 * i);
        }
        System.out.println(ans);
    }
}