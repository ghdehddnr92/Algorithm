//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Algo_14502_2 {
//	static int N,M;
//	static int arr[][];
//	static int D[][];
//	static int dx[] ={0,0,1,-1};
//	static int dy[] ={1,-1,0,0};
//	static boolean visited[][];
//	static int cnt=0;
//	static int max=0;
//	public static void main(String[]args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String line ;
//		line = br.readLine();
//		StringTokenizer st = new StringTokenizer(line);
//
//		N= Integer.parseInt(st.nextToken());
//		M= Integer.parseInt(st.nextToken());
//		arr =new int[N][M];
//		D = new int[N][M];
//		visited = new boolean[N][M];
//		for(int i=0;i<N;i++){
//			line = br.readLine();
//			st = new StringTokenizer(line);
//			for(int j=0;j<M;j++){
//				arr[i][j] = Integer.parseInt(st.nextToken()+"");
//			}
//		}
//		setD();
//
//		//showD();
//		int combination[] =new int[3];
//		dfs(combination,0,N*M,3,0);
//		System.out.println(max);
//	}
//	public static void bfs(int y, int x){
//		Queue<Node> q = new LinkedList<>();
//		q.add(new Node(y,x));
//		visited[y][x] =true;
//		Node tmp=null;
//		while(!q.isEmpty()){
//			tmp=q.poll();
//
//			for(int i=0;i<4;i++){
//				int ny = tmp.y+dy[i];
//				int nx = tmp.x+dx[i];
//
//				if(ny<0 || nx<0 || nx>M-1 || ny>N-1){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//				if(D[ny][nx]==1){
//					continue;
//				}
//				D[ny][nx]=2;
//				q.add(new Node(ny,nx));
//				visited[ny][nx]=true;
//			}
//		}
//	}
//	public static void setD(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				D[i][j] = arr[i][j];
//			}
//		}
//	}
//	public static void setVisited(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				visited[i][j]=false;
//			}
//		}
//	}
//	public static void showD(){
//		System.out.println("-----------------------");
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				System.out.print(D[i][j]+" ");
//			}
//			System.out.println("");
//		}
//	}
//	public static void dfs(int combination[], int index, int n, int r, int target){
//		if(r==0){
//
//			if(D[combination[0]/M][combination[0]%M]==0 &&D[combination[1]/M][combination[1]%M]==0 &&D[combination[2]/M][combination[2]%M]==0){
//				for(int i=0;i<index;i++){
//					D[combination[i]/M][combination[i]%M]=1;
//				}
//				for(int i=0;i<N;i++){
//					for(int j=0;j<M;j++){
//						if(D[i][j]==2 && visited[i][j]==false){
//							bfs(i,j);
//						}
//					}
//				}
//				for(int i=0;i<N;i++){
//					for(int j=0;j<M;j++){
//						if(D[i][j]==0){
//							cnt++;
//						}
//					}
//				}
//				setVisited();
//				setD();
//				
//				if(cnt>max){
//					max =cnt;
//				}
//				cnt=0;
//			}
//		}
//		else if(target == n){
//			return;
//		}
//		else{
//			combination[index]=target;
//			dfs(combination,index+1,n,r-1,target+1);
//			dfs(combination,index,n,r,target+1);
//		}
//	}
//}
//class Node{
//	int y;
//	int x;
//
//	Node(int y,int x){
//		this.y =y;
//		this.x = x;
//	}
//}
