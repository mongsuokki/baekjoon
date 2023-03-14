import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] arr2;
    static int max =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr2);
        dfs(N, M, 0);
        System.out.println(sb);

    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            max =0;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(arr2[i]>=max){
                max = arr2[i];
                arr[depth] = arr2[i];
                dfs(N, M, depth + 1);
            }
        }
    }
}