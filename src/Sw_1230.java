import java.util.Scanner;
import java.util.StringTokenizer;

public class Sw_1230 {
	static int length;
	static int arr[];
	static int command;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
	
		length =in.nextInt();
		arr = new int[length];
		
		for(int i=0;i<length;i++){
			arr[i]= in.nextInt();
		}
		command= in.nextInt();
		String line = "";
		line= in.nextLine();
		
		StringTokenizer st = new StringTokenizer(line);
		String com;
		com=st.nextToken();
		System.out.println(com);
		
	}
}
