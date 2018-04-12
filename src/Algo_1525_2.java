//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Algo_1525_2 {
//	static int arr[][];
//	static int resMap[][] ={{1,2,3},{4,5,6},{7,8,0}};
//	static int res = -1;
//	static int dy[] = {1,0,-1,0};
//	static int dx[] = {0,1,0,-1};
//	static boolean visited[][];
//	public static void main(String[]args){
//		Scanner in = new Scanner(System.in);
//		
//		arr = new int[3][3];
//		visited =new boolean [3][3];
//		
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				arr[i][j] = in.nextInt();	
//			}
//		}
//		solve();
//		
//		System.out.println(res);
//	}
//	public static void solve(){
//		
//		int map[][] = new int[3][3];
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				map[i][j] = arr[i][j];
//			}
//		}
//		
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				if(map[i][j]==0){
//					bfs(i,j,map);
//				}
//			}
//		}
//	}
//	public static void bfs(int y, int x,int map[][]){
//		Queue<Puzzle> q= new LinkedList<>();
//		visited[y][x] = true;
//		q.add(new Puzzle(y,x,map));
//		int time =0;
//		while(!q.isEmpty()){
//			
//			int qSize =q.size();
//			
//			for(int size =0;size<qSize;size++){
//				Puzzle tmp = q.poll();
//				
//				for(int i=0;i<4;i++){
//					int ny = tmp.y+dy[i];
//					int nx = tmp.x+dx[i];
//					int nMap[][] = tmp.map;
//					
//					if(time == 1){
//					//	showMap(nMap);
//						return;
//					}
//					if(ny<0 || nx<0 || ny>=3 || nx>=3){
//						continue;
//					}
//					if(visited[ny][nx]){
//						continue;
//					}
//					nMap[tmp.y][tmp.x] = nMap[ny][nx];
//					nMap[ny][nx] = 0;
//					visited[ny][nx] = true;
//					showMap(nMap);
//					q.add(new Puzzle(ny,nx,nMap));
//				}
//			}
//			time++;
//		}
//	}
//	public static void showMap(int map[][]){
//		System.out.println("--------------");
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println("");
//		}
//	}
//	public static boolean sameCheck(int map[][]){
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				if(map[i][j]!= resMap[i][j]){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//}
//class Puzzle{
//	int y;
//	int x;
//	int map[][];
//	Puzzle(int y, int x, int map[][]){
//		this.y = y;
//		this.x = x;
//		this.map = map;
//	}
//}