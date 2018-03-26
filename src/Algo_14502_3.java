import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_14502_3 {
	static int N,M;
	static int arr[][];
	static int map[][];
	static int tmp[];
	static boolean visited[];
	static boolean check[][];
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	static int max =0;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		arr = new int[N][M];
		map = new int[N][M];
		tmp = new int[3];
		visited= new boolean [N*M];
		check = new boolean[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);

		System.out.println(max);
	}
	public static void makeMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				map[i][j] = arr[i][j];
			}
		}
	}
	public static void resetCheck(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				check[i][j] = false;
			}
		}
	}
	public static void sum(){
		int res =0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==0){
					res ++;
				}
			}
		}
		if(res >max){
			max = res;
//			System.out.println("-----------");
//			for(int i=0;i<N;i++){
//				for(int j=0;j<M;j++){
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println("");
//			}
		}
	}
	public static void bfs(int y, int x){
		Queue<Yunguso> q =new LinkedList<Yunguso>();
		q.add(new Yunguso(y,x));
		check[y][x] = true;

		while(!q.isEmpty()){
			Yunguso tmp = q.poll();

			for(int i=0;i<4;i++){
				int ny  = tmp.y+dy[i];
				int nx = tmp.x +dx[i];

				if(ny<0 || nx<0 || ny>=N || nx>=M){
					continue;
				}
				if(check[ny][nx]){
					continue;
				}

				if(map[ny][nx]==0){
					map[ny][nx]=2;
					q.add(new Yunguso(ny,nx));
					check[ny][nx] = true;
				}
			}
		}
	}
	public static void dfs(int index, int depth){
		if(index == 3){
			makeMap();
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			
			System.out.println("");
			if(map[tmp[0]/M][tmp[0]%M]==0 && map[tmp[1]/M][tmp[1]%M]==0 && map[tmp[2]/M][tmp[2]%M]==0){
				map[tmp[0]/M][tmp[0]%M] = 1 ;
				map[tmp[1]/M][tmp[1]%M] = 1;
				map[tmp[2]/M][tmp[2]%M] = 1 ;
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(map[i][j]==2){
						bfs(i,j);
					}
				}
			}
			sum();
			resetCheck();
			return;
		}

		for(int i=depth;i<N*M;i++){
			tmp[index]=i;
			dfs(index+1,i+1);
		}
	}
		
}
class Yunguso{
	int y;
	int x;

	Yunguso(int y, int x){
		this.y = y;
		this.x = x;
	}
}
