import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1949_2 {
	static int T;
	static int N,K;
	static int arr[][];
	static int D[][];
	static int max =0;
	static boolean visited[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int cnt=0;
	static long depth=0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		String line;
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			line= br.readLine();
			st = new StringTokenizer(line);
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			arr = new int [N][N];
			D = new int[N][N];
			visited = new boolean[N][N];
			max=0;
			for(int i=0;i<N;i++){
				line = br.readLine();
				st = new StringTokenizer(line);
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]>max){
						max =arr[i][j];
					}
				}
			}
			setD();
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					for(int k=0;k<=K;k++){
						D[i][j]= D[i][j]-k;
						for(int n=0;n<N;n++){
							for(int m=0;m<N;m++){
								if(D[n][m]==max && visited[n][m]==false){
									DFS(n,m,1);
								}
							}
						}
						//setVisited();
						setD();
					}
				}
			}
			System.out.println("#"+t+" "+depth);
			depth=0;
		}
	}
	public static void DFS(int y,int x,int d){
		visited[y][x]=true;
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx<0 || ny>N-1 || nx>N-1){
				continue;
			}
			if(visited[ny][nx]==true){
				continue;
			}
			if(D[y][x]<=D[ny][nx]){
				continue;
			}
			DFS(ny,nx,d+1);
			//visited[ny][nx]=true;
		}
		if(depth<d){
			depth=d;
		}
		setVisited();
	}
	public static void showD(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(D[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void setD(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				D[i][j]= arr[i][j];
			}
		}
	}
	public static void setVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j]=false;
			}
		}
	}
}
