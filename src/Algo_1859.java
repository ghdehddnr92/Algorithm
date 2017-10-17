import java.util.Scanner;

public class Algo_1859 {
	static int N,T;
	static int arr[];
	static long res=0;
	static boolean flag = false; // 계속 감소 할 경우;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		int t=0;
		while(t++<=T){
			N = in.nextInt();
			arr =new int[N];
			
			for(int i=0;i<N;i++){
				arr[i] = in.nextInt();
			}
			int tmp = arr[N-1];
			for(int i= N-2;i>0;i--){
				//if(tmp<arr[i])
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
