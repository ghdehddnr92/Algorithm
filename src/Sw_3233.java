import java.math.BigInteger;
import java.util.Scanner;

public class Sw_3233 {
	static int T;
	static long A,B;
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		
		for(int t=1;t<=T;t++){
			A= in.nextInt();
			B = in.nextInt();
			BigInteger bigA = new BigInteger(String.valueOf(A*A));
			BigInteger bigB = new BigInteger(String.valueOf(B*B));
			System.out.println("#"+t+" "+bigA.divide(bigB));
		}
	}
}
