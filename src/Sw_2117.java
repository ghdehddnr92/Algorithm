//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Sw_2117 {
//	static int T;
//	static int N,M;
//	static int arr[][];
//	static int D[][];
//	static boolean visited[][];
//	static int dx[]={0,0,1,-1};
//	static int dy[]={1,-1,0,0};
//	static int cnt = 0;
//	static int max = 0;
//	static int check=0;
//	public static void main(String[]args) throws NumberFormatException, IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		T = Integer.parseInt(br.readLine());
//
//		for(int tc = 1;tc<=T;tc++){
//			String line;
//			line = br.readLine();
//			StringTokenizer st = new StringTokenizer(line);
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			arr = new int[N][N];
//			visited = new boolean[N][N];
//			
//			for(int i=0;i<N;i++){
//				line = br.readLine();
//				st = new StringTokenizer(line);
//				for(int j=0;j<N;j++){
//					arr[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//
//			for(int i=0;i<N;i++){
//				for(int j=0;j<N;j++){
//					if(arr[i][j]==1){
//						cnt++;
//					}
//					bfs(i,j,0);
//					cnt=0;
//					resetVisited();
//				}
//			}
//			System.out.println("#"+tc+" "+max);
//			max=0;
//		}
//	}
//	public static void bfs(int y,int x, int k){
//		Queue<bangbum>q = new LinkedList<>();
//		//System.out.println("시작 : +y"+y+" x: "+x+" k : "+k);
//		q.add(new bangbum(y,x,k));
//		visited[y][x]=true;
//		
//		while(!q.isEmpty()){
//			bangbum tmp = q.poll();
//			
//			for(int i=0;i<4;i++){
//				
//				int ny = tmp.y+dy[i];
//				int nx = tmp.x+dx[i];
//				int nk = tmp.k+1;
//				
//				if(ny<0 || nx<0 || nx>N-1 || ny>N-1){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//				visited[ny][nx]=true;
//				
//				q.add(new bangbum(ny,nx,nk));
//
//				if(arr[ny][nx]==1){
//				//	if(nk*nk+(nk-1)*(nk-1)<=(cnt+1)*M){
//						cnt++;
//			//		}
//				}
//				if(nk*nk+(nk-1)*(nk-1)<=(cnt+1)*M){
//					if(max<cnt){
//						max =cnt;
//					}
//				}
//			}			
//		}	
//		
//		if(max<cnt){
//			max =cnt;
//		}
//	}
//	public static void resetVisited(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				visited[i][j]=false;
//			}
//		}
//	}
//}
//class bangbum{
//	int y;
//	int x;
//	int k;
//
//	bangbum(int y, int x, int k){
//		this.y =y;
//		this.x =x;
//		this.k =k;
//	}
//}
