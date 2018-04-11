import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_14500_2 {
	static int N,M;
	static int arr[][];
	static int max =0;
	static int dy[]= {-1,1,0,0};
	static int dx[]= {0,0,-1,1};
	static int res =0 ;
	static boolean visited[][];
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		solve();
		
		System.out.println(max);
		
	}
	public static void solve(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visited[i][j]= true;
				dfs(i,j,arr[i][j],1);
				visited[i][j] = false;
			}
		}
		check(); // ㅏ ㅓ ㅗ ㅜ  체크
	}
	public static void check(){
		int sum1 =0 ,sum2 =0 ,sum3 =0,sum4 = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(i+2<N && j+1<M){
					sum1+=(arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1]);
				}
				if(i-1>=0 && i+1 <N && j+1<M && j-1>=0){
					sum2+=(arr[i][j]+arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1]);
				}
				if(i+2<N && j-1>=0){
					sum3+=(arr[i][j]+arr[i+1][j-1]+arr[i+1][j]+arr[i+2][j]);
				}
				if(j+2<M &&i+1<N){
					sum4+=(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]);
				}
				max = Math.max(Math.max(Math.max(Math.max(max, sum1),sum2),sum3),sum4);
				sum1=0;
				sum2=0;
				sum3=0;
				sum4=0;
			}
		}
	}
	public static void dfs(int y,int x, int sum, int depth){
		if(depth == 4){
			if(max <sum){
				max = sum;
			}
			return;
		}
		
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0 || nx<0 || ny>=N||nx>=M){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			visited[ny][nx] = true;
			dfs(ny,nx,sum+arr[ny][nx],depth+1);
			visited[ny][nx] = false;
		}
	}
	public static void showArr(){
		System.out.println("------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
