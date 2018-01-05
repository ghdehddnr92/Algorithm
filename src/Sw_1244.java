import java.util.Scanner;

public class Sw_1244 {
	static int T;
	static int changeCnt;
	static int money;
	static String line;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T  = in.nextInt();
		for(int t=1;t<=T;t++){
			money = in.nextInt();
			changeCnt = in.nextInt();
			
			line = String.valueOf(money);
			int maxChar = line.charAt(0);
			int maxIndex = 0;
			for(int i=0;i<changeCnt;i++){
				for(int l=1;l<line.length();l++){
					if(line.charAt(l)>maxChar){
						maxChar = line.charAt(l);
						maxIndex = l;
					}
				}
			}
			char tmp;
			for(int i=0;i<maxIndex-1;i++){
				if(line.charAt(i) < line.charAt(maxIndex)){
					tmp = line.charAt(i);
					
				}
			}
		}
	}
}
