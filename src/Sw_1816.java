import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1816 {
	static int T;
	static int N;
	static int K;
	static int arr[];
	static long dp[][];
	static long res = 0;
	static int tmp[];
	static String num ="";
	static boolean visited[];
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr =new int[N];
			visited = new boolean[N];
			tmp = new int[N];
			dp =new long [N+1][(1<<N)+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			K = Integer.parseInt(br.readLine());
	
			solve(1,0);
		}
	}

	public static long solve(int index, int visited){
		if(visited == (1<<N) -1){
			if(dp[index][visited]%K ==0){
				res++;
			}
		}
		for(int i=0;i<N;i++){
			if ((visited & (1 << i)) != 0){
				continue;
			}
			dp[index+1][visited] = Long.parseLong((String.valueOf(solve(index+1,visited + (1 << i)))+arr[i]))%K;
		}
		return dp[index][visited];
	}
}
