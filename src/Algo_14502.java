import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_14502 {	
	static int N, M;
	static int arr[][];
	static int D[][];
	static boolean visited[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static int cnt=0;
	static int com[];
	public static void main(String[]args){
	
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		M = in.nextInt();
		arr= new int[N][M];
		visited = new boolean[N][M];
		D = new int[N][M];
		com = new int[N*M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j] = in.nextInt();
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				D[i][j] = arr[i][j];
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(D[i][j]==2 && visited[i][j]==false){
					bfs(i,j);
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(D[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println(cnt);
	}
	public static void bfs(int y, int x){
		Queue<Node>q = new LinkedList<>();
		q.add(new Node(y,x));
		visited[y][x] = true;
		Node tmp  = null;
		
		while(!q.isEmpty()){
			tmp = q.poll();
			
			for(int i=0;i<4;i++){
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];
				
				if(ny<0 || nx<0 ||nx>=M || ny >= N){
					continue;
				}
				if(visited[ny][nx]==true){
					continue;
				}
				if(D[ny][nx]==1){
					continue;
				}
				q.add(new Node(ny,nx));
				visited[ny][nx]= true;
				D[ny][nx]= 2;
				cnt++;
			}
		}
	}
	public static void combination(int index, int n,int r, int target){
		
	}
}
class Node{
	int x;
	int y;
	
	Node(int y,int x){
		this.y = y;
		this.x = x;
	}
}
