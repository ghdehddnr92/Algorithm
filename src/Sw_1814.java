import java.util.Scanner;

public class Sw_1814 {
	static int T;
	static int N;
	static int arr[][];
	static int check[][];
	static boolean tmp[][];
	static boolean visited[];
	static int cnt = 0;
	static String result;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T= in.nextInt();
		
		for(int t=1;t<=T;t++){
			N = in.nextInt();
			arr = new int[2][N];
			tmp = new boolean[N][N];
			visited = new boolean[N*N];
			for(int i=0;i<2;i++){
				for(int j=0;j<N;j++){
					arr[i][j] = in.nextInt();
				}
			}
			dfs(N*N,0);
		//	System.out.println(cnt);
			if(cnt ==1){
				result = "YES";
			}
			else{
				result = "NO";
			}
			System.out.println("#"+t+" "+result);
			cnt=0;
		}
	}
	public static void dfs(int n, int depth){	

		if(depth == n){
			for(int i=0;i<n;i++){
				if(visited[i]==true){
					tmp[i/N][i%N]=true;
				}
			}
			boolean flag = true;
			
			if(colorCheck(flag)){ //같을 경우 
				cnt++;
			}
			resetTmp();
			return;
		}
		visited[depth] = true;
		dfs(n, depth+1);
		visited[depth] = false;
		dfs(n, depth+1);
	}
	public static boolean colorCheck(boolean flag){
		check = new int [2][N];
	
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(tmp[i][j]==true){
					check[0][i%N]+=1;
					check[1][j%N]+=1;
				}
			}
		}

		for(int i=0;i<2;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j]!=check[i][j]){
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}
	public static void resetTmp(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				tmp[i][j] = false;
			}
		}
	}
}
