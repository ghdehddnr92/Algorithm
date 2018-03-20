import java.util.Scanner;

public class Algo_2210 {
	static int arr[][];
	static int dy[]= {1,0,-1,0};
	static int dx[]= {0,1,0,-1};
	static boolean visited[];
	static int res =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		arr = new int[5][5];
		visited = new boolean[1000000];
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				arr[i][j] = in.nextInt();
			}
		}
		
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				dfs(i,j,0,"");
			}
		}
		System.out.println(res);
	}
	public static void dfs(int y, int x, int cnt,String line){
		if(cnt == 6){
			if(!visited[Integer.parseInt(line)]){
				res ++;
			//	System.out.println(line);
				visited[Integer.parseInt(line)] = true;
			}
			return;
		}
		
		for(int i=0;i<4;i++){
			int ny = y +dy[i];
			int nx = x +dx[i];
			int nCnt = cnt+1;
			
			if(ny <0 || nx<0 || ny>=5 || nx>=5){
				continue;
			}
			
			dfs(ny,nx,nCnt,line+String.valueOf(arr[ny][nx]));
		}
	}
}
