
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_4193_3{
	static int T;
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static int startX,startY,endX,endY;
	static int res  =0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];

			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());

				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==5){
						arr[i][j] = 0;
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			startY =Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());

			bfs();

			if(res == 0){
				System.out.println("#"+t+" "+-1);
			}
			else{
				System.out.println("#"+t+" "+res);
			}
			res = 0;
		}
	}
	public static void bfs(){
		Queue<Swim>q = new LinkedList<Swim>();
		q.add(new Swim(startY,startX,0));
		visited[startY][startX] = true;

		while(!q.isEmpty()){

			Swim tmp = q.poll();
			if(tmp.y == endY && tmp.x == endX){
				res = tmp.cnt;
				return;
			}
			for(int i=0;i<4;i++){

				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;
				if(ny<0|| nx<0 || ny>=N || nx>=N){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}
				if(arr[ny][nx]==1){
					continue;
				}
				if(arr[ny][nx]==2){
					if(nCnt%3==0){
						q.add(new Swim(ny,nx,nCnt));
						visited[ny][nx]=true;
					}
				}
				else{
					q.add(new Swim(ny,nx,nCnt));
					visited[ny][nx] = true;
				}   
			}
			q.add(new Swim(tmp.y,tmp.x,tmp.cnt+1));
			if(tmp.cnt >= 4*N*N){
				return;
			}
		}
	}
	public static void showVisited(){
		System.out.println("-------------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Swim{
	int y;
	int x;
	int cnt;
	Swim(int y, int x,int cnt){
		this.y =y;
		this.x =x;
		this.cnt = cnt;
	}
}