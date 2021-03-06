import java.util.Scanner;

public class SwBrute {
	static int N;
	static int arr[] = {1,2,3};
	static boolean visited[];
	static int tmp[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		visited = new boolean[N];
		tmp = new int[N];
		
		//bubun(N,0);
		//combination(0,N,3,0);
		//factorialPrint(0);
	}
	public static void bubun2(){
		for(int i=0;i<(1<<N);i++){
			for(int j=0;j<N;j++){
				if((i & (1<<j))>0){
					System.out.print(j+" ");
				}
			}
			System.out.println("");
		}
	}
	public static void bubun(int n, int depth){
		
		if(n == depth){
			for(int i=0;i<N;i++){
				if(visited[i]==true){
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println("");
			return;
		}
		visited[depth]=true;
		bubun(n,depth+1);
		visited[depth]=false;
		bubun(n,depth+1);
	}
	public static void combination(int index, int n, int r, int target){
		if(r==0){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
		}
		else if(target == n){
			return;
		}
		else{
			tmp[index] = target;
			combination(index+1,N,r-1,target+1);
			combination(index,N,r,target+1);
		}
	}
	public static void factorialPrint(int index){
		if(index == N){
			for(int i=0;i<N;i++){
				System.out.print(tmp[i]);
			}
			System.out.println("");
			return;
		}
		for(int i=0;i<N;i++){
			if(!visited[i]){
				tmp[index] = arr[i];
				visited[i] = true;
				factorialPrint(index+1);
				visited[i] = false;
			}
		}
	}
	//조합 
	public static void dfs(int depth, int index){
		if(depth == 3){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=index;i<=N;i++){
			tmp[depth] = i;
			dfs(depth+1, i+1);//방금 전에 넣은 수보다큰 수들만 들어가야함!!!!
		}
	}
}
