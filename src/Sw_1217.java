import java.util.Scanner;

public class Sw_1217 {
	static int N,M;
	static int T;
	public static void main(String[]args){
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<10;i++){
			T = in.nextInt();
			N = in.nextInt();
			M = in.nextInt();
			
			System.out.println("#"+T+" "+solution(N,1));
		}
	}
	public static int solution(int N, int m){
		int cnt = m;
		int res = N;
		if(cnt== M){
			return res;
		}
		return N * solution(N, m+1);
	}
}
