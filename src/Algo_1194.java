import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_1194 {
	static int N,M;
	static boolean visited[][][];
	static String arr[][];
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	static int res = -1;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

	
		StringTokenizer st; 
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new String[N][M];
			visited = new boolean[N][M][1<<5+1];

			for(int i=0;i<N;i++){
				String line = br.readLine();
				for(int j=0;j<M;j++){
					arr[i][j] = line.charAt(j)+"";
				}
			}

			solve();
			System.out.println(res);
			res =-1;
	}
	public static void solve(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j].equals("0")){
					bfs(i,j);
				}
			}
		}
	}
	public static void bfs(int y,int x){
		Queue<Moon> q= new LinkedList<Moon>();
		q.add(new Moon(y,x,0));
		visited[y][x][0] = true;
		int time = 1;
		while(!q.isEmpty()){
			int qSize = q.size();

			for(int size = 0;size<qSize;size++){
				Moon tmp = q.poll();

				for(int i=0;i<4;i++){
					int ny = tmp.y+dy[i];
					int nx = tmp.x+dx[i];
					int nKey = tmp.key;
					
					if(ny<0 || nx< 0 || ny>=N || nx>=M){
						continue;
					}
				//	System.out.println(ny+" "+nx+" "+nKey);
					if(visited[ny][nx][nKey]){
				//		System.out.println("이미 방문 ");
						continue;
					}
					if(arr[ny][nx].equals("#")){
					//	System.out.println("# 이어서 못감");
						continue;
					}
					if(arr[ny][nx].equals("a")||arr[ny][nx].equals("b")
							||arr[ny][nx].equals("c")||arr[ny][nx].equals("d")
							||arr[ny][nx].equals("e")||arr[ny][nx].equals("f")){
						nKey |= (1<<arr[ny][nx].charAt(0)-'a');
					}
					if(arr[ny][nx].equals("A")||arr[ny][nx].equals("B")
							||arr[ny][nx].equals("C")||arr[ny][nx].equals("D")
							||arr[ny][nx].equals("E")||arr[ny][nx].equals("F")){
						if((nKey & (1<<arr[ny][nx].charAt(0)-'A'))<=0){
							continue;
						}	
					}
					if(arr[ny][nx].equals("1")){
						res = time;
						return;
					}
					q.add(new Moon(ny,nx,nKey));
					visited[ny][nx][nKey] = true;
				}
			}
			time++;	
		}
	}
}

class Moon{
	int y;
	int x;
	int key;
	
	Moon(int y, int x,int key){
		this.y = y;
		this.x = x;
		this.key = key;
	}
}