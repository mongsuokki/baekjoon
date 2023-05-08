import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),ans=1;
        Set<String> set = new HashSet<String>();
        set.add("ChongChong");
        for(int i = 0; i < N; i++){
            String A = sc.next(), B = sc.next();
            if(set.contains(A)&&!set.contains(B)) {
                set.add(B);
                ans++;
            }
            if(set.contains(B)&&!set.contains(A)){
                set.add(A);
                ans++;
            }
        }
        System.out.println(ans);
    }
}