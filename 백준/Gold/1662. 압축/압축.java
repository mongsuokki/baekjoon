import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String S = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int ans =0,cnt=0;
        int[] sh = new int[26];
        Stack<Character> stc = new Stack<>();
        for(int i=0;i<S.length();i++){
            stc.push(S.charAt(i));
            if(stc.peek()==')'){
                stc.pop();
                while(stc.pop()!='(') sh[cnt]++;
                sh[cnt-1] +=sh[cnt]*(stc.pop()-'0');
                sh[cnt--] = 0;
            }else if (stc.peek()=='(') cnt++;
        }
        System.out.println(sh[0]+stc.size());
    }
}