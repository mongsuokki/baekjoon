import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] bool;
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt(),C = sc.nextInt();
		arr = new int[R+2][C+2];
		bool = new boolean[27];
 		for(int i=1;i<=R;i++) {
			String temp = sc.next();
			for(int j=0;j<C;j++) {
				arr[i][j+1] = temp.charAt(j)-'A'+1;
			}
		}
		dfs(1,1,0);
		System.out.println(ans+1);
	} static void dfs(int Y, int X, int cnt) {
		if(bool[arr[Y][X]]||arr[Y][X]==0) return;
		if(cnt>ans) ans=cnt;
		bool[arr[Y][X]] = true;
		dfs(Y-1,X,cnt+1);
		dfs(Y,X+1,cnt+1);
		dfs(Y+1,X,cnt+1);
		dfs(Y,X-1,cnt+1);
		bool[arr[Y][X]] = false;
	}
}