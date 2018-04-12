import java.util.Scanner;

public class Algo_1952 {
	static int N, M;
	
	static boolean visited[][]; 
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		M = in.nextInt();
		N = in.nextInt();

		visited = new boolean[M][N];
		visited[0][0]= true;
		
		int y =0;
		int x =0;
		int dir =0;
		
		while(!check()){
			int ny = y+dy[dir%4];
			int nx = x+dx[dir%4];
			
			if(ny<0|| nx<0|| ny>=M || nx>=N){
				dir++;
				continue;
			}
			if(visited[ny][nx]){
				dir++;
				continue;
			}
			visited[ny][nx] =true;
			y = ny;
			x = nx;
		//	showVisited();
		}
		System.out.println(dir);
	}
	public static boolean check(){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	public static void showVisited(){
		System.out.println("------------------");
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
