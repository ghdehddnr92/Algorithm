import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sw_2819 {
	static int T;
	static int arr[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static int min = Integer.MAX_VALUE;
	static int max = 0;
	//static Queue <String> q = new LinkedList<String>();
	static int res[];
	static PriorityQueue<String>q = new PriorityQueue<String>();
	static long result=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T= in.nextInt();

		for(int t=1;t<=T;t++){

			arr = new int[4][4];
			res = new int[10000000];
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					arr[i][j] = in.nextInt();
				}
			}

			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					dfs(i,j, 0,""+arr[i][j]);
				}
			}

			System.out.println("#"+t+" "+result);
			result=0;
		}
	}

	public static void dfs(int y, int x, int depth,String line){

		if(depth==6){

			if(res[Integer.parseInt(line)]==0){
				res[Integer.parseInt(line)]=1;
				result++;
			}
			return;
		}
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx<0 || ny>3 || nx>3){
				continue;
			}

			dfs(ny,nx,depth+1,line+arr[ny][nx]);
		}
	}
}
