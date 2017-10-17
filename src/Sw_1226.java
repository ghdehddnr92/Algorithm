import java.util.Scanner;

public class Sw_1226 {
	static int arr[][];
	static int T;
	static int res =0;
	static boolean visited[][];
	static int flag=0;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[]args){
		
		Scanner in = new Scanner(System.in);
	
		for(int t=0;t<10;t++){
			T = in.nextInt();

			arr = new int[100][100];
			visited = new boolean[100][100];
			for(int i=0;i<100;i++){
				String line = in.next();
				for(int j=0;j<100;j++){
					arr[i][j]=Integer.parseInt(line.charAt(j)+"");
				}
			}
			for(int i=0;i<100;i++){
				for(int j=0;j<100;j++){
					if(arr[i][j]==2 && visited[i][j]==false){
						dfs(i,j);
					}
				}
			}

			System.out.println("#"+T+" "+res);
			res=0;
		}
	}
	public static void dfs(int y, int x){
		visited[y][x]=true;
		
		if(arr[y][x]==3){
			res =1;
			return;
		}
		for(int i=0;i<4;i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(ny<0 || nx<0 || ny>99 || nx>99){
				continue;
			}
			if(visited[ny][nx]==true){
				continue;
			}
			if(arr[ny][nx]==1){
				continue;
			}
			
			dfs(ny,nx);
			visited[ny][nx]=true;
		}	
	}
}
