import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] depths,parents;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		depths = new int[N+1];
		parents = new int[N+1];
		for(int i=1;i<=N;i++) tree[i] = new ArrayList<Integer>();
		for(int i=0;i<N-1;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()),B = Integer.parseInt(st.nextToken());
			tree[A].add(B);
			tree[B].add(A);
		}
		dfs(1,0,0);
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()),B = Integer.parseInt(st.nextToken());
			System.out.println(lca(A,B));
		}

	} public static void dfs(int now, int depth, int parent){
		depths[now] = depth;
		parents[now] = parent;
		for(int next: tree[now]) if(next != parent) dfs(next, depth+1,now);
	}public static int lca(int a,int b){
		int adep = depths[a], bdep = depths[b];
		while(adep != bdep){
			if(adep>bdep) {
				a = parents[a];
				adep--;
			}else{
				b = parents[b];
				bdep--;
			}
		}
		while(a!=b){
			a = parents[a];
			b = parents[b];
		}
		return a;
	}
}
