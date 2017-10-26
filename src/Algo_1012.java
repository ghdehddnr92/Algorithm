import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1012 {
	static int T;
	static int N,M,K;
	static int arr[][];
	static boolean visited[][];
	static int cnt=0;
	static int dx[] ={0,0,1,-1};
	static int dy[] ={1,-1,0,0};
	public static void main(String[]args){
		
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int t =0; t<T;t++){
			M =in.nextInt();
			N = in.nextInt();
			K =in.nextInt();
			arr = new int[N][M];
			visited = new boolean[N][M];
			for(int k=0;k<K;k++){
				int x = in.nextInt();
				int y = in.nextInt();
				
				arr[y][x]=1;
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(arr[i][j]==1&&visited[i][j]==false){
						bfs(i,j);
					//	System.out.println("다음 호출 :"+i+" "+j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			cnt=0;
		}
	}
	public static void bfs(int y, int x){
		Queue <bachu> q= new LinkedList<>();
		q.add(new bachu(y,x));
		visited[y][x]=true;
		bachu tmp = null;
		while(!q.isEmpty()){
			tmp = q.poll();

			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];

				if(ny<0 || nx<0 || ny>=N || nx>=M){
					continue;
				}
				if(visited[ny][nx]==true){
					continue;
				}
				if(arr[ny][nx]==0){
					continue;
				}
			//	System.out.println(ny+" "+nx);
				q.add(new bachu(ny,nx));
				visited[ny][nx]=true;
			}
		}
	}
}
class bachu{
	int y;
	int x;
	
	bachu(int y, int x){
		this.y = y;
		this.x = x;
	}
}
