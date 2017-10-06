//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
// // 탈주범 검거 
//
//class Algo_1953 {
//	static int T,N,M,R,C,L;
//	static int arr[][];
//	static boolean visited[][];
//	static int dx[];
//	static int dy[];
//	static int cnt=1;
//	static int tCnt=1;
//	public static void main(String[]args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		T =Integer.parseInt(br.readLine());
//		
//		for(int t = 0; t<T;t++){
//			String line = br.readLine();
//			st =new StringTokenizer(line);
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			R = Integer.parseInt(st.nextToken());
//			C = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken());
//			
//			arr = new int[N][M];
//			visited = new boolean[N][M];
//			
//			for(int i=0;i<N;i++){
//				String tmp=br.readLine();
//				st =new StringTokenizer(tmp);
//				for(int j=0;j<M;j++){
//					arr[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			bfs(R,C);
//		}
//	}
//	public static void bfs(int y,int x){
//		Queue <Node> q = new LinkedList<Node>();
//		q.add(new Node(y,x,1));
//		visited[y][x] = true;
//		dx = new int[4];
//		dy = new int[4];
//		while(!q.isEmpty()){
//			Node tmp = q.poll();
//			Arrays.fill(dy, 0);
//			Arrays.fill(dx, 0);
//			if(arr[tmp.y][tmp.x]==1){
//				dx[2]=1;
//				dx[3]=-1;
//				dy[0]=1;
//				dy[1]=-1;
//			}
//			if(arr[tmp.y][tmp.x]==2){
//				dy[0]=1;
//				dy[1]=-1;
//			}
//			if(arr[tmp.y][tmp.x]==3){
//				dx[2]=1;
//				dx[3]=-1;
//			}
//			if(arr[tmp.y][tmp.x]==4){
//				dy[0]=1;
//				dx[2]=1;
//			}
//			if(arr[tmp.y][tmp.x]==5){
//				dy[1]=-1;
//				dx[2]=1;
//			}
//			if(arr[tmp.y][tmp.x]==6){
//				dy[1]=-1;
//				dx[3]=-1;
//			}
//			if(arr[tmp.y][tmp.x]==7){
//				dy[0]=1;
//				dx[3]=-1;
//			}
//			
//			for(int i=0;i<4;i++){
//				int nx = tmp.x+dx[i];
//				int ny = tmp.y+dy[i];
//				int nt = tmp.time +1;
//				if(nx<0 || ny<0 || ny>=N || nx >=M){
//					continue;
//				}
//				if(visited[ny][nx]==true){
//					continue;
//				}
//				if(arr[ny][nx]==0){
//					continue;
//				}
//				if(dx[i]==1){  // 우
//					if(arr[ny][nx]==2 || arr[ny][nx]==4 || arr[ny][nx]==5){
//						continue;
//					}
//				}
//				if(dx[i]==-1){ //좌
//					if(arr[ny][nx]==2||arr[ny][nx]==6||arr[ny][nx]==7){
//						continue;
//					}
//				}
//				if(dy[i]==-1) { //상
//					if(arr[ny][nx]==3 || arr[ny][nx]==4 || arr[ny][nx]==7){
//						continue;
//					}
//				}
//				if(dy[i]==1){ //하 
//					if(arr[ny][nx]==3 || arr[ny][nx]==5 || arr[ny][nx]==6){
//						continue;
//					}
//				}
//
//				//System.out.println("x, y ny , nx nt:"+tmp.x+" "+tmp.y+" "+dx[i]+" "+dy[i]+" "+ny+" "+nx +" "+nt);
//				q.add(new Node(ny,nx,nt));
//				cnt++;
//				visited[ny][nx]=true;
//			}
//			if(tmp.time == (L-1)){
//				System.out.println("#"+tCnt+" "+cnt);
//				cnt=1;
//				tCnt++;
//				return;
//			}
//		}
//	}
//}
//class Node{
//	int y;
//	int x;
//	int time;
//	Node(int y, int x, int time){
//		this.y = y;
//		this.x = x;
//		this.time = time;
//	}
//}