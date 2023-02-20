import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		student[] arr = new student[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i].name);
		}
	}
}

class student implements Comparable<student> {
	String name;
	int korean;
	int english;
	int math;

	public student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(student A) {
		if (this.korean > A.korean) {
			return -1;
		} else if (this.korean == A.korean) {
			if (this.english < A.english) {
				return -1;
			} else if (this.english == A.english) {
				if (this.math > A.math) {
					return -1;
				} else if (this.math == A.math) {
					return this.name.compareTo(A.name);
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}