import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int T = 1;
		for (int i = 0; i < K; i++) {
			T *= 2;
		}
		T--;
		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = K; i > 0; i--) {
			for (int j = (int)Math.pow(2, i-1)-1; j < T; j+=(int)Math.pow(2, i)) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}
}
