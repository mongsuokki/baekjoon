import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            for (int j = 1; j < N-i; j++) System.out.print(" ");
            System.out.print("*");
            if (i>0){
                for(int j=0;j<2*i-1;j++) System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
    }
}