import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine()),ans=0,temp=1;
            int[] arr = new int[N], parr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken())-1;
            for(int i=0;i<N;i++) {
                if(parr[i]!=0) continue;
                int ni =i,temp2 = temp;
                while(parr[ni]==0){
                    parr[ni] = temp++;
                    ni = arr[ni];
                }
                if(parr[ni]>temp2) ans+=parr[ni]-temp2;
                else if(parr[ni]==temp2) continue;
                else ans+= temp-temp2;
            }
            System.out.println(ans);
        }
    }
}