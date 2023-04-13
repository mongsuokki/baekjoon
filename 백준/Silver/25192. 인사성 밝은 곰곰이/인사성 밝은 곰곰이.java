import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),ans=0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            String A = sc.next();
            if(A.equals("ENTER")){
                ans+=set.size();
                set.clear();
            }else set.add(A);
        }
        System.out.println(ans+ set.size());
    }
}