import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			String A = bf.readLine();
			map.put(A, i+1);
			arr[i] = A;
		}
		for (int i = 0; i < M; i++) {
			String A = bf.readLine();
			if (47 < A.charAt(0) && A.charAt(0) < 58) {
				sb.append(arr[Integer.parseInt(A)-1]+ "\n");
			} else {
				sb.append(map.get(A) + "\n");
			}
		}
		System.out.println(sb);
	}
}