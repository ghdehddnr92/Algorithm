import java.util.Scanner;

public class Sw_3459 {
	static int T;
	static long N;
	static String res;
	static long x =1;
	static int turn = 1; // 1 ALICE -1 Bob
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T =in.nextInt();
		
		for(int t=1;t<=T;t++){
			N = in.nextLong();
		
			solve();
			
			if(turn == -1){
				res = "Alice";
			}
			else{
				res = "Bob";
			}
			System.out.println("#"+t+" "+res);
			x =1;
			turn =1;
		}
	}
	public static void solve(){
		while(x<=N){
			
			if((2*x)+1<=N){
				x = (2*x)+1;
				turn *= -1;
			}
			else{
				if(2*x<=N){
					x = (2*x);
					turn *= -1;
				}
				else{
					return;
				}
			}
			System.out.println("x :"+x+" turn: "+turn);
		}
	}
}
