import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(div(sc.nextLong(),sc.nextLong(),sc.nextLong()));

    } static long div(long A,long B,long C){
        if(B==1){
           return A%C;
        }
        if(B%2==0){
            long temp = div(A,B/2,C)%C;
            return (temp*temp)%C;
        }else{
            long temp = div(A,(B-1)/2,C)%C;
            return ((temp*temp)%C*A)%C;
        }
    }
}