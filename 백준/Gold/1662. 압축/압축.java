import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int ans =0,cnt=0;
        int[] slash = new int[26];
        Stack<Character> stc = new Stack<>();
        for(int i=0;i<S.length();i++){
            stc.push(S.charAt(i));
            if(stc.peek()==')'){
                stc.pop();
                while(stc.pop()!='('){
                    slash[cnt]++;
                }
                slash[cnt-1] +=slash[cnt]*(stc.pop()-'0');
                slash[cnt--] =0;
            }else if (stc.peek()=='(') cnt++;
        }
        System.out.println(slash[0]+stc.size());
    }
}