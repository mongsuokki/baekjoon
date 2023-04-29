import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<number> que = new PriorityQueue<>((o1, o2) ->o1.num-o2.num);
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        que.add(new number(0,Integer.parseInt(st.nextToken())));
        for(int i = 1; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            while(!que.isEmpty()&&temp>que.peek().num) ans[que.poll().where] = temp;
            que.add(new number(i,temp));
        }
        for(int i = 0; i < N; i++){
            if(ans[i]==0) sb.append(-1+" ");
            else sb.append(ans[i]+" ");
        }
        System.out.println(sb);
    } static class number{
        int where;
        int num;
        public number(int where, int num) {
            this.where = where;
            this.num = num;
        }
    }
}