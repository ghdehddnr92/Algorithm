import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_3055 {
	static int N,M;
	static String arr[][];
	static boolean visited[][];
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static boolean visited2[][];
	static boolean flag = false;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		arr=  new String[N][M];
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];


		for(int i=0;i<N;i++){
			String line = in.next();
			for(int j=0;j<M;j++){
				arr[i][j]= line.charAt(j)+"";
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j].equals("S")){
					bfs(i,j);
				}
			}
		}
		if(!flag){
			System.out.println("KAKTUS");
		}
	}
	public static void bfs(int y, int x){
		Queue<Tal> q = new LinkedList<Tal>();
		q.add(new Tal(y,x));
		visited[y][x]= true;
		int time = 0;
		while(!q.isEmpty()){

			int size = q.size();
			time++;
			mapChange();
			//showArr();
			for(int j=0;j<size;j++){
				Tal tmp = q.poll();
				//	System.out.println(tmp.y+"  "+tmp.x+"  시작 위치 ");


				for(int i=0;i<4;i++){
					int ny = tmp.y+dy[i];
					int nx = tmp.x+dx[i];
			
					//System.out.println(ny+" "+nx+" "+nCnt+"-----------");
					if(ny<0 || nx<0 || ny>=N || nx>=M){
						continue;
					}
					if(visited[ny][nx]){
						continue;
					}
					if(arr[ny][nx].equals("*") || arr[ny][nx].equals("X")){
						continue;
					}
					if(arr[ny][nx].equals("D")){
						System.out.println(time);
						flag = true;
						return;
					}
					q.add(new Tal(ny,nx));
					visited[ny][nx] = true;
				}
			}
		}
	}
	public static void showArr(){
		System.out.println("----------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void mapChange(){
		for(int i=0;i<N;i++){
			for(int j =0;j<M;j++){
				if(arr[i][j].equals("*") && !visited2[i][j]){
					bfs2(i,j);
				}
			}
		}
		//showVisited2();
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visited2[i][j] = false;
			}
		}
	}
	public static void showVisited2(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(visited2[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void bfs2(int y, int x){
		Queue<Tal>q = new LinkedList<Tal>();
		q.add(new Tal(y,x));
		visited2[y][x] = true;
		int time =0;
		while(!q.isEmpty()){
			int size = q.size();
			time++;
			
			for(int j=0;j<size;j++){
				Tal tmp = q.poll();

				for(int i=0;i<4;i++){
					int ny = tmp.y+dy[i];
					int nx = tmp.x+dx[i];

					if(time==2){
						return;
					}
					if(ny<0 || nx<0 || ny>=N || nx>=M){
						continue;
					}
					if(visited2[ny][nx]){
						continue;
					}
					if(arr[ny][nx].equals("D") || arr[ny][nx].equals("X")|| arr[ny][nx].equals("*")){
						continue;
					}

					q.add(new Tal(ny,nx));
					visited2[ny][nx]=true;
					arr[ny][nx] = "*";
				}
			}
		}
	}
}
class Tal{
	int y;
	int x;

	Tal(int y, int x){
		this.y = y;
		this.x = x;
	}
}