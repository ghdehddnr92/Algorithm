import java.util.Scanner;

public class Sw_1865 {
	static int T;
	static int N;
	static int arr[][];
	static int D[][];
	static int tmp[];
	static boolean visited[];
	static double result =1;
	static double max = 0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			arr = new int[N+1][N+1];
			D = new int[N+1][N+1];
			visited = new boolean[N+1];

			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					arr[i][j] = in.nextInt();
				}
			}
			D[1][1]= arr[1][1];

			for(int i=2;i<=N;i++){
				for(int j=1;j<=N-1;j++){
				//	D[i][i] = Math.max(D[i-1][i-1]*arr[i][i],arr[i][0] * );
				}
			}

			//tmp = new int[N+1];

			//factorialPrint(0);


			System.out.print("#"+t+" ");
			System.out.printf("%.6f",max*100);
		}
	}
	public static void factorialPrint(int index){
		result =1;
		if(index == N){
			int num=1;
			for(int i=0;i<N;i++){
				if(arr[num][tmp[i]]==0){
					return;
				}
				//System.out.print(tmp[i]+" ");
				result *=((double)arr[num][tmp[i]])/100;
				num++;
			}
			//System.out.println("");
			//System.out.println(result);
			if(result>max){
				max = result;
			}

			return;
		}
		for(int i=0;i<N;i++){
			if(!visited[i]){
				tmp[index] = i+1;
				visited[i]=true;
				factorialPrint(index+1);
				visited[i]=false;
			}		
		}	
	}

}
