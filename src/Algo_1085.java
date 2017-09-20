import java.util.Scanner;

public class Algo_1085 {
	static int x,y,w,h;
	public static void main(String[]args){
		Scanner in= new Scanner(System.in);
		
		x= in.nextInt();
		y=in.nextInt();
		w=in.nextInt();
		h = in.nextInt();
		
	
		
		System.out.println(Math.min(Math.min(Math.min(x, y),w-x),h-y));
	}
}
