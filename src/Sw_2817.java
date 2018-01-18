import java.util.Scanner;

public class Sw_2817 {
	static int T;
	static int N;
	static int K;
	static int arr[];
	static boolean visited[];
	static int cnt=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T= in.nextInt();
		
		for(int t=1;t<=T;t++){
			N = in.nextInt();
			K = in.nextInt();
			arr = new int[N];
			visited = new boolean [N];
			for(int i=0;i<N;i++){
				arr[i] = in.nextInt();
			}
			
			dfs(N,0);
			System.out.println("#"+t+" "+cnt);
			cnt =0;
		}
	}
	public static void dfs(int n, int depth){
		int sum= 0;
		if(depth == n){
			for(int i=0;i<depth;i++){
				if(visited[i]){
					//System.out.print(arr[i]+" ");
					sum+=arr[i];
					if(sum>K){
						return;
					}
				}
			}
			//System.out.println("");
			if(sum==K){
				cnt++;
			}
			return;
		}
		visited[depth] = true;
		dfs(n,depth+1);
		visited[depth] =false;
		dfs(n,depth+1);
	}
}
