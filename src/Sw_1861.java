//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Sw_1861 {
//	static int T;
//	static int N;
//	static int arr[][];
//	static boolean visited[][];
//	static int dy[]={1,-1,0,0};
//	static int dx[]={0,0,1,-1};
//	static int max =0;
//	static int value =0;
//	public static void main(String[]args){
//
//		Scanner in = new Scanner(System.in);
//
//		T= in.nextInt();
//
//		for(int t=1;t<=T;t++){
//			N = in.nextInt();
//			arr = new int[N][N];
//			visited =new boolean[N][N];
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					arr[i][j] = in.nextInt();
//				}
//			}
//
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					bfs(i,j);
//				}
//			}
//			System.out.println("#"+t+" "+value+" "+max);
//			max =0;
//			value= 0;
//		}
//	}
//	public static void bfs(int y, int x){
//		Queue<Point> q = new LinkedList<Point>();
//		//System.out.println("시작: "+y+" "+x);
//		//visited[y][x]= true;
//		q.add(new Point(y,x,0));
//
//		Point tmp;
//		while(!q.isEmpty()){
//			tmp = q.poll();
//			for(int i=0;i<4;i++){
//				int ny = tmp.y+dy[i];
//				int nx = tmp.x+dx[i];
//				int nCnt = tmp.cnt + 1;
//
//				if(ny< 0 || nx< 0 || ny>N-1 || nx>N-1){
//					continue;
//				}
//				if(visited[ny][nx]== true){
//					continue;
//				}
//				if(arr[ny][nx] == arr[tmp.y][tmp.x]+1){
//					//System.out.println("ny: "+ny+"nx: "+nx+" nCNt"+nCnt);
//
//					q.add(new Point(ny,nx,nCnt));
//				}
//				if(max < nCnt){
//					max = nCnt;
//					value = arr[y][x];
//				}
//				else if(max == nCnt){
//					if(value > arr[y][x]){
//						 value = arr[y][x];
//					}
//				}
//			}
//		}
//
//	}
//}
//class Point{
//	int x;
//	int y; 
//	int cnt;
//	public Point(int y,int x,int cnt){
//		this.y = y;
//		this.x = x;
//		this.cnt = cnt;
//	}
//}
