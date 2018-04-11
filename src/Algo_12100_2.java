import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_12100_2 {
	static int N;
	static int arr[][];
	static int max =0;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int tmp[][];
	static boolean visited[][];
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		tmp  = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();

		System.out.println(max);
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] = false;
			}
		}
	}
	public static void solve(){

		int map[][] = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j] = arr[i][j];
			}
		}
		dfs(0,map);
	}
	public static void dfs(int depth, int map[][]){
		if(depth==5){
			checkMax(map);
			return;
		}

		for(int i=0;i<4;i++){
			setTmp(map);
			//System.out.println(depth+"------------"+i+" -----------");
			move(i);
			//showTmp();
			resetVisited();
			int tmp2[][] = new int[N][N];
			for(int a=0;a<N;a++){
				for(int b=0;b<N;b++){
					tmp2[a][b] = tmp[a][b];
				}
			}
			dfs(depth+1,tmp2);
		}
	}
	public static void move(int dir){
		if(dir == 0){ // 상 
			for(int j=0;j<N;j++){
				for(int i=1;i<N;i++){
					if(tmp[i][j]!=0){
						int k = i;
						while(tmp[k-1][j]==0){
							tmp[k-1][j] = tmp[k][j];
							tmp[k][j] = 0;
							k--;
							if(k-1<0){
								break;
							}
						}
						if(k-1>=0 &&tmp[k-1][j]==tmp[k][j] && !visited[k-1][j]){
							tmp[k-1][j]+=tmp[k][j];
							tmp[k][j] = 0;
							visited[k-1][j] = true;
						}
					}
				}
			}
		}
		else if(dir == 1){//하 
			for(int j=0;j<N;j++){
				for(int i=N-2;i>=0;i--){
					if(tmp[i][j]!=0){
						int k = i;
						while(tmp[k+1][j]==0){
							tmp[k+1][j] = tmp[k][j];
							tmp[k][j] = 0;
							k++;
							if(k+1>=N){
								break;
							}
						}
						if(k+1<N && tmp[k+1][j]==tmp[k][j] && !visited[k+1][j]){
							tmp[k+1][j]+=tmp[k][j];
							tmp[k][j] = 0;
							visited[k+1][j] = true;
						}
					}
				}
			}
		}
		else if(dir == 2){//좌 
			for(int i=0;i<N;i++){
				for(int j=1;j<N;j++){
					if(tmp[i][j]!=0){
						int k = j;
						while(tmp[i][k-1]==0){
							tmp[i][k-1] = tmp[i][k];
							tmp[i][k] = 0;
							k--;
							if(k-1<0){
								break;
							}
						}
						if(k-1>=0 && tmp[i][k-1]==tmp[i][k] && !visited[i][k-1]){
							tmp[i][k-1]+=tmp[i][k];
							tmp[i][k] = 0;
							visited[i][k-1] = true;
						}
					}
				}
			}
		}
		else{//우 
			for(int i=0;i<N;i++){
				for(int j=N-2;j>=0;j--){
					if(tmp[i][j]!=0){
						int k = j;
						while(tmp[i][k+1]==0){
							tmp[i][k+1] = tmp[i][k];
							tmp[i][k] = 0;
							k++;
							if(k+1>=N){
								break;
							}
						}
						if(k+1<N && tmp[i][k+1]==tmp[i][k] && !visited[i][k+1]){
							tmp[i][k+1]+=tmp[i][k];
							tmp[i][k] = 0;
							visited[i][k+1] = true;
						}
					}
				}
			}
		}
	}
	public static void showTmp(){
		System.out.println("------------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void setTmp(int map[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				tmp[i][j] = map[i][j];
			}
		}
	}
	public static void checkMax(int map[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]>max){
					max = map[i][j];
				}
			}
		}
	}
}
