//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Sw_2105 {
//	static int T;
//	static int N;
//	static int arr[][];
//	static boolean visited[][];
//	static int dx[] = {1,-1,-1,1};
//	static int dy[] = {1,1,-1,-1};
//	static int cnt=0;
//	static int max=0;
//	
//	public static void main(String[]args){
//		
//		Scanner in = new Scanner(System.in);
//		T = in.nextInt();
//		
//		for(int t=0;t<T;t++){
//			N = in.nextInt();
//			arr = new int[N][N];
//			visited = new boolean[N][N];
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					arr[i][j] = in.nextInt();
//				}
//			}
//			
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					System.out.println("새로운 bfs");			
//					bfs(i,j);
//					resetVisited();
//				}
//			}
//		}
//	}
//	public static int bfs(int y, int x){
//		Queue<Node>q = new LinkedList<Node>();
//		
//		q.add(new Node(y,x));
//		visited[y][x]=true;
//		System.out.println(arr[y][x]);
//		Node tmp = null;
//		while(!q.isEmpty()){
//			tmp = q.poll();
//			
//			for(int i=0;i<4;i++){
//				int ny = tmp.y + dy[i];
//				int nx = tmp.x + dx[i];
//				
//				if(ny<0 || nx<0 || ny>=N || nx>=N){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//				if(q.contains(arr[ny][nx]) && visited[ny][nx]==false){
//					continue;
//				}
//				q.add(new Node(ny,nx));
//				visited[ny][nx]=true;
//				cnt++;
//				System.out.println(arr[ny][nx]);
//				System.out.println("size : "+q.size());
//				if(q.contains(arr[ny][nx]) && visited[ny][nx]==true){
//					System.out.println("종료 조건");
//					return cnt;
//				}
//			}
//		}
//		return -1;
//	}
//	public static void resetVisited(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				visited[i][j]=false;
//			}
//		}
//	}
//}
//class Node{
//	int x;
//	int y;
//	
//	Node(int y, int x){
//		this.y = y;
//		this.x = x;
//	}
//}
