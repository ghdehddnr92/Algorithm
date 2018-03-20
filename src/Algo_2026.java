import java.util.Arrays;
import java.util.Scanner;

public class Algo_2026 {
	static int K,N,F;
	static int arr[][];
	static int tmp[];
	static int tmp2[];
	static boolean flag = true;
	static boolean visited[];
	public static void main(String[]args){
		Scanner in  = new Scanner(System.in);

		K = in.nextInt();
		N = in.nextInt();
		F = in.nextInt();
		arr = new int[N+1][N+1];
		tmp = new int[K+1];
		tmp2 = new int[2];
		visited = new boolean[N+1];
		for(int i=0;i<8;i++){
			int y = in.nextInt();
			int x = in.nextInt();

			arr[y][x] = 1;
		}
		//combination(0,N,K,1);
		dfs(0,1);
	}
	public static void dfs(int depth, int index){
		if(depth == K){

			flag = true;
			dfs2(0,1);

			if(flag == true){
				for(int i=0;i<K;i++){
					System.out.println(tmp[i]);
				}
				return;
			}
			return;
		}
		
		for(int i=index;i<=N;i++){
			tmp[depth] = i;
			dfs(depth+1, i+1);//방금 전에 넣은 수보다큰 수들만 들어가야함!!!!
		}
	}
	public static void dfs2(int depth, int index){
		if(depth == 2){

			if(arr[tmp2[0]][tmp2[1]]==0){
				flag = false;
				return;
			}
			return;
		}
		
		for(int i=index;i<=K;i++){
			tmp2[depth] = tmp[i-1];
			dfs2(depth+1, i+1);//방금 전에 넣은 수보다큰 수들만 들어가야함!!!!
		}
	}
}
