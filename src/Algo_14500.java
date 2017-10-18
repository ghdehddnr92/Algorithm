import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_14500 {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int max= 0;
	static int dx[]={0,0,1,-1};
	static int dy[]={1,-1,0,0};
	static int sum=0;

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr  = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0;i<N;i++){
			line = br.readLine();
			st = new StringTokenizer(line);
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				dfs(i,j,1,arr[i][j]);
			}
		}
		check();
		System.out.println(max);
	}
	public static void check(){ // ㅗ ㅜ ㅏ ㅓ check
		int sum1=0;
		int sum2=0;
		int sum3=0;
		int sum4=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(i-1>=0 && j-1>=0 &&j+1<=M-1){
					sum1=arr[i-1][j]+arr[i][j-1]+arr[i][j]+arr[i][j+1];
				}
				if(i-1>=0 && j+1<=M-1&&i+1<=N-1){
					sum2=arr[i-1][j]+arr[i][j]+arr[i][j+1]+arr[i+1][j];
				}
				if(j-1>=0 && i-1>=0&& i+1<=N-1){
					sum3=arr[i][j-1]+arr[i-1][j]+arr[i][j]+arr[i+1][j];
				}
				if(i+1<=N-1 && j-1>=0 && j+1<=M-1){
					sum4 =arr[i+1][j-1]+arr[i][j]+arr[i][j+1]+arr[i+1][j];
				}
				System.out.println(sum1+" "+sum2+" "+sum3+" "+sum4);
				max=Math.max(max, Math.max(Math.max(Math.max(sum1, sum2),sum3),sum4));
			}
		}
	}
	public static void dfs(int y,int x ,int d,int sum){
		//visited[y][x]=true;
		if(d==4){
			if(sum>max){
				max= sum;
			}
			return;
		}
		visited[y][x]=true;
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx<0 || ny>N-1 || nx>M-1){
				continue;
			}
			if(visited[ny][nx]==true){
				continue;
			}
			dfs(ny,nx,d+1,sum+arr[ny][nx]);
		}
		visited[y][x]=false;
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visited[i][j] = false;
			}
		}
	}
}
class block{
	int y;
	int x;
	int l;
	int sum;
	block(int y, int x, int l,int sum){
		this.y = y;
		this.x = x;
		this.l = l;
		this.sum= sum;
	}
}
