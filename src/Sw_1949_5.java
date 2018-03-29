import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1949_5 {
	static int T;
	static int N,K;
	static int arr[][];
	static int map[][];
	static boolean visited[][];
	static int maxHigh =0;
	static int max =0;
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]>maxHigh){
						maxHigh = arr[i][j];
					}
				}
			}
			setMap();
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(arr[i][j]==maxHigh){
						visited[i][j] = true;
						dfs(i,j,1,false);
						visited[i][j] = false;
						setMap();
					}
				}
			}
			System.out.println("#"+t+" "+max);
			max =0;
			maxHigh =0;
		}
	}
	public static void showMap(){
		System.out.println("---------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void dfs(int y, int x, int cnt, boolean isCut){
		if(cnt>max){
			max = cnt;
		//	showMap();
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
			if(map[ny][nx]>=map[y][x]){
				
				if(isCut){
					continue;
				}
				if(map[ny][nx]-K>map[y][x]-1){
					continue;
				}
				map[ny][nx]-=1;
				visited[ny][nx]=true;
				isCut =true;
				dfs(ny,nx,cnt+1,isCut);
				map[ny][nx]+=1;
				visited[ny][nx]=false;
				isCut = false;
			}
			else{
				visited[ny][nx]= true;
				dfs(ny,nx,cnt+1,isCut);
				visited[ny][nx]=false;
			}
		}
	}
	public static void setMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j] = arr[i][j];
			}
		}
	}
	public static void showVisited(){
		System.out.println("---------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
}

