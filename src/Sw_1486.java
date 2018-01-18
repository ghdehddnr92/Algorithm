import java.util.Scanner;

public class Sw_1486 {
	static int N,T,B;
	static int arr[];
	static int min = Integer.MAX_VALUE;
	static boolean visited[];
	static int sum =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N =in.nextInt();
			B = in.nextInt();
			visited = new boolean[N];
			arr = new int[N];
			for(int i=0;i<N;i++){
				arr[i] = in.nextInt();
			}

			solve(N,0);
			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
		}
	}
	public static void solve(int n, int index){
		if(n == index){
			for(int i= 0;i<n;i++){
				if(visited[i] == true){
					sum+= arr[i];
				}
			}

			if(sum>=B){
				if(min >= sum-B){
					min = sum - B;
				}
			}
			sum=0;
			return;
		}

		visited[index] = true;
		solve(n,index+1);
		visited[index] = false;
		solve(n,index+1);
	}
}
