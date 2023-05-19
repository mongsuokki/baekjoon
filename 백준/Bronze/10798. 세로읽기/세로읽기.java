import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[][] arr = new char[5][];
        for(int i=0;i<5;i++){
            arr[i] = sc.next().toCharArray();
        }
        for(int i=0;i<15;i++){
            for (int j = 0; j <5 ; j++) {
                if(arr[j].length>i){
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}