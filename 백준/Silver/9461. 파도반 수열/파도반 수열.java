
import java.util.*;

class Main {
    static long[] arr = new long[101];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            System.out.println(pado(sc.nextInt()));
        }
    } static long pado(int N){
        if(arr[N]==0){
        if(N==1||N==2||N==3){
            arr[N] = 1;
        }else if(N==4||N==5){
            arr[N] = 2;
        }else{
            arr[N] = pado(N-1)+pado(N-5);
        }
        }
        return arr[N];
    }
}