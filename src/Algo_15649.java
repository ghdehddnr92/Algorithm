import java.util.Scanner;

public class Algo_15649 {
	static int N,M;
	static int tmp[];
	static boolean visited[];
	public static void main(String[]arsgs){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		tmp = new int[M];
		visited = new boolean[N+1];
		dfs(0,1);
	}
	public static void dfs(int depth, int index){
		if(depth==M){
			for(int i=0;i<M;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}

		for(int i=1;i<=N;i++){
			if(!visited[i]){
				tmp[depth]= i;
				visited[i] =true;
				dfs(depth+1,i+1);
				visited[i] =false;
			}
		}
	}
}
