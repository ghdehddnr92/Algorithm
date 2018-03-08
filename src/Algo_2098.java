import java.util.Scanner;

public class Algo_2098 {
	static int N;
	static int arr[][];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = in.nextInt();
			}
		}
		
	}
}
