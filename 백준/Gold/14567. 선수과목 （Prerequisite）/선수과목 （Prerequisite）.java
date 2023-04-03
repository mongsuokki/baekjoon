import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        int[] ans = new int[N+1];
        ArrayList<Integer>[] map = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            map[start].add(end);
            arr[end]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            if (arr[i]==0) {
                que.add(i);
                ans[i]++;
            }
        }
        while(!que.isEmpty()) {
            int num = que.poll();
            for(int temp : map[num]) {
                arr[temp]--;
                if(arr[temp]==0) {
                    que.add(temp);
                    ans[temp] = Math.max(ans[temp],ans[num]+1);
                }
            }
        }
        for(int i=1;i<=N;i++){
            System.out.print(ans[i]+" ");
        }
    }
}