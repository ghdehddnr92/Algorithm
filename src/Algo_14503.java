import java.util.Scanner;

public class Algo_14503 {
	static int N,M,r,c,d;
	static int arr[][];
	static boolean visited[][];
	static int cnt=0;
	public static void main(String[]args){
	
		Scanner in = new Scanner(System.in);
		N= in.nextInt();
		M=in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		
		arr= new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j] =in.nextInt();
			}
		}
		visited[r][c]=true;
		dfs(r,c,d);
		
		System.out.println(cnt);
		
	}
	public static void dfs(int y, int x, int d){
		
		if(d==0){ //북 
			d=3;
		}
		else if(d==1){ // 동  
			d=0;
		}
		else if(d==2){ //남 
			d=1;
		}
		else{//서 
			d=2;
		}
		if(arr[y][x-1]==1){
			
		}
		else{
			
		}
		
	}
}
