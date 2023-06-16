import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(Integer.parseInt(st.nextToken()));
		for(int i = 1; i < N; i++){
			int temp = Integer.parseInt(st.nextToken());
			if(temp > list.get(list.size() - 1)) list.add(temp);
			else binarySearch(list,temp);
		}
		System.out.println(list.size());
	}
	public static void binarySearch(List<Integer> A, int key) {
		int n = A.size(),start = 0,end = n-1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(A.get(middle) == key) return;
			else if(A.get(middle) > key) end = middle - 1;
			else start = middle + 1;
		}
		A.set(start, key);
	}
}