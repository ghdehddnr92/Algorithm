import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Algo_1325 {
	static int N,M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	static int res= 0;
	static PriorityQueue <Integer> q;
	static int max = 0;
	static int start;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		M = in.nextInt();

		graph = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[100001];
		q = new PriorityQueue<Integer>();
		
		for(int i=0;i<=N;i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i=0;i<M;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			graph.get(a).add(b);
		}

//		for(int i=1;i<=N;i++){
//			System.out.println(graph.get(i));
//		}


		for(int i=1;i<=N;i++){
			start =i;
			dfs(i,0);
		}
		
		for(int i=0;i<=N;i++){
			if(visited[i]==true){
				System.out.print(i+" ");
			}
		}
		System.out.println("");
	}
	public static void dfs(int k,int depth){
		//dfs의 끝까지 갔을 경우 출력
	//	System.out.println("시작:"+start);
		for(int i=0;i<graph.get(k).size();i++){
	//		System.out.println("중간 :"+graph.get(start).get(i));
			if(graph.get(k).get(i)!=start){
				dfs(graph.get(k).get(i),depth+1);
			}
		}
		res = depth;
	//	System.out.println("끝:"+start+" depth :"+depth);
		if(max <=depth){
			if(max<depth){
				resetVisited();
				visited[k] = true;
				max = depth;
			}
			else{
				visited[k] = true;
			}
		}
	}
	public static void resetVisited(){
		for(int i=1;i<=N;i++){
			visited[i] = false;
		}
	}
}
