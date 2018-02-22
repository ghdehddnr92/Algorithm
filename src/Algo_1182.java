import java.util.Scanner;

public class Algo_1182 {
	static int N,S;
	static int arr[];
	static int cnt = 0;
	static int sum = 0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N= in.nextInt();
		S= in.nextInt();
		
		arr =new int[N];
		
		for(int i=0;i<N;i++){
			arr[i]= in.nextInt();
		}
		dfs(0);
		
		System.out.println(cnt);
	}
	public static void dfs(int index){
		if(index == N){
			return;
		}
		
		if(sum+arr[index] == S){
			cnt++;
		}
		
		dfs(index+1); // 원소를 포하시키지 않고 시도 
		
		sum+=arr[index];
		dfs(index+1); //더하고시도 
		
		sum -= arr[index];
	}
}
