import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
//DFS로 구현 
public class Sw_3234 {
	static int T;
	static int N;
	static int arr[];
	static int tmp[];
	static boolean visited[];
	static boolean visited2[];
	static int leftSum;
	static int rightSum;
	static int result;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){

			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			tmp = new int[N];
			visited = new boolean[N];
			visited2 = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0);
			System.out.println("#"+t+" "+result);
			result=0;
		}
	} 

	public static void dfs(int index){
		
		if(index == N){
			dfs2(N,0); // 왼 오 배치 
			return;
		}
		for(int i=0;i<N;i++){	
			if(!visited[i]){
				tmp[index] = arr[i];
				visited[i] =true;
				dfs(index+1);
				visited[i] = false;
			} 
		}
	}
	public static void dfs2(int n, int depth){

		if(n==depth){
			for(int i=0;i<N;i++){
				if(visited2[i] == true){
					leftSum+=tmp[i];
				}
				else{
					if(leftSum< tmp[i]+rightSum){
						leftSum=0;
						rightSum=0;
						return;
					}
					else{
						rightSum+=tmp[i];
					}
				}
			}
			if(leftSum>=rightSum){
				result++;
			}
		
			leftSum=0;
			rightSum=0;
			
			return;
		}
		visited2[depth] = true;
		dfs2(n,depth+1);
		visited2[depth] = false;
		dfs2(n,depth+1);
	}
}
