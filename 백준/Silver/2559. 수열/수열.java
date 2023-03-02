import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max =Integer.MIN_VALUE;
        A = br.readLine();
        st = new StringTokenizer(A);
        int[] arr = new int[N-K+1];
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            int j= i-K+1;
            if(j<0){
                j=0;
            }
            for(;j<N-K+1&&j<=i; j++){
                arr[j]+=num;
            }
        }
        for(int i = 0; i < N-K+1; i++){
           if(arr[i]>max){
               max = arr[i];
           }
        }
        System.out.println(max);
    }
}