import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()),max =0;
		Long ans = 0L;
		jewel[] jewels = new jewel[N];
		int[] bags = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i]=new jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<K;i++) bags[i]=Integer.parseInt(br.readLine());
		Arrays.sort(jewels,(o1, o2) -> {
			if (o2.M != o1.M) {
				return o1.M - o2.M;
			} else {
				return o2.V - o1.V;
			}
		});
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0,j=0;i<K;i++){
			while(j<N && jewels[j].M <= bags[i]) pq.add(jewels[j++].V);
			if (!pq.isEmpty()) ans+=pq.poll();
		}
		System.out.println(ans);
	}

	static class jewel {
		int M;
		int V;

		public jewel(int m, int v) {
			M = m;
			V = v;
		}
	}
}
