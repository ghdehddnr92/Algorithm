	import java.io.IOException;
	import java.util.Scanner;
	
	public class Sw_1949 {
		static int T=0;
		static int N=0,K=0;
		static int arr[][];
		static boolean visited[][];
		static int depth=0;
		static int D[][];
		static int dx[] = {0,0,1,-1};
		static int dy[] = {1,-1,0,0};
		public static void main(String[]args) throws Exception{
			solution();
		}
		public static void solution() throws Exception{
			Scanner in = new Scanner(System.in);
	
			T =in.nextInt();
			int t=0;
			while(t++ <=T){
				N =in.nextInt();
				K =in.nextInt();
	
				arr = new int[N][N];
				D= new int[N][N];
				visited = new boolean[N][N];
				int max=0;
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						arr[i][j] = in.nextInt();
						if(max<arr[i][j]){
							max = arr[i][j];
						}
					}
				}
	
				setD();
	
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(D[i][j]==max && visited[i][j]==false){
							dfs(i,j,1);
						}
					}
				}
				setD();
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						for(int k=1;k<=K;k++){
							D[i][j]=D[i][j]-k;
							//	System.out.println("i :"+i+"j :"+j+" "+D[i][j]);
							for(int l=0;l<N;l++){
								for(int f=0;f<N;f++){
									if(D[l][f]==max && visited[l][f]==false){
										dfs(l,f,1);
									}
								}
							}
							setD();
							setVisited();
							//	System.out.println("초기화");
						}
					}
				}
	
				System.out.println("#"+t+" "+depth);
				depth=0;
			}
		}
		public static void dfs(int y, int x,int d){
			visited[y][x] = true;
	
			for(int i=0;i<4;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
	
				if(nx<0 || ny<0 || nx>N-1 || ny >N-1){
					continue;
				}
				if(visited[ny][nx]==true){
					continue;
				}
				if(D[ny][nx]>=D[y][x]){
					continue;
				}
				//System.out.println("ny : "+ny+"nx : "+nx);
				dfs(ny,nx,d+1);
				visited[ny][nx]=true;
			}
			if(depth<d){
				depth= d;
			}
			setVisited();
		}
		public static void setVisited(){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					visited[i][j]=false;
				}
			}
		}
		public static void setD(){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					D[i][j] =arr[i][j];
				}
			}
		}
	}
