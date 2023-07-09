import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long[] tree,arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		tree = new long[4*N];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Long.parseLong(st.nextToken());
		}
		make(N);
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				long temp = Long.parseLong(st.nextToken()),diff = temp-arr[b];
				arr[b] = temp;
				change(1,1,N,b,diff);
			} else {
				int c = Integer.parseInt(st.nextToken());
				sb.append(sum(1,1,N,b,c)+"\n");
			}
		}
		System.out.println(sb);
	}static void make(int N){
		int treeHeight = (int)Math.ceil(Math.log(N)/Math.log(2))+1;
		int treeNodeCount = 2<<treeHeight;
		tree = new long[treeNodeCount];
		set(1,1,N);
	}
	static long set(int node, int start, int end){
		int mid = (start + end)/2;
		if(start == end) {
			tree[node] = arr[start];
			return tree[node];
		}
		tree[node] = set(node*2, start, mid) + set(node*2+1, mid+1, end);
		return tree[node];
	}static long sum(int node, int start, int end, int left, int right){
		int mid = (start + end)/2;
		if (end < left || right < start) return 0;
		else if (left <= start && end <= right) return tree[node];
		else return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
	}static void change(int node, int start,int end, int index, long diff){
		int mid = (start + end)/2;
		if (index >= start && end >= index) {
			tree[node] = tree[node] + diff;
			if (start != end) {
				change(node*2, start, mid, index, diff) ;
				change(node*2+1, mid+1, end, index, diff) ;
			}
		}
	}

}
