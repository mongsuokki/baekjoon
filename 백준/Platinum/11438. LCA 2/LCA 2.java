import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int K=0;
	static int[][] parents;
	static int[] depths;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int i=1;i<=N;i++) tree[i] = new ArrayList<>();
		for(int i=1;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()),B = Integer.parseInt(st.nextToken());
			tree[A].add(B);
			tree[B].add(A);
		}
		int tmp = 1;
		while (tmp < N + 1) {
			tmp <<= 1;
			K++;
		}
		depths = new int[N+1];
		parents = new int[N+1][K];
		dfs(1,1);
		for (int i = 1; i < K; i++) {
			for (int j = 1; j <= N; j++) {
				parents[j][i] = parents[parents[j][i - 1]][i - 1];
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()),B = Integer.parseInt(st.nextToken());
			bw.write(lca(A,B)+"\n");
		}
		bw.flush();
	} public static void dfs(int now, int depth){
		depths[now] = depth;
		for(int next: tree[now]) {
			if(depths[next] == 0) {
				dfs(next, depth+1);
				parents[next][0] = now;
			}
		}
	}public static int lca(int a,int b){
		if (depths[a] < depths[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
			for (int i = K - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depths[a] - depths[b]) {
				a = parents[a][i];
			}
		}
		if (a == b) return a;
		for(int i=K-1;i>=0;i--){
			while(parents[a][i] != parents[b][i]){
				a = parents[a][i];
				b = parents[b][i];
			}
		}
		return parents[a][0];
	}
}
