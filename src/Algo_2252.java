import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Algo_2252 {
	static int N,M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean visited[];
	static Stack<Integer> st = new Stack<Integer>();
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		

		N = in.nextInt();
		M = in.nextInt();
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++){
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			
			graph.get(a).add(b);
		}
		
		for(int i=1;i<=N;i++){
			if(!visited[i]){
				dfs(i);
			}
		}
		
		while(!st.isEmpty()){
			System.out.println(st.peek());
			st.pop();
		}
	}
	public static void dfs(int v){
		visited[v]= true;
		
		for(int i : graph.get(v)){
			if(visited[i]){
				continue;
			}
			dfs(i);
		}
		//System.out.println("push :"+v);
		st.push(v);
	}
}
