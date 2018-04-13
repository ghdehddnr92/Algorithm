import java.util.Scanner;

public class Sw_2115_3 {
	static int N;
	static int T;
	static int M;
	static int C;
	static int arr[][];
	static int tmp[];
	static boolean visited[][];
	static int firstMax =0;
	static int secondMax = 0;
	static int res =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();
			C = in.nextInt();
			arr =new int[N][N];
			visited =new boolean[N][N];
			tmp = new int[M];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					arr[i][j]= in.nextInt();
				}
			}

			solve();

			System.out.println("#"+t+" "+(firstMax+secondMax));
			firstMax = 0;
			secondMax = 0;
			res =0;
		}
	}
	public static void solve(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				dfs(0,i,j);
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]){
					dfs2(0,i,j);
				}
			}
		}
	}
	public static void dfs(int index, int y, int x){
		if(index == M){
			checkMax();
			if(res> firstMax){
				firstMax = res;
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						visited[i][j] = false;
					}
				}
				for(int i=x-1;i>=(x-M);i--){
					visited[y][i] = true;
				}
				res =0;
			}
			res =0;
			return;
		}
		if(x>=N){
			return;
		}

		tmp[index] = arr[y][x];
		dfs(index+1,y,x+1);
	}
	public static void dfs2(int index, int y, int x){
		if(index == M){
			checkMax();
			if(res> secondMax){
				secondMax = res;
				res =0;
			}
			res =0;
			return;
		}
		if(x>=N){
			return;
		}
		if(visited[y][x]){
			return;
		}
		tmp[index] = arr[y][x];
		dfs2(index+1,y,x+1);
	}

	public static void showVisited(){
		System.out.println("-------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void checkMax(){
		int sum =0;
		int max = 0;
		for(int i=0;i<M;i++){
			sum+=tmp[i];
		}
		if(sum<=C){
			for(int i=0;i<M;i++){
				res += (tmp[i]*tmp[i]);
			}
		}
		else{
			for(int i=0;i<(1<<M);i++){
				sum =0;
				res =0;
				for(int j=0;j<M;j++){
					if((i & (1<<j))>0){
						sum+= tmp[j];
						res += (tmp[j]*tmp[j]);
					}
				}
				if(sum>C){
					res = 0;
				}
				else{
					if(res > max){
						max = res;
					}
				}
				res =0;
				sum=0;
			}
			res = max;
		}
	}
}
