import java.util.*;public class Main {public static void main(String[]z){Scanner s=new Scanner(System.in);int N=s.nextInt(),M=s.nextInt();Deque<Integer> d=new ArrayDeque<>();int c=0;int S=0;for(int i=1;i<N+1;i++){d.add(i);}while(c!=M){int a=0;int n=s.nextInt();while(d.peek()!=n){d.add(d.pop());a++;}if(a<N-a){S+=a;}else{S+=(N-a);}d.pop();N--;c++;}System.out.println(S);}}
