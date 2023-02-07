import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] ar1, int[] ar2) {
				if (ar1[0] == ar2[0]) {
					return ar1[1] - ar2[1];
				} else {
					return ar1[0] - ar2[0];
				}
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
