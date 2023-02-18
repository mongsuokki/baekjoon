import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		String C= A.replaceAll(B, "");
		System.out.println((A.length()-C.length())/B.length());
	}
}
