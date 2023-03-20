import java.util.*;

class Main {
    static int max = 0;
    static int[] arr;
    static int[] arr2;
    static boolean[] visit;
    static int N;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        arr2 = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        big(N, 0);
        System.out.println(max);
    }

    static void big(int N, int depth) {
        if (depth==N) {
            int temp = 0;
            for (int i = 0; i < N-1; i++) {
                int num1 = arr2[i];
                int num2 = arr2[i + 1];
                temp += Math.abs(num1 - num2);
            }
            if (temp > max) {
                max=temp;
            }
            return;
        } else {
            for (int i = 0; i < N; i++) {
                if (visit[i] == false) {
                    visit[i] = true;
                    arr2[depth] = arr[i];
                    big(N, depth+1);
                    visit[i] = false;
                }
            }
        }
    }
}