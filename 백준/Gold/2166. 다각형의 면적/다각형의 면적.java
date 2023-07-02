import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Double ans= 0.0;
		Long[] arr = new Long[2*(N+1)];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			arr[2*i] = (long) Integer.parseInt(st.nextToken());
			arr[2*i+1] = (long) Integer.parseInt(st.nextToken());
		}
		arr[2*N] = arr[0];
		arr[2*N+1] = arr[1];
		for (int i=0;i<N;i++){
			ans+=arr[2*i] * arr[2*(i+1)+1];
			ans-=arr[2*i+1] * arr[2*(i+1)];
		}
		System.out.println(String.format("%.1f",Math.abs(ans)/2));
	}
}
