import java.util.*;

class Main {
	static int[] p;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(),E = sc.nextInt();
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		Arrays.sort(edges, (int[] o1, int[] o2) -> o1[2] - o2[2]);
		p = new int[V+1];
		for (int i = 1; i <= V; i++) p[i] = i;
		int ans = 0,pick = 0;
		for (int i = 0; i < E; i++) {
			int px = findset(edges[i][0]),py = findset(edges[i][1]);
			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			if (pick == V-2) break;
		}
		if(E == 1) ans = 0;
		System.out.println(ans);
	}

	static int findset(int x) {
		if (x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}
}