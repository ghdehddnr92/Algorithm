import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Algo_1753 {
	
	static int V;
	static int E;
	static int dist[];
	static int start;
	static ArrayList<ArrayList<Integer>> W = new ArrayList<>();
	static boolean visited[]; // 해당 노드가 방문했는지 안했는지 체크
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		V=in.nextInt();
		E=in.nextInt();
		
		dist= new int[V+1];
		visited= new boolean[V+1];
		
		for(int i=0;i<V+1;i++){
			dist[i]=INF; //거리를 INF로 초기화
			W.add(new ArrayList<>());
		}
		start= in.nextInt();
		
		
		for(int i=0;i< V+1;i++){
			visited[i]=false;
		}
		
		for(int i=0;i<E;i++){
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			
			W.get(u).add(v*11 + w); 
		}
		
		dijkstra(start,V);
		
		for(int i=1;i<dist.length;i++){
			System.out.println(dist[i] < INF ? dist[i] : "INF");
		}
	}
	
	public static void dijkstra(int start, int V){
		PriorityQueue<dijks> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		
		pq.add(new dijks(dist[start],start));
		
		while(!pq.isEmpty()){
			int cost = pq.peek().dist;
			int current = pq.peek().node;
			
			pq.poll();
			
			if(dist[current] < cost){
				continue;
			}
			
			for(int x: W.get(current)){
				int adj = x/ 11;
				int weight = x%11;
				
				if(dist[adj] > dist[current]+weight){
					dist[adj] = dist[current]+weight;
					pq.add(new dijks(dist[adj],adj));
				}
			}
		}
	}
	
}
class dijks implements Comparable<dijks>{
	int node;
	int dist;
	
	dijks(int dist, int node){
		this.dist = dist;
		this.node = node;
	}
	@Override
	public int compareTo(dijks o) {
		// TODO Auto-generated method stub
		return this.dist < o.dist ? -1 : 1; 
	}
}
