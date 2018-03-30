import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_2573 {
	
	static int N,M;
	static int arr[][];
	static int res;
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static int map[][];
	static boolean visited[][];
	
	public static void main(String[]args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true){
			
			res++;
			for(int i=1;i<N;i++){
				for(int j=1;j<M;j++){
					if(arr[i][j]!=0){
						solve(i,j);
					}
				}
			}
			cut();
			
			int cnt =0;
			for(int i=1;i<N;i++){
				for(int j=1;j<M;j++){
					if(arr[i][j]!=0 && !visited[i][j]){
						visited[i][j] = true;
						dfs(i,j);
						cnt++;
						if(cnt==2){
							break;
						}
					}
				}
			}
			boolean flag = true;
			for(int i=1;i<N;i++){
				for(int j=1;j<M;j++){
					if(arr[i][j]!=0){
						flag = false;
					}
				}
			}
			if(flag == true){
				System.out.println(0);
				return;
			}
			if(cnt >= 2){
				break;
			}
			resetVisited();
		}
		System.out.println(res);
	}
	public static void resetVisited(){
		for(int i=1;i<N;i++){
			for(int j=1;j<M;j++){
				visited[i][j] =false;
			}
		}
	}
	public static void cut(){
		for(int i=1;i<N;i++){
			for(int j=1;j<M;j++){
				if(arr[i][j]!=0){
					if(arr[i][j]-map[i][j]>=0){
						arr[i][j]-=map[i][j];
					}
					else{
						arr[i][j] = 0;
					}
				}
			}
		}
	}
	public static void resetMap(){
		for(int i=1;i<N;i++){
			for(int j=1;j<M;j++){
				map[i][j] = 0;
			}
		}
	}
	public static void solve(int y, int x){
		int cnt =0;
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(arr[ny][nx]==0){
				cnt++;
			}
		}
		map[y][x] = cnt;
	}
	public static void showArr(){
		System.out.println("----------------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void dfs(int y, int x){
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0|| nx<0 || ny>=N || nx>=M){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			if(arr[ny][nx]==0){
				continue;
			}
			visited[ny][nx] = true;
			dfs(ny,nx);
		}
	}
}
