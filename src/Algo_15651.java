import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_15651{
	static int N,M;
	static int arr[];
	public static void main(String[]arsgs) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(0);
	}
	public static void dfs(int depth){
		if(depth==M){
			for(int i=0;i<M;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println("");
			return;
		}

		for(int i=1;i<=N;i++){
			arr[depth]= i;
			dfs(depth+1);
		}
	}
}
