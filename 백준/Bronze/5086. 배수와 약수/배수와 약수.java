import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int N = sc.nextInt(),M = sc.nextInt();
            if(N==M&&N==0) break;
            if(N/M>0&&N%M==0) System.out.println("multiple");
            else if(M/N>0&&M%N==0) System.out.println("factor");
            else System.out.println("neither");
        }
    }
}