import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_2638 {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();

		arr = new int[N][M];

		visited =new boolean [N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j] = in.nextInt();
			}
		}
		int time = 0;
		
		while(true){
			if(check()){
				break;
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					visited[i][j] = false;
				}
			}
			
			int cnt =2; 
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(!visited[i][j] && arr[i][j]==0){
						bfs(i,j,cnt);
						cnt++;
					}
				}
			}
			boolean visited2[][] = new boolean[N][M];
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(arr[i][j]==1){
						int twoCnt =0;
						for(int k=0;k<4;k++){
							int ny =i+dy[k];
							int nx =j+dx[k];

							if(ny<0|| nx<0 || ny>=N || nx>=M){
								continue;
							}
							if(arr[ny][nx]==2){
								twoCnt++;
							}
						}
						if(twoCnt>=2){
							visited2[i][j] = true;
						}
						twoCnt =0;
					}
				}
			}
			
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(visited2[i][j]){
						arr[i][j]= 0;
					}
					else if(!visited2[i][j] && arr[i][j]!=1){
						arr[i][j] = 0;
					}
				}
			}

			time++;
		}
		System.out.println(time);
	}
	public static boolean check(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(arr[i][j]==1){
					return false;
				}
			}
		}
		return true;
	}
	public static void bfs(int y, int x, int cnt){
		Queue<Cheeze>q = new LinkedList<Cheeze>();
		q.add(new Cheeze(y,x));
		visited[y][x] = true;
		arr[y][x] = cnt;
		while(!q.isEmpty()){
			int qSize = q.size();

			for(int size= 0; size<qSize;size++){

				Cheeze tmp = q.poll();
				for(int i=0;i<4;i++){
					int ny = tmp.y+dy[i];
					int nx = tmp.x+dx[i];

					if(ny<0||nx<0|| ny>=N || nx>=M){
						continue;
					}
					if(visited[ny][nx]){
						continue;
					}
					if(arr[ny][nx]==1){
						continue;
					}
					arr[ny][nx]=cnt;
					visited[ny][nx] = true;
					q.add(new Cheeze(ny,nx));
				}
			}

		}
	}
}
class Cheeze{
	int y;
	int x;

	Cheeze(int y, int x){
		this.y = y;
		this.x = x;
	}
}