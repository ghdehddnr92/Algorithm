import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_11559 {
	static String arr[][];
	static int res =0;
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static boolean visited[][];
	static int cnt =0;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new String[12][6];
		visited = new boolean[12][6];
		
		StringTokenizer st;
		for(int i=0;i<12;i++){
			String line = br.readLine();
			for(int j=0;j<6;j++){
				arr[i][j] = line.charAt(j)+"";
			}
		}

		if(!check()){
			System.out.println(0);
		}
		else{
			cnt =0;
			resetVisited();
			solve();
			System.out.println(res);
		}
	}
	public static void solve(){

		while(true){
			checkBoom();
			//showArr();
			res++;
			move();
		//	showArr();
			if(!check()){
				break;
			}

		}
	}
	public static boolean check(){
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){		
				if(!arr[i][j].equals(".")){
					cnt++;
					for(int k=0;k<4;k++){
						int ny = i+dy[k];
						int nx = j+dx[k];

						if(ny<0 ||nx<0 || ny>=12 || nx>=6){
							continue;
						}
						if(arr[ny][nx].equals(arr[i][j])){
							bfs(ny,nx);
						}
					}
					if(cnt>=4){
						return true;
					}
					cnt = 0;
				}
			}
		}
		return false;
	}
	public static void checkBoom(){
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){		
				if(!arr[i][j].equals(".")){
					cnt++;
					for(int k=0;k<4;k++){
						int ny = i+dy[k];
						int nx = j+dx[k];

						if(ny<0 ||nx<0 || ny>=12 || nx>=6){
							continue;
						}
						if(arr[ny][nx].equals(arr[i][j])){
							bfs(ny,nx);
						}
					}
					if(cnt>=4){
						//		System.out.println(i+" "+j);
						//		System.out.println(cnt);
						boom();
						//showArr();
						//		move();
						//showVisited();
						//	showArr();
						//		res++;
					}
					cnt = 0;
					resetVisited();
				}
			}
		}
	}
	public static void showVisited(){
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void bfs(int y,int x){
		Queue<Puyo> q = new LinkedList<Puyo>();
		visited[y][x] = true;
		q.add(new Puyo(y,x));

		while(!q.isEmpty()){
			Puyo tmp = q.poll();

			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];

				if(ny<0 || nx<0 || ny>=12|| nx>=6){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}
				if(!arr[ny][nx].equals(arr[y][x])){
					continue;
				}
				visited[ny][nx] = true;
				cnt++;
				q.add(new Puyo(ny,nx));
			}
		}
	}
	public static void boom(){
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){
				if(visited[i][j]){
					arr[i][j]=".";
				}
			}
		}
	}
	public static void move(){
		for(int i=10;i>=0;i--){
			for(int j=0;j<6;j++){
				if(!arr[i][j].equals(".")){
					int k=0;
					for(k=i+1;k<=11;k++){
						if(!arr[k][j].equals(".")){
							break;
						}
					}
					if(arr[k-1][j].equals(".")){
						arr[k-1][j] = arr[i][j];
						arr[i][j]=".";
					}
				}
			}
		}
	}

	public static void showArr(){
		System.out.println("--------------------");
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void resetVisited(){
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){
				visited[i][j]=false;
			}
		}
	}
}
class Puyo{
	int y;
	int x;
	Puyo(int y,int x){
		this.y = y;
		this.x = x;
	}
}