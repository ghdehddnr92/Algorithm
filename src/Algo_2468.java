import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_2468 {
	static int N;
	static int arr[][];
	static int maxHeight =0;
	static int water=1;
	static int max =0;
	static boolean visited[][];
	static int dx[] ={1,-1,0,0};
	static int dy[] ={0,0,1,-1};
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = in.nextInt();
				if(arr[i][j]>maxHeight){
					maxHeight = arr[i][j];
				}
			}
		}

		while(water<=maxHeight){
			int res =0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(arr[i][j]>water && visited[i][j]==false){
						bfs(i,j);
						res ++;
					}
				}
			}
			//System.out.println("water :"+water +"res :"+res);
			if(res >max){
				max = res;
			}
			water++;
			resetVisit();	
		}
		
		System.out.println(max);
	}
	public static void bfs(int y,int x){
		Queue<Anjun> q=  new LinkedList<Anjun>();
		q.add(new Anjun(y,x));
		visited[y][x] = true;
		
		while(!q.isEmpty()){
			Anjun tmp = q.poll();
			
			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				
				if(ny <0 || nx<0 || ny>=N || nx>=N){
					continue;
				}
				if(arr[ny][nx]<=water){
					continue;
				}
				if(visited[ny][nx]==true){
					continue;
				}
				
				q.add(new Anjun(ny,nx));
				visited[ny][nx]=true;
			}
		}
	}
	public static void resetVisit(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] = false;
			}
		}
	}
}
class Anjun{
	int y;
	int x;
	
	public Anjun(int y, int x){
		this.y = y;
		this.x = x;
	}
}
