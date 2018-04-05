import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_7576_2 {
	static int M,N;
	static int arr[][];
	static boolean visited[][];
	static int dy[] ={1,0,-1,0};
	static int dx[] ={0,1,0,-1};
	static int cnt=0;
	static int max=0;
	static Queue<Tomato>q;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		M =  in.nextInt();
		N =  in.nextInt();

		arr = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<Tomato>();
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j] = in.nextInt();
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==1){
					q.add(new Tomato(i,j,0));
					visited[i][j] =true;
				}
			}
		}
		bfs();
		
		if(check()){
			System.out.println(max);
		}
		else{
			System.out.println(-1);
		}
	}
	public static void bfs(){
		while(!q.isEmpty()){
			Tomato tmp = q.poll();

			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;
				if(ny<0|| nx<0 || ny>=N || nx>=M){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}
				if(arr[ny][nx]==-1){
					continue;
				}
				if(arr[ny][nx]==0){
					arr[ny][nx]=1;
					visited[ny][nx] =true;
					//showArr();
					cnt++;
					q.add(new Tomato(ny,nx,nCnt));
					if(nCnt> max){
						max =nCnt;
					}
				}
			}
		}
	}
	public static void showArr(){
		System.out.println("----------");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static boolean check(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==0){
					return false;
				}
			}
		}
		return true;
	}
}
class Tomato{
	int y; 
	int x;
	int cnt;
	Tomato(int y, int x,int cnt){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}
