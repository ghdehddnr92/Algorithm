import java.util.Scanner;

public class Algo_11052 {
	static int arr[];
	static int N;
	static int D[];
	public static void main(String[]args){

		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N+1];
		D = new int[N+1];
		for(int i=1;i<=N;i++){
			arr[i] = in.nextInt();
		}		
		solve();
	}
	public static void solve(){
		D[0] = 0;
		for(int i=1;i<=N;i++){
			D[i] =0;
			for(int j=1;j<=i;j++){
				D[i]=Math.max(D[i-j]+arr[j],D[i]);
			}
		}
		System.out.println(D[N]);
	}

}
