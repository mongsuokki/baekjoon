import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int min = Math.abs(N - 100);
        int ans = 0;
        boolean[] btn = new boolean[10];
        for (int i = 0; i < M; i++) {
            btn[sc.nextInt()] = true;
        }
        for (; ans < min; ans++) {
            char[] nup = Integer.toString(N + ans).toCharArray();
            boolean chk = true;
            if (N - ans >= 0) {
                char[] ndown = Integer.toString(N - ans).toCharArray();
                for (int j = 0; j < ndown.length; j++) {
                    if (btn[ndown[j]-'0'] == true) {
                        chk = false;
                        break;
                    }
                }
                if (chk) {
                    ans+=ndown.length;
                    break;
                }
            }
            chk=true;
            for (int j = 0; j < nup.length; j++) {
                if (btn[nup[j]-'0'] == true) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                ans+=nup.length;
                break;
            }
        }
        if (ans < min) {
            System.out.println(ans);
        } else {
            System.out.println(min);
        }
    }
}