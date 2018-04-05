import java.util.Scanner;

public class Algo_9207 {
	static int N;
	static String arr[][];
	public static void main(String[]args){
		Scanner in =new Scanner(System.in);

		N= in.nextInt();


		for(int t=0;t<N;t++){
			arr =new String[5][9];

			for(int i=0;i<5;i++){
				String line = in.next();
				for(int j=0;j<9;j++){
					arr[i][j]= line.charAt(j)+"";
				}
			}	
			
		}
	}
}
