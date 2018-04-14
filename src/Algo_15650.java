import java.util.Scanner;

public class Algo_15650 {
	static int N,M;
	static int tmp[];

	public static void main(String[]arsgs){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		tmp = new int[M];

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

		for(int i=index;i<=N;i++){

			tmp[depth]= i;
			dfs(depth+1,i+1);
		}
	}
}
