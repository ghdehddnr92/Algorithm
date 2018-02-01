import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw_3376 {
	static int T;
	static int N;
	static long D[];
	public static void main(String[]args) throws NumberFormatException, IOException{
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		D = new long[101];
		D[1] = 1;
		D[2] = 1;
		D[3] = 1;
		D[4] = 2;
		D[5] = 2;
		D[6] = 3; 
		D[7] = 4;
		for(int i=8;i<=100;i++){
			D[i] = D[i-1]+D[i-5];
		}
		
		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			System.out.println("#"+t+" "+D[N]);
			
		}
	}
}
