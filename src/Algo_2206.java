import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_2206 {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static int res = 0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		M = in.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0;i<N;i++){
			String line = in.next();
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(line.charAt(j)+"");
			}
		}

		bfs(0,0);

		if(res!=0){
			System.out.println(res);
		}
		else{
			System.out.println(-1);
		}
	}
	public static void bfs(int y, int x){
		Queue<Buk> q = new LinkedList<Buk>();
		q.add(new Buk(y,x,0,false));
		visited[y][x] = true;

		while(!q.isEmpty()){
			Buk tmp = q.poll();

			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt + 1;
				boolean nCrash = tmp.crash;
				System.out.println("-----------------"+nCnt+"턴 "+ny+" "+nx+" "+nCrash);
				if(ny<0 || nx<0 || ny>=N || nx>=M){
					continue;
				}
//				if(visited[ny][nx]){
//					continue;
//				}
				if(arr[ny][nx]==1){
					if(nCrash){ //한번이라도 벽을 부쉈을 경우. 
						continue;
					}
					else{// 벽을 부순적이 없을 경우.
				//		visited[ny][nx] = true;
						q.add(new Buk(ny,nx,nCnt,true));
				//		visited[ny][nx] = false;
						nCrash =false;
					}
				}
				else{
					q.add(new Buk(ny,nx,nCnt,nCrash));
				//	visited[ny][nx] = true;
				}

			//	showVisited();
				if(ny==N-1 && nx ==M-1){
					res = nCnt+1;
					return;
				}
			}
		}
	}
	public static void showVisited(){
		System.out.println("----------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void showArr(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Buk{
	int y;
	int x;
	int cnt;
	boolean crash;
	Buk(int y, int x, int cnt,boolean crash){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.crash = crash;
	}
}
