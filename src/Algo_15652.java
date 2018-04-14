import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_15652 {
	static int N,M;
	static int tmp[];
	public static void main(String[]arsgs) throws IOException{
		//Scanner in = new Scanner(System.in);
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tmp = new int[M];

		//dfs(0,1);
		dfs(0,1);
	}
	public static void dfs(int depth,int index){
		if(depth==M){
			for(int i=0;i<M;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}

		for(int i=1;i<=N;i++){
			tmp[depth]= i;
			dfs(depth+1,i);
		}
	}
}
