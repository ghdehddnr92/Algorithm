import java.util.Scanner;

public class Algo_10026 {
	static int N;
	static String arr[][];
	static int aCnt, bCnt;
	static boolean visited[][];
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		arr = new String[N][N];
		visited = new boolean[N][N];

		for(int i=0;i<N;i++){
			String line = in.next();
			for(int j=0;j<N;j++){
				arr[i][j] = line.charAt(j)+"";
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]){
					visited[i][j] = true;
					dfs(i,j);
					aCnt++;
				}
			}
		}
		System.out.print(aCnt+" ");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j]= false;
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]){
					visited[i][j] = true;
					dfs2(i,j);
					bCnt++;
				}
			}
		}
		System.out.println(bCnt);
	}
	public static void dfs(int y, int x){

		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx< 0 || ny>=N || nx>=N){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			if(!arr[ny][nx].equals(arr[y][x])){
				continue;
			}

			visited[ny][nx]= true;
			dfs(ny,nx);
		}
	}
	public static void dfs2(int y, int x){

		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx< 0 || ny>=N || nx>=N){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}

			if(arr[y][x].equals("B")){
				if(!arr[ny][nx].equals(arr[y][x])){
					continue;
				}
			}
			else{
				if(arr[ny][nx].equals("B")){
					continue;
				}
			}

			visited[ny][nx]= true;
			dfs2(ny,nx);
		}
	}

}
