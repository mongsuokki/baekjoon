import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String A = st.nextToken();
			if (A.equals("push")) {
				deq.add(Integer.parseInt(st.nextToken()));
			} else if (A.equals("size")) {
				bw.write(deq.size() + "\n");
			} else if (A.equals("pop")) {
				if (deq.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deq.poll() + "\n");
				}
			} else if (A.equals("empty")) {
				if (deq.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (A.equals("front")) {
				if (deq.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deq.getFirst() + "\n");
				}
			} else if (A.equals("back")) {
				if (deq.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(deq.getLast() + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}