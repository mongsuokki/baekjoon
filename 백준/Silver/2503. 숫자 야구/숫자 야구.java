import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] num = new String[N];
        int[] str = new int[N];
        int[] bal = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            num[i] = sc.next();
            str[i] = sc.nextInt();
            bal[i] = sc.nextInt();
        }
        for (int i = 123; i < 988; i++) {
            if(i/100 == (i/10)%10|| i/100 == i%10 || (i/10)%10 == i%10||(i/10)%10==0||i%10==0){
                continue;
            }
            String num1 = Integer.toString(i);
            boolean can = true;
            for (int j = 0; j < N; j++) {
                if (strcheck(num1, num[j]) != str[j] || balcheck(num1, num[j]) != bal[j]) {
                    can = false;
                    break;
                }
            }
            if (can) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static int strcheck(String num, String num2) {
        int str = 0;
        for (int i = 0; i < 3; i++) {
            if (num.charAt(i) == num2.charAt(i)) {
                str++;
            }
        }
        return str;
    }

    static int balcheck(String num, String num2) {
        int bal = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==j){
                    continue;
                }
                if (num.charAt(i) == num2.charAt(j)) {
                    bal++;
                }
            }
        }
        return bal;
    }
}