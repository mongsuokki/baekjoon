import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < M; i++) {
            int I = sc.nextInt()-1, J=sc.nextInt()-1,K=sc.nextInt();
            for(int j=I;j<=J;j++) arr[j] = K;
        }
        for(int i = 0; i < N; i++) System.out.print(arr[i]+" ");
    }
}