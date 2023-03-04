import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int lastindex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        lastindex = 0;
        for (int n = 0; n < N; n++) {
            int cnd = Integer.parseInt(br.readLine());
            if (cnd != 0) {
                arr[++lastindex] = cnd;
                int now = lastindex;
                while (now > 1 && arr[now] < arr[now / 2]) {
                    swap(now, now / 2);
                    now = now / 2;
                }
            } else {
                if (arr[1] != 0) {
                    System.out.println(arr[1]);
                    arr[1] = arr[lastindex];
                    arr[lastindex--] = 0;
                    int now = 1;
                    while (true) {
                        int child = now * 2;
                        if (child + 1 <= lastindex && arr[child] > arr[child + 1]) {
                            child++;
                        }
                        if (child > lastindex || arr[child] > arr[now]) {
                            break;
                        }
                        swap(now, child);
                        now = child;
                    }
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}