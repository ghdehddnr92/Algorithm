import java.util.Scanner;

public class Algo_3053 {
	static int r;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		r = in.nextInt();
		Double result;
		result = r*r*Math.PI;
		System.out.printf("%.6f",result);
		System.out.println("");	
		result = r*r*2.0;
		System.out.printf("%.6f",result);	
	}
}
