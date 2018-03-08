import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_2146 {
	static int N;
	static int arr[][];
	static int map[][];
	static boolean visited[][];
	static int dy[] ={1,0,-1,0};
	static int dx[] ={0,1,0,-1};
	static int cnt =0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j] && arr[i][j]==1){
					bfs(i,j);
				}
			}
		}
		//System.out.println(" -------- ");
		//showMap();
		resetVisited();
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]!=0){
					//System.out.println("*******************");
					dfs(i,j, map[i][j],0);
					resetVisited();
				}
			}
		}
		System.out.println(min-1);
	}
	public static void dfs(int y,int x, int start,int cnt){
		//System.out.println("y:"+y+" x: "+x);
		visited[y][x]=true;
		if(cnt>=min){
			return;
		}
		if(map[y][x]!=start && map[y][x]!=0){
		//	System.out.println("cnt:"+cnt);
			if(min>cnt){
				min = cnt;
				return;
			}
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
			if(map[ny][nx]==start){
				continue;
			}
			dfs(ny,nx,start,cnt+1);
		}
	}
	public static void bfs(int y, int x){
		Queue<Dari> q = new LinkedList<Dari>();
		visited[y][x] = true;
		cnt++;
		map[y][x] = cnt;
		
		q.add(new Dari(y,x));
		
		while(!q.isEmpty()){
			Dari tmp = q.poll();
			
			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];

				if(ny<0|| nx<0|| ny>=N || nx>=N){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}
				if(arr[ny][nx]==0){
					continue;
				}
				
				map[ny][nx] = cnt;
				visited[ny][nx] =true;
				q.add(new Dari(ny,nx));

			}
		}
		return;
	}
	public static void showMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j]= false;
			}
		}
	}
}
class Dari{
	int y;
	int x;

	public Dari(int y, int x){
		this.y = y;
		this.x = x;
	}
}
