import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_4206 {
	static int N,M;
	static int T;
	static int arr[][];
	static boolean visited[][];
	static boolean visited2[][];
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	static int res = -1;

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][M];

			visited = new boolean[N][M];
			visited2 = new boolean[N][M];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(arr[i][j]==3){
						bfs(i,j);
					}
				}
			}
			if(res == -1){
				System.out.println("#"+t+" CANNOT ESCAPE");
			}
			else if(res == -2){
				System.out.println("#"+t+" ZOMBIE");
			}
			else{
				System.out.println("#"+t+" "+res);
			}
			res =-1;

		}
	}
	public static void bfs(int y, int x){
		Queue<Yungu> q = new LinkedList<Yungu>();
		visited[y][x]= true;
		q.add(new Yungu(x,y));
		int time =0;

		while(!q.isEmpty()){
			int qSize = q.size();
			mapChange();
			for(int size =0;size<qSize;size++){
				Yungu tmp = q.poll();
				
				for(int i=0;i<4;i++){
					int ny = tmp.y+dy[i];
					int nx = tmp.x+dx[i];
					if(ny<0 || nx<0 || ny>=N || nx>=M){//탈출 
						res = time+1;
						return;
					}
					if(visited[ny][nx]){
						continue;
					}
					if(arr[ny][nx]==1){
						continue;
					}
					if(arr[ny][nx]==2){
						res = -2;
						continue;
					}
					q.add(new Yungu(nx,ny));
					visited[ny][nx] = true;
				}
			}
			time++;
		}
	}
	public static void mapChange(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==2 && !visited2[i][j]){
					bfs2(i,j);
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visited2[i][j] = false;
			}
		}
	}
	public static void bfs2(int y, int x){
		Queue<Yungu> q = new LinkedList<Yungu>();
		visited2[y][x]= true;
		q.add(new Yungu(x,y));
		int time2 =0;
		while(!q.isEmpty()){
			int qSize = q.size();
			for(int size =0;size<qSize;size++){
				Yungu tmp = q.poll();

				for(int i=0;i<4;i++){
					int ny = tmp.y+dy[i];
					int nx = tmp.x+dx[i];

					if(time2== 1){
						return;
					}
					if(ny<0 || nx<0 || ny>=N || nx>=M){//탈출 
						continue;
					}
					if(visited2[ny][nx]){
						continue;
					}
					if(arr[ny][nx]==1){
						continue;
					}
					arr[ny][nx] = 2;
					q.add(new Yungu(nx,ny));
					visited2[ny][nx] = true;
				}
			}
			time2++;
		}
	}
	public static void showArr(){
		System.out.println("------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Yungu{
	int y;
	int x;
	Yungu(int x, int y){
		this.y = y;
		this.x = x;
	}
}