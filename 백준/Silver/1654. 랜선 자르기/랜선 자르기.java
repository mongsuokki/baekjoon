import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long start = 0;
        long end = 0;
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            if (num > end) {
                end = num;
            }
        }
        end++;
        long cnt = 0;
        long middle;
        while (start < end) {
            cnt = 0;
            middle = (start + end) / 2;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / middle;
            }
            if (cnt < N) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        System.out.println(start-1);
    }
}