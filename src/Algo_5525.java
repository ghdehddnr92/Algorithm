import java.util.Scanner;

public class Algo_5525{
	static int N,M;
	static String S;
	static int res = 0;
	static int cnt = 0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		M = in.nextInt();
		S = in.next();

		solve();

		System.out.println(res);
	}
	public static void solve(){
		for(int i=0;i<M-2;i++){
			//System.out.println("i"+i);
			if(S.charAt(i)=='I' && S.charAt(i+1)=='O' && S.charAt(i+2)=='I'){
				//System.out.println("zzzzz:"+i);
				cnt++;
				i++;
				//System.out.println("첫 :"+cnt+" "+i);
			}
				//System.out.println("hi");
				if(cnt >= N){
					//System.out.println("cnt:"+cnt);
					res += cnt - N+1;
				//	System.out.println(res);
				}
				cnt = 0;
	
		}
	}
}

