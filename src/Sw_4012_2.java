import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw_4012_2 {
	static int T;
	static int N;
	static int arr[][];
	static int A[];
	static int B[];
	static boolean visited[];
	static int tmp[];
	static int min = Integer.MAX_VALUE;
	static int aSum =0;
	static int bSum =0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr =new int[N][N];
			visited = new boolean[N];
			A = new int[N/2];
			B = new int[N/2];
			tmp = new int[2];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j]= Integer.parseInt(st.nextToken());
				}
			}

			solve();

			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
		}
	}
	public static void solve(){
		combination(0,0);
	}
	public static void combination(int depth, int index){
		if(depth == N/2){
			resetVisited();
			for(int i=0;i<N/2;i++){
				visited[A[i]] = true;
			}
			dfs2(0,0);
			int j=0;
			for(int i=0;i<N;i++){
				if(!visited[i]){
					B[j] = i;
					j++;
				}
			}
			dfs3(0,0);
			
			if(min> Math.abs(aSum-bSum)){
				min = Math.abs(aSum-bSum);
			}
			aSum =0;
			bSum =0;
			return;
		}

		for(int i=index;i<N;i++){
			A[depth] = i;
			combination(depth+1,i+1);
		}
	}
	public static void dfs2(int depth, int index){
		if(depth == 2){
			aSum+=(arr[tmp[0]][tmp[1]]+arr[tmp[1]][tmp[0]]);
			return;
		}
		
		for(int i=index;i<N/2;i++){
			tmp[depth]= A[i];
			dfs2(depth+1,i+1);
		}
	}
	public static void dfs3(int depth, int index){
		if(depth == 2){
			bSum+=(arr[tmp[0]][tmp[1]]+arr[tmp[1]][tmp[0]]);
			return;
		}
		
		for(int i=index;i<N/2;i++){
			tmp[depth]= B[i];
			dfs3(depth+1,i+1);
		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			visited[i] =false;	
		}
	}
}
