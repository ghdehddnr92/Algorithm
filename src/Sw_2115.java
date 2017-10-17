import java.util.Scanner;

public class Sw_2115 {
	static int T;
	static int N, M ,C;
	static int arr[][];
	static boolean visited[][];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T =in.nextInt();
		int t=0;
		while(t++ <=T){
			N =in.nextInt();
			M =in.nextInt();
			C= in.nextInt();
			
			arr = new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					arr[i][j] = in.nextInt();
				}
			}
			
		}
	}
}
