import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();
        BigInteger NM = N.subtract(M);
        BigInteger ans = new BigInteger("1");
        BigInteger div = new BigInteger("1");
        BigInteger one = new BigInteger("1");
        for(;!N.equals(NM);){
            ans = ans.multiply(N);
            N=N.subtract(one);
        }
        for(;!M.equals(one);){
            div = div.multiply(M);
            M=M.subtract(one);
        }
        System.out.println(ans.divide(div));
    }
}