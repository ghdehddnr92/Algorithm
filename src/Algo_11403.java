import java.util.Arrays;
import java.util.Scanner;

public class Algo_11403 {
	static int n;
	static int arr[][];
	static int visited[];
	static int ad[][];
	public static void main(String[]args){
		Scanner in  = new Scanner(System.in);
		n = in.nextInt();
		arr= new int[n][n];
		visited = new int[n];
		ad = new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]= in.nextInt();
			}
		}
		for(int i=0;i<n;i++){
			Arrays.fill(visited, 0);
			//System.out.println("i :"+ i);
			dfs(i);
			
			for(int j=0;j<n;j++){
				ad[i][j] = visited[j];
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(ad[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void dfs(int start){
		//System.out.println("bfs start: "+start);
		for(int i=0;i<n;i++){
			if(arr[start][i]==1 && visited[i]==0){
				visited[i]=1;
				dfs(i);	
			}
		}
	}
}
