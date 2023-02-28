import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String start="";
		Queue<String> que = new LinkedList<>();
		for (int i = 0; i < N-1; i++) {
			que.add("?");
		}
		sc.nextInt();
		que.add(sc.next());
		for(int i=1;i<K;i++) {
			int S = sc.nextInt();
			if(S>=N) {
				S=S%N;
			}
			for(int j=0;j<N-S-1;j++) {
				que.add(que.poll());
			}
			
			String temp = sc.next();
			String A = que.poll();
			if(!A.equals("?")&&!A.equals(temp)) {
				System.out.println("!");
				System.exit(0);
			}
			if(i==K-1) {
				start = temp;
			}
			que.add(temp);
		}
		while(!que.peek().equals(start)) {
			que.add(que.poll());
		}
		start="";
		for(int i=0;i<N;i++) {
			String A = que.poll();
			if(!A.equals("?")&&start.contains(A)) {
				System.out.println("!");
				System.exit(0);
			}
			start+=A;
		}
		System.out.println(start);
	}
}