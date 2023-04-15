import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        long K = sc.nextInt(),max=0;
        int[] pi = new int[S.length()];
        int j = 0;
        for(int i=1; i<S.length(); i++) {
            while(j > 0 && S.charAt(i) != S.charAt(j)) j = pi[j-1];
            if(S.charAt(i) == S.charAt(j)) pi[i] = ++j;
        }
        System.out.println(S.length()+(S.length()-pi[S.length()-1])*(K-1));
    }
}