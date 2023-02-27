import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		StringTokenizer st = new StringTokenizer(A);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long height = 0;
		long sum = 0;
		int tree = 0;
		int[] arr = new int[N + 1];
		String B = br.readLine();
		st = new StringTokenizer(B);
		arr[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = N; sum < M && i > 0; i--) {
			height = arr[i - 1];
			tree = N + 1 - i;
			sum += (arr[i] - height) * tree;
		}
		while (sum - M >= tree) {
			sum -= tree;
			height++;
		}
		if (N == 1) {
			height = arr[1] - M;
		}
		System.out.println(height);
	}
}