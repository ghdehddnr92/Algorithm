import java.util.Scanner;

public class Sw_1989 {
	static int T;
	static String line;
	static int res=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for(int t=0;t<T;t++){
			line = in.next();
			check(t);
		}
	}
	public static void check(int t){
		//System.out.println(line.length());
		//if(line.length()/2==0){
			for(int i=0;i<line.length()/2;i++){
				if(line.charAt(i)!=line.charAt(line.length()-1-i)){
					System.out.println("#"+(t+1)+" "+res);
					return;
				}
			}
			res =1;
			System.out.println("#"+(t+1)+" "+res);
			res=0;
			return;
	}
}
