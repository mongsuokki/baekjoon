import java.util.*;
	class study{
		int S,T;
		study(int S, int T) {
		    this.S = S;
				this.T = T;
		}
	}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		study[] studies = new study[N];
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		for(int i = 0; i < N; i++) studies[i] = new study(sc.nextInt(), sc.nextInt());
		Arrays.sort(studies, (o1, o2) -> {
			if(o1.S == o2.S) return o1.T - o2.T;
			else return o1.S - o2.S;
		});
		que.add(studies[0].T);
		for(int i = 1; i < N; i++){
			if(que.peek() <= studies[i].S) que.poll();
			que.add(studies[i].T);
		}
		System.out.println(que.size());
	}
}