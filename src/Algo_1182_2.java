import java.util.Scanner;

public class Algo_1182_2 {
	static int N,S;
	static int res =0;
	static int arr[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		S = in.nextInt();
		arr = new int[N];

		for(int i=0;i<N;i++){
			arr[i] = in.nextInt();
		}
		//bubun();
		dfs(0, 0);
		
		if(S!=0){
			System.out.println(res);
		}
		else{
			System.out.println(res-1);
		}
	}
	public static void bubun(){
		for(int i=0;i<(1<<N);i++){
			int sum =0;
			for(int j=0;j<N;j++){
				if((i&(1<<j)) >0){
					sum+=arr[j];
				}
			}
			if(sum==S){
				res++;
			}
		}
	}
	public static void dfs(int index, int sum){

		if(index == N){
			if(sum==S){
				res++;
			}
			return;
		}

		dfs(index+1,sum+arr[index]);
		dfs(index+1,sum);
	}
}
