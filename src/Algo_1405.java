import java.util.Scanner;

public class Algo_1405 {
	static int N;
	static double arr[];//동 서 남 북
	static int dy[] = {0,0,1,-1,};
	static int dx[] = {1,-1,0,0};
	static boolean visited[][];
	static int cnt = 0;
	static double res =0;

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		arr = new double[4];
		visited = new boolean [2*N+1][2*N+1];
		
		for(int i=0;i<4;i++){
			double tmp = in.nextDouble();
			tmp/=100;
			arr[i] = tmp;
		}
		visited[N][N] = true;
		dfs(N,N,0,1.0);

		System.out.printf("%.10f",res);
	}
	public static void dfs(int y, int x, int depth,double percent){
		//	System.out.println(y+" "+x+" "+depth);
		if(depth == N){
			res += percent;

			return;
		}
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(!visited[ny][nx]){
				visited[ny][nx] = true;
				dfs(ny,nx,depth+1,percent*arr[i]);
				if(!(ny==N && nx==N)){
					visited[ny][nx] =false;
				}
			}
		}
	}
	public static void showVisited(){
		for(int i=0;i<2*N+1;i++){
			for(int j=0;j<2*N+1;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
}

