//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Sw_1868 {
//
//	static int N;
//	static int T;
//	static int arr[][];
//	static boolean visited[][];
//	static int dy[] = {1,-1,0,0,1,-1,1,-1};
//	static int dx[] = {0,0,1,-1,1,-1,-1,1};
//	static int turn =0;
//	public static void main(String[]args){
//
//		Scanner in = new Scanner(System.in);
//		T = in.nextInt();
//
//		for(int t=1;t<=T;t++){
//
//			N = in.nextInt();
//			arr = new int[N][N];
//			visited = new boolean[N][N];
//
//			for(int i=0;i<N;i++){
//				String line = in.next();
//				for(int j=0;j<N;j++){
//					if(line.charAt(j)=='.'){ // 지뢰가 없는 곳.
//						arr[i][j]= 9;
//					}
//					else{ // 지뢰가 있는 곳.
//						arr[i][j]= -1;
//					}
//				}
//			}
//			boolean flag;
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					if(arr[i][j] == 9 && visited[i][j] == false){		
//						flag = checkAround(i,j);
//						if(flag == false){
//					//		System.out.println("처음 시작 i :"+i+"j : "+j+" -------------");
//							bfs(i,j);
//							turn++;
//						//	showArr();
//						}
//					}
//				}
//			}
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					if(arr[i][j] == 9 && visited[i][j] == false){		
//					//	System.out.println("처음 시작 i :"+i+"j : "+j+" -------------");
//						bfs(i,j);
//						turn++;
//					//	showArr();
//					}
//				}
//			}
//			System.out.println("#"+t+" "+turn);
//			turn=0;
//		}
//	}
//	public static void showArr(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println("");
//		}
//	}
//	public static boolean checkAround(int y, int x){
//
//		for(int i=0;i<8;i++){
//			int ny = y+dy[i];
//			int nx = x+dx[i];
//
//			if(ny<0 || nx<0 || ny>N-1 || nx>N-1){
//				continue;
//			}
//			if(visited[ny][nx]==true){
//				continue;
//			}
//			if(arr[ny][nx] == -1){
//				return true;
//			}
//		}
//		return false;
//	}
//	public static void bfs(int y, int x){
//		Queue<Bomb> q = new LinkedList<Bomb>();
//		visited[y][x] = true;
//		//System.out.println("y: "+y+" x: "+x);
//		q.add(new Bomb(y,x));
//
//		Bomb tmp;
//		while(!q.isEmpty()){
//			tmp = q.poll();
//			int cnt =0;
//
//			for(int i=0;i<8;i++){
//				int ny = tmp.y+dy[i];
//				int nx = tmp.x+dx[i];
//
//				if(ny<0 || nx<0 || ny>N-1 || nx>N-1){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//				if(arr[ny][nx] == -1){
//					cnt++;
//				}	
//			}
//			arr[y][x] = cnt;
//			if(cnt == 0){
//				for(int i=0;i<8;i++){
//					int ny = tmp.y+dy[i];
//					int nx = tmp.x+dx[i];
//
//					if(ny<0 || nx<0 || ny>N-1 || nx>N-1){
//						continue;
//					}
//					if(visited[ny][nx]==true){
//						continue;
//					}
//					bfs(ny,nx);
//				}
//			}
//		}
//	}
//}
//class Bomb{
//	int y;
//	int x;
//
//	public Bomb(int y, int x){
//		this.y = y;
//		this.x = x;
//	}
//}
