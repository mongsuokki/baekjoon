import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++) {
            int N = sc.nextInt(),ans=0,temp=1;
            int[] arr = new int[N], parr = new int[N];
            for(int i=0;i<N;i++) arr[i] = sc.nextInt()-1;
            for(int i=0;i<N;i++) {
                if(parr[i]!=0) continue;
                int nowi =i,sttemp = temp;
                while(parr[nowi]==0){
                    parr[nowi] = temp++;
                    nowi = arr[nowi];
                }
                if(parr[nowi]>sttemp) ans+=parr[nowi]-sttemp;
                else if(parr[nowi]==sttemp) continue;
                else ans+= temp-sttemp;
            }
            System.out.println(ans);
        }
    }
}