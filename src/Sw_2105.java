import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_2105 {
	static int T;
	static int N;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {1,-1,-1,1};
	static int dy[] = {1,1,-1,-1};
	static int cnt=0;
	static int max=0;
	static int startY;
	static int startX;
	static Queue<Integer>q;
	public static void main(String[]args) throws NumberFormatException, IOException{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		q =new LinkedList<>();
		for(int i= 0;i<N;i++){
			String line=br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(br.readLine());
			}
		}
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				startY =i;
				startX =j;
				dfs(i,j,1);
				q.clear();
			}
		}
	}
	public static void dfs(int y, int x,int l){

		visited[y][x]=true;
		q.add(arr[y][x]);
		
		for(int i=0;i<4;i++){
			int ny = y +dy[i];
			int nx = x +dx[i];
			
			if(ny<0 || nx<0 || ny>N-1 || nx>N-1){
				continue;
			}
			if(visited[ny][nx]==true && (ny!=startY && nx !=startX)){
				continue;
			}
			if(q.contains(arr[ny][nx])&&(ny!=startY && nx !=startX)){
				continue;
			}
			q.add(arr[ny][nx]);
			dfs(ny,nx,l+1);
		}
	}
}