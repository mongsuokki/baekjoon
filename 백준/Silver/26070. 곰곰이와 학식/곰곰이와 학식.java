import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][3];
        long ans=0;
        for(int i=0;i<2;i++) for (int j = 0; j < 3; j++) arr[i][j] = sc.nextInt();
        for(int i = 0; i < 5; i++) if (arr[0][i%3] < arr[1][i%3]) arr[1][(i+1)%3]+=(arr[1][i%3]-arr[0][i%3])/3;
        for(int i=0;i<3;i++) ans+=Math.min(arr[0][i],arr[1][i]);
        System.out.println(ans);
    }
}