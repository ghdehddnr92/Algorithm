//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Algo_2583 {
//	static int M,N,K;
//	static int arr[][];
//	static int a,b,c,d;
//	static boolean visited[][];
//	static int dx[]={0,0,1,-1};
//	static int dy[]={1,-1,0,0};
//	static int group=0;
//	static LinkedList<Integer> l = new LinkedList<Integer>();
//	static int res[];
//	public static void main(String[]args){
//		Scanner in = new Scanner(System.in);
//		M=in.nextInt();
//		N=in.nextInt();
//		K=in.nextInt();
//		arr = new int[M][N];
//		visited = new boolean[M][N];
//		for(int i=0;i<M;i++){
//			for(int j=0;j<N;j++){
//				arr[i][j]=0;
//			}
//		}
////		System.out.println();
//		for(int i=0;i<K;i++){
//			a=in.nextInt();
//			b=in.nextInt();
//			c=in.nextInt();
//			d=in.nextInt();
//			for(int l=b;l<d;l++){
//				for(int j=a;j<c;j++){
//					arr[l][j]=1;
//				}
//			}
//		}
////		System.out.println("");
////		for(int i=0;i<M;i++){
////			for(int j=0;j<N;j++){
////				System.out.print(arr[i][j]+" ");
////			}
////			System.out.println();
////		}
////		
//		for(int i=0;i<M;i++){
//			for(int j=0;j<N;j++){
//				if(arr[i][j]==0 && visited[i][j]==false){
//					bfs(i,j);
//					group++;
//				}
//			}
//		}
//		System.out.println(group);
//		res = new int[l.size()];
//		for(int i=0;i<l.size();i++){
//			res[i]=l.get(i);
//		}
//		Arrays.sort(res);
//		for(int i=0;i<res.length;i++){
//			System.out.print(res[i]+" ");
//		}
//	}
//	public static void bfs(int y, int x){
//		Queue<Node> q= new LinkedList<Node>();
//		q.add(new Node(y,x));
//		visited[y][x]=true;
//		Node tmp = null;
//		int cnt=1;
//		while(!q.isEmpty()){
//			tmp=q.poll();
//			
//			for(int i=0;i<4;i++){
//				int nx = tmp.x + dx[i];
//				int ny = tmp.y + dy[i];
//				
//				if(nx<0 || ny<0 || nx>N-1 || ny>M-1){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//				if(arr[ny][nx]==1){
//					continue;
//				}
//				q.add(new Node(ny,nx));
//				visited[ny][nx]=true;
//				cnt++;
//			}
//		}
//		l.add(cnt);
//	}
//}
//class Node{
//	int y;
//	int x;
//	
//	Node(int y,int x){
//		this.y=y;
//		this.x=x;
//	}
//}
