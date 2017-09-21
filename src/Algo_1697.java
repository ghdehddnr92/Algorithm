//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Algo_1697{
//	static int N;
//	static int K;
//	static boolean visited[];
//	static int dx[]={-1,1,0};
//	public static void main(String[]args){
//		Scanner in = new Scanner(System.in);
//		
//		N= in.nextInt();
//		K= in.nextInt();
//		visited = new boolean[100001];
//		if(N>=K){
//			System.out.println(N-K);
//			return;
//		}
//		bfs(N);
//	}
//	public static void bfs(int n){
//		Queue<Node> q = new LinkedList<Node>();
//		visited[n]=true;
//		q.add(new Node(0,n));
//	
//		while(!q.isEmpty()){
//			Node tmp=(Node)q.poll();
//			int cnt =tmp.cnt;
//			int value= tmp.value;
//			
//			if(value==K){
//				System.out.println(cnt);
//				return;
//			}
//			for(int i=0;i<3;i++){
//				int next;
//				
//				if(dx[i]==0){
//				    next=value*2;
//				}
//				else{
//                    next=value+dx[i];
//				}
//				
//				if(0<=next&& next<=100000){
//					if(visited[next]==false){
//						q.add(new Node(cnt+1,next));
//						visited[next]=true;
//					}
//				}
//			}	
//		}
//	}
//}
//class Node{
//	int cnt;
//	int value;
//	
//	Node(int cnt, int value){
//		this.cnt= cnt;
//		this.value= value;
//	}
//}
//
