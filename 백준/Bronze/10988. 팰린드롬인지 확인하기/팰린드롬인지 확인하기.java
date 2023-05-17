import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        boolean B = true;
        for(int i = 0; i <A.length()/2; i++){
            if (A.charAt(i) !=A.charAt(A.length()-i-1)){
                B = false;
                break;
            }
        }
        if(B) System.out.println(1);
        else System.out.println(0);
    }
}