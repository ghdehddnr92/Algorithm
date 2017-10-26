import java.util.Scanner;

public class Algo_1916 {
	static int N;
	static int M;
	static int arr[][];
	static int a;
	static int b;
	static int start, end;
	static boolean visited[];
	static int min = 999999;
	static int res=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		M = in.nextInt();
		
		arr =new int[N+1][N+1];
		
		for(int m=0;m<M;m++){
			a = in.nextInt();
			b = in.nextInt();
			arr[a][b]=in.nextInt();
		}
		
		start = in.nextInt();
		end = in.nextInt();
		
		DFS(start);
		
		System.out.println("");
		System.out.println(min);
	}
	public static void DFS(int start){

		if(start == end){
			System.out.println("도착했을 때 값 "+res);
			if(res<min){
				min = res;
			}
			res =0; 
			return;
		}
		for(int i=1;i<=N;i++){
			if(arr[start][i]!=0){
				res+=arr[start][i];
				System.out.println("start :"+start+" i :"+i+" res +" +res);
				DFS(i);
			}
		}
		
	}
	public static void showArr(){
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
