import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        A = br.readLine();
        st = new StringTokenizer(A);
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i>0){
                arr[i]+=arr[i-1];
            }
        }
        for(int i = 0; i < M; i++){
            A = br.readLine();
            st = new StringTokenizer(A);
            int a = Integer.parseInt(st.nextToken())-2;
            int b = Integer.parseInt(st.nextToken())-1;
            if(a<0){
                System.out.println(arr[b]);
            }else{
            System.out.println(arr[b]-arr[a]);
            }
        }
    }
}