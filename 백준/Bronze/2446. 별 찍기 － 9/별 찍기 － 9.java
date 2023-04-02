import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < 2*N-1; i++) {
            for (int j = 0; j < Math.min(i,2*(N-1)-i); j++) System.out.print(" ");
            for(int j = 0; j < Math.max(2*(i-N+1)+1,2*(N-i)-1); j++) System.out.print("*");
            System.out.println();
        }
    }
}