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
	static int max=0;
	static int com[];
	static int count=0;
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
		resetD();
		
		for(int i=0;i<N*M-2;i++){
			for(int j=i+1;j<N*M-1;j++){
				for(int k=j+1;k<N*M;k++){
					if(i!=j && j!=k){
						if(D[i/M][i%M]==0 &&D[j/M][j%M]==0&& D[k/M][k%M]==0){
							D[i/M][i%M]=1;
							D[j/M][j%M]=1;
							D[k/M][k%M]=1;
							for(int n=0;n<N;n++){
								for(int m=0;m<M;m++){
									if(D[n][m]==2 && visited[n][m]==false){
										bfs(n,m);
									}
								}
							}
							for(int n=0;n<N;n++){
								for(int m=0;m<M;m++){
									if(D[n][m]==0){
										cnt++;
									}
								}
							}
							if(max<cnt){
								max=cnt;
							}
							resetD();
							resetVisited();
							cnt=0;
						}

					}
				}
			}
		}

		System.out.println(max);
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
			}
		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				visited[i][j]= false;
			}
		}
	}
	public static void resetD(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				D[i][j]=arr[i][j];
			}
		}
	}
	public static void showD(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(D[i][j]+" ");
			}
			System.out.println("");
		}
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
