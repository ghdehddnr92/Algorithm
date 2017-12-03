import java.util.Scanner;

public class Algo_14888 {
	static int plus;
	static int minus;
	static int mul;
	static int div;
	static int N;
	static int arr[];
	static int math[];
	static int max = -1;
	static int min = 999999999;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr =  new int[N];
		math = new int[N-1];
		for(int i=0;i<N;i++){
			arr[i] = in.nextInt();
		}
		
		plus  = in.nextInt(); //1
		minus = in.nextInt(); //2
		mul = in.nextInt();  //3
		div = in.nextInt(); //4
	
		
		for(int i=0;i<N;i++){
			
		}
	}
}
