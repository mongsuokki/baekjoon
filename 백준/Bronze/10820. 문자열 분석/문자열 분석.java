import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int small = 0, big = 0, num = 0, blank = 0;
			char[] arr = sc.nextLine().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (64 < arr[i] && arr[i] < 91) {
					big++;
				} else if (96 < arr[i] && arr[i] < 123) {
					small++;
				} else if (arr[i] == 32) {
					blank++;
				} else {
					num++;
				}
			}
			System.out.println(small + " " + big + " " + num + " " + blank);
		}
	}
}
