import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1987 {
	static int R;
	static int C;
	static int arr[][];
	static int cnt=0;
	static int max=0;
	static boolean visited[];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static Queue <String> q = new LinkedList<>();
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		R = in.nextInt();
		C = in.nextInt();
		
		arr = new int[R][C];
		visited = new boolean[26];
		
		
		for(int i =0;i<R;i++){
			String line = in.next();
			for(int j=0;j<C;j++){
				arr[i][j]=line.charAt(j)-'A';
				System.out.println(arr[i][j]);
			}
		}
		
		visited[arr[0][0]]=true;
		cnt++;
		
		dfs(0,0);
		System.out.println(max);
	}
	public static void dfs(int y, int x){
		if(max<cnt){
			max =cnt;
		}
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if((ny>=0 && nx>=0 && ny<=R-1 && nx<=C-1) && visited[arr[ny][nx]]==false){
				visited[arr[ny][nx]]=true;
				cnt++;
				dfs(ny,nx);
				visited[arr[ny][nx]]=false;
				cnt--;
			}
		}

	}
	public static void showArr(){
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
