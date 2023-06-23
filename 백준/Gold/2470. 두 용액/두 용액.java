import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()),start = 0, end = N-1,min = 2000000000,minA=0,minB=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		while(start != end){
			int A = arr[start], B = arr[end];
			if(A+B<0){
				if(Math.abs(A+B)<min){
					minA = A;
					minB = B;
					min = Math.abs(A+B);
				}
				start++;
			}
			else if (A+B>0){
				if(Math.abs(A+B)<min){
					minA = A;
					minB = B;
					min = Math.abs(A+B);
				}
				end--;
			}else{
				minA = A;
				minB = B;
				break;
			}
		}
		System.out.println(minA+" "+minB);
	}
}