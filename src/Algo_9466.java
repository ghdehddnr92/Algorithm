import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_9466 {
	static int T;
	static int arr[];
	static int N;
	static int res =0;
	static int start, end;
	static boolean visited[];
	static boolean finished[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			arr = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			
			for(int i=1;i<=N;i++){
				arr[i] = in.nextInt();
			}
			for(int i=1;i<=N;i++){
				if(visited[i]==false){
					dfs(i);
				}
			}

			System.out.println(N-res);
			res =0;
		}
	}
	public static void dfs(int i){
		visited[i] =true;
		if(!visited[arr[i]]){
			dfs(arr[i]);
		}
		else{
			if(!finished[arr[i]]){
				int tmp = arr[i];
				while(tmp!=i){
					tmp=arr[tmp];
					res++;
				}
				res++;
			}
		}
		finished[i] = true;
	}
}
