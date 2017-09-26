//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Algo_7576 {
//	static int N,M;
//	static boolean visited[][];
//	static int arr[][];
//	static int dx[] = {1,-1, 0, 0};
//	static int dy[] = {0, 0, 1, -1};
//	static int zeroCnt=0;
//	static int oneCnt=0;
//	static int D[][];
//	static int day=0;
//	static int max=0;
//	public static void main(String[]args){
//		Scanner in = new Scanner(System.in);
//		
//		M=in.nextInt();
//		N=in.nextInt();
//		arr = new int[N][M];
//		visited = new boolean[N][M];
//		D= new int [N][M];
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				arr[i][j] = in.nextInt();
//				if(arr[i][j]==0){
//					zeroCnt++;
//				}
//				if(arr[i][j]==1){
//					D[i][j]=1;
//				}
//			}
//		}
//		if(zeroCnt==(N*M)){
//			System.out.println("0");
//			return;
//		}
//		//System.out.println(zeroCnt);
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				if(arr[i][j]==1 && visited[i][j]==false){
//					bfs(i,j);
//				}
//			}
//		}
//	}	
//	public static void bfs(int y,int x){
//
//		Queue q = new LinkedList<Node>();
//		q.add(new Node(y,x,day));
//		System.out.println("y :"+y +" x : "+ x);
//		visited[y][x]= true;
//		Node tmp=null;
//	
//		while(!q.isEmpty()){
//			tmp=(Node)q.poll();
//			int day= tmp.day;
//			for(int i=0;i<4;i++){
//				int nx = tmp.x + dx[i];
//				int ny = tmp.y + dy[i];
//
//				if(ny< 0 || nx<0 || ny>N-1 || nx > M-1){
//					continue;
//				}
//				if(arr[ny][nx]==-1){
//					continue;
//				}
//				if(arr[ny][nx]==1){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//					q.add(new Node(ny,nx,day+1));
//					D[ny][nx]=1;
//					System.out.println("ny :"+ny +" nx : "+ nx);
//					oneCnt++;
//					visited[ny][nx]=true;
//			}
//			if(max<day){
//				max= day;
//			}
//		}
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				System.out.print(D[i][j]+" ");
//				if(D[i][j]==0){
//					System.out.println("-1");
//					return;
//				}
//			}
//			System.out.println("");
//		}
//		System.out.println("max :"+max);
//		
//	}
//}
//class Node{
//	int x;
//	int y;
//	int day;
//	Node(int y, int x,int day){
//		this.y = y;
//		this.x = x;
//		this.day=day;
//	}
//}
//
