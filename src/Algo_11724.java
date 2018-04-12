import java.util.Scanner;

public class Algo_11724 {
	static int N,M;
	static int arr[][];
	static boolean visited[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		arr= new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++){
			int y = in.nextInt();
			int x = in.nextInt();
			arr[y][x] = arr[x][y]= 1;
		}
		//showArr();
		int cnt =0;
		for(int i=1;i<=N;i++){
			if(!visited[i]){
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	public static void dfs(int x){
		visited[x] = true;
		
		for(int j=1;j<=N;j++){
			if(arr[x][j]==1 && !visited[j]){
			//	System.out.println(x+" "+j+"로 이동 ");
				dfs(j);
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
