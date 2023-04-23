import java.util.*;

class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        for(int i = 1; i < 2*N; i++){
            for(int j = 0; j < Math.min(i,2*N-i); j++) System.out.print("*");
            System.out.println();
        }
    }
}