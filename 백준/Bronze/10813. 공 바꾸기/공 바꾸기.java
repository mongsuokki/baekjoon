import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt()+1;
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 1; i < N; i++) arr[i] = i;
        for(int i=0;i<M;i++){
            int I = sc.nextInt();
            int J = sc.nextInt();
            int temp = arr[J];
            arr[J] = arr[I];
            arr[I] = temp;
        }
        for(int i = 1; i < N; i++) System.out.print(arr[i]+ " ");
    }
}