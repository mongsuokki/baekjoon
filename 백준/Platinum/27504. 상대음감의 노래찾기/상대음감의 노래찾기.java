import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int[][] arr = new int[N][];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int K = Integer.parseInt(st.nextToken());
			arr[i] = new int[K - 1];
			arr[i][0] += Integer.parseInt(st.nextToken());
			for (int j = 0; j < K - 2; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] -= temp;
				arr[i][j + 1] += temp;
			}
			arr[i][K - 2] -= Integer.parseInt(st.nextToken());
		}
		int L = Integer.parseInt(br.readLine());
		int[] song = new int[L - 1];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		song[0] += Integer.parseInt(st.nextToken());
		for (int i = 0; i < L - 2; i++) {
			int temp = Integer.parseInt(st.nextToken());
			song[i] -= temp;
			song[i + 1] += temp;
		}
		song[L - 2] -= Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			for (int j = arr[i].length - 1; j >= 0; j--) {

			}
		}
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			x: for (int j = L - 2, t = 0; j < arr[i].length;) {
				if (arr[i][j - t] != song[L - 2 - t]) {
					cnt = 0;
					t = 0;
					for (int k = 1; k < L - 1; k++) {
						if (arr[i][j] == song[L - 2 - k]) {
							j += k;
							continue x;
						}
					}
					j += L - 1;
				} else {
					cnt++;
					t++;
				}
				if (cnt == song.length) {
					sb.append((i + 1) + " ");
					break x;
				}
			}
		}
		if (sb.length()==0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}
}
