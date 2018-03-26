import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_2117_3 {
	static int T;
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int dy[] ={1,0,-1,0};
	static int dx[] ={0,1,0,-1};
	static int max =0;
	static int value;
	static int house =0;
	static int houseCnt=0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			visited = new boolean[N][N];

			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==1){
						houseCnt++;
					}
				}
			}
			//System.out.println("");

			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					for(int k=1;k<=N+1;k++){
						calValue(k);
						bfs(i,j,0,k);
						resetVisited();
						house =0;
					}
				}
			}

			System.out.println("#"+t+" "+max);
			max = 0;
		}
	} 
	public static void calValue(int k){
		value = k * k +(k-1)*(k-1);
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] = false;
			}
		}
	}
	public static void bfs(int y,int x, int cnt, int maxCnt){
		Queue<Bangbumm> q = new LinkedList<Bangbumm>();
		q.add(new Bangbumm(y,x,cnt));
		if(arr[y][x]==1){
			house++;
		}
		visited[y][x]=true;
		while(!q.isEmpty()){
			Bangbumm tmp = q.poll();

			for(int i=0;i<4;i++){

				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;

				if(nCnt==maxCnt){
					calValue(maxCnt);
					if((house * M) - value>=0){
						if(max < house){
							//		showVisited();
							max = house;
						}
					}
					return;
				}

				if(ny<0 || nx<0 || ny>=N || nx>=N){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}

				if(arr[ny][nx]==1){
					house++;
				}
				visited[ny][nx] = true;
				q.add(new Bangbumm(ny,nx,nCnt));
			}
		}
	}
	public static void showVisited(){
		System.out.println("--------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visited[i][j]){
					System.out.print("O ");
				}
				else{
					System.out.print("X ");
				}
			}
			System.out.println("");
		}
	}
}
class Bangbumm{
	int y;
	int x;
	int cnt;
	public Bangbumm(int y, int x,int cnt){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}
