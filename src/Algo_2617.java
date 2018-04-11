import java.io.IOException;
import java.util.Scanner;

public class Algo_2617 {

	static int N,M;
	static int arr[][];
	public static void main(String[]args) throws NumberFormatException, IOException{
		Scanner in = new Scanner(System.in);
		N= in.nextInt();
		M= in.nextInt();
		
		arr = new int[M][2];
		
		for(int i=0;i<M;i++){
			for(int j=0;j<2;j++){
				arr[i][j] = in.nextInt();
			}
		}
	
	}
}