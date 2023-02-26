import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stc = new Stack<>();
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] arr = { num, 1 };
			if (stc.isEmpty()) {
				stc.add(arr);
			} else {
				int size = stc.size();
				for (int j = size - 1; j >= 0; j--) {
					if (stc.get(j)[0] > num) {
						ans++;
						break;
					} else if (stc.get(j)[0] == num) {
						arr[1] += stc.get(j)[1];
						ans += stc.pop()[1];
					} else {
						ans += stc.pop()[1];
					}
				}
				stc.add(arr);
			}
		}
		System.out.println(ans);
	}
}