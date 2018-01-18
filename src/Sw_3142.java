import java.util.Scanner;

public class Sw_3142 {
	static int N,M,T;
	static int a,b;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();

			solve();
			
			System.out.println("#"+t+" "+b+" "+a);
		}
	}
	public static void solve(){	
		a = N-M;
		b = M-a;
	}
}
