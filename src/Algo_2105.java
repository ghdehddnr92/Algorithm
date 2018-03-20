import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_2105 {
	static int T;
	static int N;
	static int arr[][];
	
	static int dy[]={1,1,-1,-1}; 
	static int dx[]={1,-1,-1,1}; // 오른쪽 밑, 왼쪽 밑, 왼쪽 위,오른쪽 위 
	static boolean visited[][];
	static int max = 0;
	static int res = 0;
	static ArrayList<Integer> list;
	static int startY, startX;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
	
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<Integer>();
			
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N-2;i++){
				for(int j=1;j<N-1;j++){
					startY = i;
					startX = j;
					dfs(i,j,0);
					list.clear();
				}
			}
				
			if(max !=0){
				System.out.println("#"+t+" "+max);
			}
			else{
				System.out.println("#"+t+" "+-1);
			}
			max =0;
		}
	}
	public static void dfs(int y, int x,int d){
		visited[y][x] = true; // 방문 체크 
		list.add(arr[y][x]);
		//System.out.println(list);
		int lastX = x+dx[3];
		int lastY = y+dy[3];
		if((d==2 || d==3) && lastX >= 0 && lastY >= 0 && lastY <N && lastX <N && startX == lastX && lastY == startY){
		//	System.out.println(y+" "+x+" "+d);
			max = Math.max(max, list.size());
			return;
		}
		for(int i=d;i<4;i++){
			int ny= y+dy[i];
			int nx= x+dx[i];
			
			if(ny >= 0 && nx >= 0 && ny <N && nx <N && !visited[ny][nx] && !list.contains(arr[ny][nx])){
				dfs(ny,nx,i);
				//백트랙킹 
				visited[ny][nx] = false;
				list.remove(list.size() -1 );
			}
		}
	}
}
