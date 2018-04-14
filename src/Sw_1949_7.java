import java.util.Scanner;

public class Sw_1949_7 {
	static int T, N ,K;
	static int arr[][];
	static int max =0;
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	static boolean visited[][];
	static int maxHigh =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T =in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			K = in.nextInt();

			arr = new int[N][N];
			visited =new boolean[N][N];

			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					arr[i][j] = in.nextInt();
					maxHigh = Math.max(arr[i][j], maxHigh);
				}
			}

			solve();

			System.out.println("#"+t+" "+max);
			max =0; 
			maxHigh =0;
		}	
	}
	public static void solve(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j]==maxHigh){
					//System.out.println("봉우리 위치 :"+i+" "+j);
					for(int a=0;a<N;a++){
						for(int b=0;b<N;b++){
							if(a!=i || b!=j){
								for(int k=0;k<=K;k++){
									visited[i][j] = true;
									int tmp = arr[a][b];
									if(arr[a][b]-k>=0){
										arr[a][b]-=k;
									}
									else{
										arr[a][b]=0;
									}
									//showArr();
									dfs(i,j,1);
									arr[a][b]=tmp;
									visited[i][j] = false;
								}
							}
						}
					}
				}
			}
		}
	}
	public static void showArr(){
		System.out.println("------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void dfs(int y, int x,int depth){
		//System.out.println("이동: "+y+" "+x+" "+depth);
		if(max <depth){
			max = depth;
		}
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx<0 || ny>=N || nx>=N){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			if(arr[ny][nx]>=arr[y][x]){
				continue;
			}
			visited[ny][nx] = true;
			dfs(ny,nx,depth+1);
			visited[ny][nx] = false;
		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] = false;
			}
		}
	}
}
