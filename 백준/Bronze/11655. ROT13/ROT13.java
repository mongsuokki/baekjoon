import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (64 < arr[i] && arr[i] < 78) {
				arr[i] = (char) (arr[i] + 13);
			} else if (77 < arr[i] && arr[i] < 91) {
				arr[i] = (char) (arr[i] - 13);
			} else if (96 < arr[i] && arr[i] < 110) {
				arr[i] = (char) (arr[i] + 13);
			} else if (109 < arr[i] && arr[i] < 123) {
				arr[i] = (char) (arr[i] - 13);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
