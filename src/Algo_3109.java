import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_3109 {
	static int R,C;
	static int arr[][];
	static boolean visited[][];
	static int dy[] = {-1,0,1};
	static int dx[] = {1,1,1};
	static int res = 0;
	static int max = 0;
	static boolean flag = false;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++){
			String line = br.readLine();
			for(int j=0;j<C;j++){
				if(line.charAt(j)=='.'){ // 빈칸 
					arr[i][j] = 0;
				}
				else{ //건물 
					arr[i][j] = 1;
				}
			}
		}

		//showArr();

		for(int i=0;i<R;i++){
			res += dfs(i,0);
		}
		System.out.println(res);
	}
	public static int dfs(int y,int x){
		visited[y][x] = true;
		if(x == C-1){
		//	showVisited();
		//	System.out.println("------------");
			//if(visited[y][C-1]){
				//res++;
			//}
			return 1;
	
		}
		for(int i=0;i<dx.length;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny>=R || nx>=C || ny<0 || nx <0){
				continue;
			}
			if(arr[ny][nx]==1){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			
			if(dfs(ny,nx) == 1){
				//System.out.println(ny+" "+nx);
				return 1;
			}
		}
		return 0;
	}
	public static void showArr(){
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void showVisited(){
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(visited[i][j]==true){
					System.out.print("t"+" ");
				}
				else{
					System.out.print("f"+" ");
				}

			}
			System.out.println("");
		}
	}
}
