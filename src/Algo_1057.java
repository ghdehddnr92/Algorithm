import java.util.Scanner;

public class Algo_1057 {
	static int N,a,b;
	static int cnt=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();
	
		while(a!=b){
			a=a/2+a%2;
			b=b/2+b%2;
			cnt++;
		}
		System.out.println(cnt);
	}
}
