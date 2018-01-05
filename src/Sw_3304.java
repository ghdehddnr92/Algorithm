import java.util.Scanner;

public class Sw_3304 {
	static int T;
	static String A,B;
	static int max = 0;
	static int table[][];	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		for(int t =1; t<=T; t++){
			A = in.next();
			B = in.next();
			A = '0'+A;
			B = '0'+B;
			table = new int[B.length()+1][A.length()+1];
			
			solve();
			System.out.println("#"+t+" "+max);
			max=0;
		}
	}	
	
	public static void solve(){
		for(int i=1;i<B.length();i++){
			for(int j= 1;j<A.length();j++){
				if(B.charAt(i) == A.charAt(j)){
					table[i][j] = table[i-1][j-1]+1;
				}
				else{
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
				if(max<table[i][j]){
					max = table[i][j];
				}
			}
		}
		
//		for(int i=0;i<A.length();i++){
//			for(int j=0;j<B.length();j++){
//				System.out.print(table[i][j]+" ");
//			}
//			System.out.println("");
//		}
	}
}
