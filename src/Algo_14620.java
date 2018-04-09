import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_14620 {
	static int N;
	static int arr[][];
	static int tmp[];
	static boolean visited[][];
	static int sum =0;
	static int min = Integer.MAX_VALUE;
	static int dy[]= {1,0,-1,0};
	static int dx[]= {0,1,0,-1};
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		tmp =new int[3];
		visited = new boolean[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0,0);
		
		System.out.println(min);
		
	}
	public static void combination(int depth, int index){
		if(depth==3){
			boolean flag = true;
			for(int i=0;i<3;i++){
				flag = bfs(tmp[i]/N, tmp[i]%N);
				if(flag == false){
					resetVisited();
					return;
				}
			}
			if(flag){ // 조건이 충족할 경우 
				checkSum();
				if(sum < min){
					min = sum;
				}
				sum =0;
				resetVisited();
				return;
			}		
			resetVisited();
			return;
		}
		
		for(int i=index;i<N*N;i++){
			tmp[depth] = i;
			combination(depth+1,i+1);
		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] =false;
			}
		}
	}
	public static boolean bfs(int y, int x){
		Queue<Flower>q = new LinkedList<Flower>();
		q.add(new Flower(y,x,0));
		visited[y][x] = true;
		
		while(!q.isEmpty()){
			Flower tmp = q.poll();
			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt +1;
				
				if(nCnt == 2){
					return true;
				}
				if(ny<0|| nx<0|| ny>=N || nx>=N){
					return false;
				}
				if(visited[ny][nx]){
					return false;
				}
				q.add(new Flower(ny,nx,nCnt));
				visited[ny][nx] = true;
			}
		}
		return true;
	}
	public static void showVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void checkSum(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(visited[i][j]){
					sum+=arr[i][j];
					if(sum>min){
						return;
					}
				}
			}
		}
	}
}
class Flower{
	int y;
	int x;
	int cnt;
	
	Flower(int y, int x, int cnt){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}